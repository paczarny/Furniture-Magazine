package com.github.paczarny.furnituremagazine.controller;

import com.github.paczarny.furnituremagazine.dao.MagazineDao;
import com.github.paczarny.furnituremagazine.dao.ProducerDao;
import com.github.paczarny.furnituremagazine.domain.Magazine;
import com.github.paczarny.furnituremagazine.domain.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("select")
public class SelectController {
    @Autowired
    MagazineDao magazineDao;
    @Autowired
    ProducerDao producerDao;

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

    @GetMapping("listAllMagazines")
    public String listAllMagazines(Model model){
        List<Magazine> allMagazines = magazineDao.getAll();
        model.addAttribute("allMagazines", allMagazines);
        return "listMagazines";
    }

    @GetMapping("producers")
    public String producentsWithAtLeastOneFurniture(Model model){
        List<Producer> allProducers=null;
        //TODO
        model.addAttribute("allProducers", allProducers);
        return "listProducers";
    }
}
