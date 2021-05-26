package com.forex.controllers;

import com.forex.domain.Currency;
import com.forex.domain.PredictionData;
import com.forex.domain.RealData;
import com.forex.domain.User;
import com.forex.repository.PredictionRepository;
import com.forex.repository.RealDataRepository;
import com.forex.repository.UserRepository;
import com.forex.service.CustomUserDetailsService;
import com.forex.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class UserPanelController {

    @Autowired
    private CustomUserDetailsService userService;

    @Autowired
    private PredictionRepository pr;

    @Autowired
    PredictionService ps;

    @RequestMapping(value = "/user-home", method = RequestMethod.GET)
    public ModelAndView userhome() throws ParseException {

        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        modelAndView.addObject("user", userService.findUserByEmail(auth.getName()));
        String currency = userService.findUserByEmail(auth.getName()).getCurrency();
        PredictionData pd = ps.findLatestByCurrency(currency);
        modelAndView.addObject("currency", pd.getCurrency());
        modelAndView.addObject("buy", pd.getBuy());

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateAfter = formatter.format(calendar.getTime());
        calendar.add(Calendar.DATE, -30);
        String dateBefore = formatter.format(calendar.getTime());

        List<RealData> data = realDataRepository.findByCurrencyAndDateBetweenOrderByDateAsc(currency,dateBefore,dateAfter);
        List<String> date = new ArrayList<>();
        List<Float> open = new ArrayList<>();
        List<Float> high = new ArrayList<>();
        List<Float> low = new ArrayList<>();
        List<Float> close = new ArrayList<>();
        List<Float> ema = new ArrayList<>();

        for(RealData dataObject: data) {
            date.add(dataObject.getDate());
            open.add(dataObject.getOpen());
            high.add(dataObject.getHigh());
            low.add(dataObject.getLow());
            close.add(dataObject.getClose());
            ema.add(dataObject.getEma());
        }

        modelAndView.addObject("currency",currency);
        modelAndView.addObject("date", date);
        modelAndView.addObject("open", open);
        modelAndView.addObject("high", high);
        modelAndView.addObject("low", low);
        modelAndView.addObject("close", close);
        modelAndView.addObject("ema",ema);


        modelAndView.setViewName("user-home");
        return modelAndView;
    }

    @RequestMapping(value = "/user-info", method = RequestMethod.GET)
    public ModelAndView userinfo() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("user", user);
        modelAndView.addObject("currencies", new Currency().getCurrencies());
        modelAndView.setViewName("user-info");
        return modelAndView;
    }


   
    @RequestMapping(value = "/user-edit", method = RequestMethod.GET)
    public ModelAndView useredit() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user-edit");
        return modelAndView;
    }

    @RequestMapping(value = "/edit-account", method = RequestMethod.POST)
    public ModelAndView userupdate(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("user-edit");
        } else {
            userService.updateUser(user);
            modelAndView.addObject("successMessage", "User has been edited successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("login");

        }
        return modelAndView;
    }


    @RequestMapping(value = "/user-currency", method = RequestMethod.POST)
    public ModelAndView usercurrency(String currency) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        userService.updateCurrency(user, currency);
        ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("successMessage", "Currency set");
            modelAndView.setViewName("redirect:/user-home");
        return modelAndView;
    }


    @Autowired
    private RealDataRepository realDataRepository;

    /*
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public ModelAndView getRealData(@RequestParam String currency, @RequestParam String dateBefore, @RequestParam String dateAfter) {
        ModelAndView modelAndView = new ModelAndView();

        List<RealData> data = realDataRepository.findByCurrencyAndDateBetweenOrderByDateAsc(currency,dateBefore,dateAfter);
        List<String> date = new ArrayList<>();
        List<Float> open = new ArrayList<>();
        List<Float> high = new ArrayList<>();
        List<Float> low = new ArrayList<>();
        List<Float> close = new ArrayList<>();
        List<Float> ema = new ArrayList<>();

        for(RealData dataObject: data) {
            date.add(dataObject.getDate());
            open.add(dataObject.getOpen());
            high.add(dataObject.getHigh());
            low.add(dataObject.getLow());
            close.add(dataObject.getClose());
            ema.add(dataObject.getEma());
        }
        modelAndView.addObject("currency",currency);
        modelAndView.addObject("date", date);
        modelAndView.addObject("open", open);
        modelAndView.addObject("high", high);
        modelAndView.addObject("low", low);
        modelAndView.addObject("close", close);
        modelAndView.addObject("ema",ema);

        modelAndView.setViewName("data");

        return modelAndView;
    }
    */

}

