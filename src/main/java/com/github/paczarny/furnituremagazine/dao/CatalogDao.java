package com.github.paczarny.furnituremagazine.dao;


import com.github.paczarny.furnituremagazine.domain.Catalog;
import com.github.paczarny.furnituremagazine.domain.Furniture;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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

    public List<Furniture> listAllFurnituresByCatalog(String catalogName) throws NoSuchElementException {
        TypedQuery<Catalog> query = em.createQuery(
                "SELECT c FROM Catalog c where c.name = :catalog", Catalog.class);
        query.setParameter("catalog", catalogName);
        if(query.getResultList().size()==0)
            throw new NoSuchElementException("No catalog found in Database");
        return query.getSingleResult().getFurnitureList();
    }
}
