package com.github.paczarny.furnituremagazine.dao;
import com.github.paczarny.furnituremagazine.domain.Address;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Component
public class AddressDao extends  GenericDao<Address>{
    AddressDao(EntityManager em) {
        super(em);
    }


    @Transactional
    @Override
    public Address get(Address entity) {
        TypedQuery<Address> query = em.createQuery(
                "SELECT c FROM Address c WHERE c.city = ?1 AND c.zipcode = ?2 AND c.country = ?3 AND c.houseNumber = ?4 AND c.apartmentNumber = ?5 AND c.street = ?6", Address.class);
        query.setParameter(1, entity.getCity()).setParameter(2,entity.getZipCode()).setParameter(3, entity.getCountry()).setParameter(4, entity.getHouseNumber());
        query.setParameter(5, entity.getApartmentNumber()).setParameter(6, entity.getStreet());
        return query.getSingleResult();
    }
}