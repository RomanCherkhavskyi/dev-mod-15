package com.example.controller;

import com.example.entity.Note;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController {

//    @RequestMapping(value = "/test", method = {RequestMethod.GET})
//    public ModelAndView getText() {
//        ModelAndView result = new ModelAndView("test");
//        result.addObject("text", "Hello world!This is Spring MVS + Thymeleaf");
//        return result;
//    }

    @GetMapping("/test")
    public ModelAndView getText() {
        ModelAndView result = new ModelAndView("test");
        result.addObject("text",  new Note(5L,"NOTE-5", "It's note 5 content"));
        return result;
    }

}
