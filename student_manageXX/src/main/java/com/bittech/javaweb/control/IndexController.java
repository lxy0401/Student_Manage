package com.bittech.javaweb.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Author: secondriver
 * Created: 2018/8/6
 */
@Controller
@RequestMapping
public class IndexController {
    
    @RequestMapping(value = {"", "/", "/index"}, method = {RequestMethod.GET})
    public String index() {
        return "index";
    }
    
}
