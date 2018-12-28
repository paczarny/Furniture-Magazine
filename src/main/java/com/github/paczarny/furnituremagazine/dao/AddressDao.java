package com.github.paczarny.furnituremagazine.dao;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.github.paczarny.furnituremagazine.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressDao {
    private ObjectContainer db;

    @Autowired
    public void setDb(ObjectContainer db){
        this.db=db;
    }

    public void save(Address address){
        db.store(address);
    }

    public ObjectSet getAllAddresses(){
        return db.queryByExample(Address.class);
    }
}