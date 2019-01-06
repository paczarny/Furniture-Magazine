package com.github.paczarny.furnituremagazine.dao;


import com.github.paczarny.furnituremagazine.domain.Catalog;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class CatalogDao extends GenericDao<Catalog> {
    CatalogDao(EntityManager em) {
        super(em);
    }
}
