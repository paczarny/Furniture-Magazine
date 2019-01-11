package com.github.paczarny.furnituremagazine.dao;

import com.github.paczarny.furnituremagazine.domain.Producer;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class ProducerDao extends GenericDao<Producer> {
    ProducerDao(EntityManager em) {
        super(em);
    }

    @Override
    public List<Producer> getAll() {
        return null;
    }


    @Override
    public Producer get(Producer entity) {
        return null;
    }

    public List<Producer> listAllWithAtLeastTwoFurniture() {
        TypedQuery<Producer> query = em.createQuery(
                "SELECT f.producer FROM Furniture f GROUP BY f.producer HAVING COUNT(f) > 1", Producer.class);
        return query.getResultList();
    }
}
