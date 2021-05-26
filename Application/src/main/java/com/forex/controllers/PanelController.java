package com.forex.controllers;

import com.forex.domain.Currency;
import com.forex.domain.User;
import com.forex.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;

@Controller
public class PanelController {

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/admin/update")
    public String update(Model model) {
        model.addAttribute("currencies", new Currency().getCurrencies());

        return "currencypick";
    }

    @PostMapping("/admin/update")
    public String processUpdate(String currency) throws IOException {
        //Process p = Runtime.getRuntime().exec("echo update");

        return "redirect:/admin";
    }
    @GetMapping("/admin/fix")
    public String fix(Model model) {
        model.addAttribute("currencies", new Currency().getCurrencies());

        return "currencypick" ;
    }

    @PostMapping("/admin/fix")
    public String processFix(String currency) throws IOException {
        //Process p = Runtime.getRuntime().exec("echo fix");

        return "redirect:/admin";
    }
    @GetMapping("/admin/setup")
    public String setup(Model model) {
        model.addAttribute("currencies", new Currency().getCurrencies());

        return "currencypick" ;
    }

    @PostMapping("/admin/setup")
    public String processSetup(String currency) throws IOException {
        //Process p = Runtime.getRuntime().exec("echo setup");

        return "redirect:/admin";
    }




}
