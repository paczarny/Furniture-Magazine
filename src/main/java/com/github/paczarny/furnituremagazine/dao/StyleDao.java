package com.github.paczarny.furnituremagazine.dao;

import com.github.paczarny.furnituremagazine.domain.Style;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Component
public class StyleDao extends GenericDao<Style> {
    StyleDao(EntityManager em) {
        super(em);
    }


    @Transactional
    @Override
    public Style get(Style entity) {
        TypedQuery<Style> query = em.createQuery(
                "SELECT c FROM Style c WHERE c.name = ?1", Style.class);
        return query.setParameter(1, entity.getName()).getSingleResult();
    }
}
