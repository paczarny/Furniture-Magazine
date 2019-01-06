package com.github.paczarny.furnituremagazine.dao;

import com.github.paczarny.furnituremagazine.domain.Magazine;
import com.github.paczarny.furnituremagazine.domain.Producer;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class ProducerDao extends GenericDao<Producer> {
    ProducerDao(EntityManager em) {
        super(em);
    }


    @Transactional
    @Override
    public Producer get(Producer entity) {
        TypedQuery<Producer> query = em.createQuery(
                "SELECT c FROM Producer c WHERE c.name = ?1", Producer.class);
        return query.setParameter(1, entity.getName()).getSingleResult();
    }
}
