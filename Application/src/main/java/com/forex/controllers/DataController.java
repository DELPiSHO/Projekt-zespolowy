package com.forex.controllers;

import com.forex.domain.RealData;
import com.forex.repository.RealDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DataController {
    @Autowired
    private RealDataRepository realDataRepository;

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
}
