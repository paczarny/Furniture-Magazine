package com.github.paczarny.furnituremagazine.dao;

import com.github.paczarny.furnituremagazine.domain.Magazine;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MagazineDao extends GenericDao<Magazine> {

    @Override
    public List<Magazine> getAll() {
        //mozna nadpisac z wlasnym query
        return super.getAll();
    }
}
