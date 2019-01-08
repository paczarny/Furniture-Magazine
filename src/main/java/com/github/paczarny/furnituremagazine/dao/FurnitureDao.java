package com.github.paczarny.furnituremagazine.dao;

import com.github.paczarny.furnituremagazine.domain.Furniture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional

public class FurnitureDao extends GenericDao<Furniture> {

    FurnitureDao(EntityManager em) {
        super(em);
    }

    @Override
    public List<Furniture> getAll() {
        return null;
    }


    @Override
    public Furniture get(Furniture entity) {

        return null;
    }

}
