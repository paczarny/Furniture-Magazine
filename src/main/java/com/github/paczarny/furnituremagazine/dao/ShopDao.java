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
public class ShopDao extends GenericDao<Shop>{

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
                "SELECT c FROM Shop c WHERE c.name = ?1", Shop.class);
        return query.setParameter(1, entity.getName()).getSingleResult();
    }

    public List<Catalog> getCatalogList(){
        TypedQuery<Shop> query = em.createQuery(
                "SELECT c FROM Shop c", Shop.class);
        Shop shop = query.getSingleResult();
        return shop.getCatalogsList();
    }

    public List<Section> getSectionList(){
        TypedQuery<Shop> query = em.createQuery(
                "SELECT c FROM Shop c", Shop.class);
        Shop shop = query.getSingleResult();

        System.out.println(shop.getName());
        System.out.println(shop.getCatalogsList().get(0).getName());
        System.out.println(shop.getSectionList().get(0).getName());
        return shop.getSectionList();
    }
}
