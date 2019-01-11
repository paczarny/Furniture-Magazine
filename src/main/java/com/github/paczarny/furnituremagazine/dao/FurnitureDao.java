package com.github.paczarny.furnituremagazine.dao;

import com.github.paczarny.furnituremagazine.domain.Furniture;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional

public class FurnitureDao extends GenericDao<Furniture> {

    FurnitureDao(EntityManager em) {
        super(em);
    }

    @Override
    public List<Furniture> getAll() {
        TypedQuery<Furniture> query = em.createQuery(
                "SELECT c FROM Furniture c", Furniture.class);
        return query.getResultList();
    }

    @Override
    public Furniture get(Furniture entity) {

        return null;
    }

    public List<Furniture> listForStyle(String styleName) {
        TypedQuery<Furniture> query = em.createQuery(
                "SELECT c FROM Furniture c where c.style.name = :style", Furniture.class);
        query.setParameter("style", styleName);
        return query.getResultList();
    }

}
