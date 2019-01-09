package com.github.paczarny.furnituremagazine.dao;

import com.github.paczarny.furnituremagazine.domain.Furniture;
import com.github.paczarny.furnituremagazine.domain.Magazine;
import com.github.paczarny.furnituremagazine.domain.Style;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class StyleDao extends GenericDao<Magazine>{

    StyleDao(EntityManager em) {
        super(em);
    }

    @Override
    public List<Magazine> getAll() {
        return null;
    }

    @Override
    public Magazine get(Magazine entity) {
        return null;
    }


    public List<Style> getAllStyles()  {
        List<Furniture> furnitures = getAllFurnitures();
        if (furnitures.size() == 0)
            return new ArrayList<>();
        Set<Style> styleSet = new HashSet<>();
        for(Furniture f : furnitures)
            styleSet.add(f.getStyle());
        return new ArrayList<>(styleSet);
    }



    public List<Furniture> getFurnituresOfStyle(Style style) {
        List<Furniture> furnitures = getAllFurnitures();
        if (furnitures.size() == 0)
            return new ArrayList<>();
        List<Furniture> resultList = new ArrayList<>();
        for (Furniture f : furnitures) {
            if (f.getStyle().equals(style))
                resultList.add(f);
        }
        return resultList;
    }


        private List<Furniture> getAllFurnitures(){
            TypedQuery<Magazine> query = em.createQuery(
                    "SELECT c FROM Magazine c", Magazine.class);
            List<Magazine> magazines = query.getResultList();
            if(magazines.size()==0)
                return new ArrayList<>();
            List<Furniture> furnitures = new ArrayList<>();
            for(Magazine m : magazines)
                furnitures.addAll(m.getFurnitureList());
            return furnitures;
    }



}
