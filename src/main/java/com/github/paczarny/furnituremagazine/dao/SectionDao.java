package com.github.paczarny.furnituremagazine.dao;

import com.github.paczarny.furnituremagazine.domain.Section;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class SectionDao extends GenericDao<Section> {

    SectionDao(EntityManager em) {
        super(em);
    }


    @Override
    public List<Section> getAll() {
        return null;
    }

    @Override
    public Section get(Section entity) {
        return null;
    }
}
