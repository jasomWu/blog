package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sunwu
 * @since 2021-09-23-11:38
 */
@Controller
public class IndexController {
    @RequestMapping(value = {"/","index","index.html"})
    public String index(){
        return "index";
    }
}
