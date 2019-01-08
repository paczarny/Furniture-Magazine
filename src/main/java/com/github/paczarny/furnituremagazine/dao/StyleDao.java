package com.github.paczarny.furnituremagazine.dao;

import com.github.paczarny.furnituremagazine.domain.Furniture;
import com.github.paczarny.furnituremagazine.domain.Magazine;
import com.github.paczarny.furnituremagazine.domain.Style;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class StyleDao{

    @Autowired
    MagazineDao magazineDao;


    public List<Style> getAllStyles()  {
        List<Furniture> furnitures = getFurnitureList();
        if(furnitures==null)
            return new ArrayList<>();
        Set<Style> styleSet = new HashSet<>();
        for(Furniture f : furnitures)
            styleSet.add(f.getStyle());
        return new ArrayList<>(styleSet);
    }


    private List<Furniture> getFurnitureList(){
        List<Magazine> magazines = magazineDao.getAll();
        if(magazines.size()==0)
            return null;
        List<Furniture> furnitures = magazines.get(0).getFurnitureList();
        return furnitures;
    }
}
