package com.github.paczarny.furnituremagazine.dao;

import com.github.paczarny.furnituremagazine.domain.Furniture;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FurnitureDao extends GenericDao<Furniture> {
    public List<Furniture> getAllByStyle(Furniture furniture) {
        List<Furniture> list = db.queryByExample(furniture);
        return list;
    }
}
