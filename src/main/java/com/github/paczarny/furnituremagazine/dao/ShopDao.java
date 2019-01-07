package com.github.paczarny.furnituremagazine.dao;

import com.github.paczarny.furnituremagazine.domain.Catalog;
import com.github.paczarny.furnituremagazine.domain.Shop;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Component
public class ShopDao extends GenericDao<Shop>{ ShopDao(EntityManager em) {
        super(em);
    }

    @Override
    public Shop get(Shop entity) {
        TypedQuery<Shop> query = em.createQuery(
                "SELECT c FROM Shop c WHERE c.name = ?1", Shop.class);
        return query.setParameter(1, entity.getName()).getSingleResult();
    }
}
