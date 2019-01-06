package com.github.paczarny.furnituremagazine.dao;

import com.github.paczarny.furnituremagazine.domain.Furniture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Component
public class FurnitureDao extends GenericDao<Furniture> {
    private final Logger log = LoggerFactory.getLogger(FurnitureDao.class);

    FurnitureDao(EntityManager em) {
        super(em);
    }

    public List<Furniture> getAllByStyle(Furniture furniture) {
        log.error("FurnitureDao.getAllByStyle isn't implemented");
        // todo: implement
        return new ArrayList<>();
    }
}
