package com.codegym.controller;

import com.codegym.model.Form;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.Email;


@Controller
public class FormController {
    @GetMapping("/form")
    public ModelAndView showEmail(){
        ModelAndView modelAndView=new ModelAndView("/list");
        modelAndView.addObject("forms",new Form());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView checkEmail(@Validated @ModelAttribute(name = "forms") Form form, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/list","forms",form);
        }
        return new ModelAndView("/result");
    }
}
