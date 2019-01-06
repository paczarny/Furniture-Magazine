package com.github.paczarny.furnituremagazine.dao;


import com.github.paczarny.furnituremagazine.domain.Address;
import com.github.paczarny.furnituremagazine.domain.Catalog;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CatalogDao extends GenericDao<Catalog> {
    CatalogDao(EntityManager em) {
        super(em);
    }


    @Transactional
    @Override
    public Catalog get(Catalog entity) {
        TypedQuery<Catalog> query = em.createQuery(
                "SELECT c FROM Catalog c WHERE c.name = ?1", Catalog.class);
        return query.setParameter(1, entity.getName()).getSingleResult();
    }
}
