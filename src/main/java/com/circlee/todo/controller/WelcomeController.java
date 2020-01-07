package com.circlee.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

//    @Autowired
//    private MappingJackson2JsonView jsonView;

    @GetMapping(value = "/")
    public String getIndexPage(){
        return "index.html";
    }

    @GetMapping(value = "/welcome")
    public ModelAndView getWelcomePage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("welcome.html");
        mav.addObject("name", "circlee");
        return mav;
    }

}
