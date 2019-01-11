package com.github.paczarny.furnituremagazine.dao;

import com.github.paczarny.furnituremagazine.domain.Catalog;
import com.github.paczarny.furnituremagazine.domain.Section;
import com.github.paczarny.furnituremagazine.domain.Shop;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class ShopDao extends GenericDao<Shop> {

    ShopDao(EntityManager em) {
        super(em);
    }

    @Override
    public List<Shop> getAll() {
        TypedQuery<Shop> query = em.createQuery(
                "SELECT c FROM Shop c", Shop.class);
        return query.getResultList();
    }


    @Override
    public Shop get(Shop entity) {
        TypedQuery<Shop> query = em.createQuery(
                "SELECT c FROM Shop c WHERE c.name = :name", Shop.class);
        query.setParameter("name", entity.getName());
        List<Shop> shopList = query.getResultList();
        if (shopList.size() == 0)
            return new Shop();
        return shopList.get(0);
    }

    public List<Section> getSectionList() {
        TypedQuery<Shop> query = em.createQuery(
                "SELECT c FROM Shop c", Shop.class);
        List<Shop> shopList = getAll();
        if (shopList.size() == 0)
            return new ArrayList<>();
        return shopList.get(0).getSectionList();
    }
}
