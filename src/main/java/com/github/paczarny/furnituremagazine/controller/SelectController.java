package com.github.paczarny.furnituremagazine.controller;

import com.github.paczarny.furnituremagazine.dao.*;
import com.github.paczarny.furnituremagazine.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("select")
public class SelectController {
    @Autowired
    MagazineDao magazineDao;
    @Autowired
    ProducerDao producerDao;
    @Autowired
    CatalogDao catalogDao;
    @Autowired
    FurnitureDao furnitureDao;
    @Autowired
    StyleDao styleDao;

    @GetMapping("fromCatalog")
    public String selectAllFromCatalog(@RequestParam(defaultValue="",
            required = true) String choosenCatalog, Model model){
        List<Furniture> list;
        Catalog catalog = catalogDao.get(new Catalog(choosenCatalog));
        if(catalog!=null)
            list = catalog.getFurnitureList();
        else
            list = new LinkedList<>();
        model.addAttribute("furnitures", list);
        return "furnitureList";
    }

    @GetMapping("fromStyle")
    public String selectAllFromStyle(@RequestParam(
            defaultValue="", required = true) String choosenStyle, Model model){
        Style style = new Style(choosenStyle);
        List<Furniture> list = styleDao.getFurnituresOfStyle(style);
        model.addAttribute("furnitures", list);
        return "furnitureList";
    }

    @GetMapping("producers")
    public String producentsWithAtLeastOneFurniture(Model model){
        List<Producer> allProducers=new LinkedList<>();
        //TODO
        model.addAttribute("allProducers", allProducers);
        return "producersList";
    }
}
