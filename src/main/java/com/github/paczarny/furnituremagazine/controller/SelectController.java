package com.github.paczarny.furnituremagazine.controller;

import com.github.paczarny.furnituremagazine.dao.CatalogDao;
import com.github.paczarny.furnituremagazine.dao.FurnitureDao;
import com.github.paczarny.furnituremagazine.dao.MagazineDao;
import com.github.paczarny.furnituremagazine.dao.ProducerDao;
import com.github.paczarny.furnituremagazine.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("fromCatalog")
    public String selectAllFromCatalog(@RequestParam(defaultValue="",
            required = true) String choosenCatalog, Model model){
        List<Furniture> list;
        Catalog catalog = catalogDao.get(new Catalog(choosenCatalog, null));
        if(catalog!=null)
            list = catalog.getFurnitureList();
        else
            list = new LinkedList<>();
        model.addAttribute("furnitures", list);
        return "furnitureList";
    }

    @GetMapping("fromStyle")
    public String selectAllFromStyle(@RequestParam(
            defaultValue="",
            required = true) String choosenStyle, Model model){
        List<Furniture> list;
        Style style = new Style(choosenStyle);
        Furniture furniture = new Furniture(null, 0.0,null, style);
        list = furnitureDao.getAllByStyle(furniture);
        model.addAttribute("furnitures", list);
        return "furnitureList";
    }

    @GetMapping("listAllMagazines")
    public String listAllMagazines(Model model){
        List<Magazine> allMagazines = magazineDao.getAll();
        model.addAttribute("allMagazines", allMagazines);
        return "magazinesList";
    }

    @GetMapping("producers")
    public String producentsWithAtLeastOneFurniture(Model model){
        List<Producer> allProducers=new LinkedList<>();
        //TODO
        model.addAttribute("allProducers", allProducers);
        return "producersList";
    }
}