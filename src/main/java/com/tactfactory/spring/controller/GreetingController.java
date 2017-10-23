package com.tactfactory.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(
            @RequestParam(value="name", required=false, defaultValue="World")
            String toto,
            Model model
            ) {

        model.addAttribute("myParameter", toto);
        return "greeting"; //=> Call gretting.html (View)
    }


    @RequestMapping("/toto")
    public String toto() {
        return "toto";
    }

}
