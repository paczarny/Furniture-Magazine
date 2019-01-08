package com.github.paczarny.furnituremagazine.dao;

import com.github.paczarny.furnituremagazine.domain.Style;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class StyleDao extends GenericDao<Style> {

    public StyleDao(EntityManager em){
        super(em);
    }

    @Override
    public List<Style> getAll() {
        return null;
    }

    @Override
    public Style get(Style entity) {
        return null;
    }
}
