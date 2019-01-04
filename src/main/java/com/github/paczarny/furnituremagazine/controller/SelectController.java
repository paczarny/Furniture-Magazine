package com.github.paczarny.furnituremagazine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("select")
public class SelectController {

    @GetMapping("fromCatalog")
    public String selectAllFromCatalog(@RequestParam(defaultValue="",
            required = true) String choosenCatalog){

        return "home";
    }

    @GetMapping("fromStyle")
    public String selectAllFromStyle(@RequestParam(
            defaultValue="",
            required = true) String choosenStyle){

        return "home";
    }
}
