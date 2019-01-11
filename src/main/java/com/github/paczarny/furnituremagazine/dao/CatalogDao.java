package com.github.paczarny.furnituremagazine.dao;


import com.github.paczarny.furnituremagazine.domain.Catalog;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class CatalogDao extends GenericDao<Catalog> {
    CatalogDao(EntityManager em) {
        super(em);
    }

    @Override
    public List<Catalog> getAll() {
        TypedQuery<Catalog> query = em.createQuery(
                "SELECT c FROM Catalog c", Catalog.class);
        return query.getResultList();
    }

    @Override
    public Catalog get(Catalog entity) {
        return null;
    }
}
