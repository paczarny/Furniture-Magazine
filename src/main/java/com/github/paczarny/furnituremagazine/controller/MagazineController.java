package com.github.paczarny.furnituremagazine.controller;

import com.github.paczarny.furnituremagazine.dao.MagazineDao;
import com.github.paczarny.furnituremagazine.domain.Magazine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("magazine")
public class MagazineController {
    private final MagazineDao magazineDao;

    public MagazineController(MagazineDao magazineDao) {
        this.magazineDao = magazineDao;
    }

    @GetMapping("list")
    public String listAllMagazines(Model model) {
        List<Magazine> allMagazines = magazineDao.getAll();
        model.addAttribute("allMagazines", allMagazines);
        model.addAttribute("newMagazine", new Magazine());
        return "magazinesList";
    }

    @PostMapping
    public String addMagazine(@ModelAttribute Magazine magazine) {
        magazineDao.save(magazine);
        return "redirect:/magazine/list";
    }
}
