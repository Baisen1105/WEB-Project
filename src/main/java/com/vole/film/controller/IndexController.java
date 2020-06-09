package com.vole.film.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 入口路径
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("title","首页");
        mav.addObject("mainPage", "film/indexFilm");
        mav.addObject("mainPageKey", "#f");
        mav.setViewName("index");
        return mav;
    }

}
