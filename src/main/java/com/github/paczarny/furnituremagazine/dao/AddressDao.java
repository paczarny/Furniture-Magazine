package com.github.paczarny.furnituremagazine.dao;
import com.github.paczarny.furnituremagazine.domain.Address;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class AddressDao extends  GenericDao<Address>{
    AddressDao(EntityManager em) {
        super(em);
    }
}