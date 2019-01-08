package com.github.paczarny.furnituremagazine.dao;

import com.github.paczarny.furnituremagazine.domain.Magazine;
import com.github.paczarny.furnituremagazine.domain.Shop;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class MagazineDao extends GenericDao<Magazine> {

    MagazineDao(EntityManager em) {
        super(em);
    }

    @Override
    public List<Magazine> getAll() {
        TypedQuery<Magazine> query = em.createQuery(
                "SELECT c FROM Magazine c", Magazine.class);
        return query.getResultList();
    }

    @Override
    public Magazine get(Magazine entity) {
        TypedQuery<Magazine> query = em.createQuery(
                "SELECT c FROM Magazine c WHERE c.name = ?1", Magazine.class);
        return query.setParameter(1, entity.getName()).getSingleResult();
    }

}
