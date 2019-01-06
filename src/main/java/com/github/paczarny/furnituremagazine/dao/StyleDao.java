package com.github.paczarny.furnituremagazine.dao;

import com.github.paczarny.furnituremagazine.domain.Style;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class StyleDao extends GenericDao<Style> {
    StyleDao(EntityManager em) {
        super(em);
    }
}
