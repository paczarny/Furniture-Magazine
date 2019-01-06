package com.github.paczarny.furnituremagazine.dao;

import com.github.paczarny.furnituremagazine.domain.Magazine;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class MagazineDao extends GenericDao<Magazine> {

    MagazineDao(EntityManager em) {
        super(em);
    }

}
