package com.github.paczarny.furnituremagazine.controller;

import com.github.paczarny.furnituremagazine.dao.CatalogDao;
import com.github.paczarny.furnituremagazine.dao.ShopDao;
import com.github.paczarny.furnituremagazine.dao.StyleDao;
import com.github.paczarny.furnituremagazine.domain.Catalog;
import com.github.paczarny.furnituremagazine.domain.Style;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ShopDao shopDao;
    @Autowired
    StyleDao styleDao;



    @RequestMapping("/")
    public String home(Model model) {
        List<Catalog> catalogList = shopDao.getCatalogList();
        model.addAttribute(catalogList);
        List<Style> styleList = new ArrayList<>();
        model.addAttribute(styleList);
        return "home";
    }

}
