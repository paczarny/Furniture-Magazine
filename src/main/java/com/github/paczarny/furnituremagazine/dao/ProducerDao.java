package com.github.paczarny.furnituremagazine.dao;

import com.github.paczarny.furnituremagazine.domain.Producer;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class ProducerDao extends GenericDao<Producer> {
    ProducerDao(EntityManager em) {
        super(em);
    }
}
