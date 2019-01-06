package com.github.paczarny.furnituremagazine.dao;

import com.github.paczarny.furnituremagazine.domain.Magazine;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Component
public class MagazineDao extends GenericDao<Magazine> {

    MagazineDao(EntityManager em) {
        super(em);
    }

    @Transactional
    @Override
    public Magazine get(Magazine entity) {
        TypedQuery<Magazine> query = em.createQuery(
                "SELECT c FROM Magazine c WHERE c.name = ?1", Magazine.class);
        return query.setParameter(1, entity.getName()).getSingleResult();
    }

}
