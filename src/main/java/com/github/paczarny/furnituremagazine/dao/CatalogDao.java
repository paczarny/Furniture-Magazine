package com.github.paczarny.furnituremagazine.dao;


import com.github.paczarny.furnituremagazine.domain.Catalog;
import com.github.paczarny.furnituremagazine.domain.Furniture;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
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

    public List<Furniture> listAllFurnituresByCatalog(String catalogName) {
        TypedQuery<Catalog> query = em.createQuery(
                "SELECT c FROM Catalog c where c.name = :catalog", Catalog.class);
        query.setParameter("catalog", catalogName);
        List<Catalog> catalogs = query.getResultList();
        if(catalogs.size()==0)
            return new ArrayList<>();
        return catalogs.get(0).getFurnitureList();
    }
}
