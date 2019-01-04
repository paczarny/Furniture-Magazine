package com.github.paczarny.furnituremagazine.controller;

import com.github.paczarny.furnituremagazine.dao.CatalogDao;
import com.github.paczarny.furnituremagazine.dao.MagazineDao;
import com.github.paczarny.furnituremagazine.dao.StyleDao;
import com.github.paczarny.furnituremagazine.domain.Catalog;
import com.github.paczarny.furnituremagazine.domain.Magazine;
import com.github.paczarny.furnituremagazine.domain.Style;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CatalogDao catalogDao;
    @Autowired
    StyleDao styleDao;
    @Autowired
    MagazineDao magazineDao;

    @RequestMapping("/")
    public String home(Model model) {
        List<Catalog> catalogList = catalogDao.getAll();
        model.addAttribute(catalogList);
        List<Style> styleList = styleDao.getAll();
        model.addAttribute(styleList);
        return "home";
    }

    @GetMapping("list")
    public String listAllMagazines(Model model){
        List<Magazine> allMagazines = magazineDao.getAll();
        model.addAttribute("allMagazines", allMagazines);
        return "list";
    }
}
