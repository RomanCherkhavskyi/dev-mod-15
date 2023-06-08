package com.example.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestControler {

    @RequestMapping(value = "/test", method = {RequestMethod.GET})
    public ModelAndView getText() {
        ModelAndView result = new ModelAndView("test");
        result.addObject("text", "Hello world!This is Spring MVS + Thymeleaf");
        return result;
    }



}
