package com.github.paczarny.furnituremagazine;

import com.db4o.ObjectSet;
import com.github.paczarny.furnituremagazine.dao.AddressDao;
import com.github.paczarny.furnituremagazine.domain.Address;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
public class FurnituremagazineApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(FurnituremagazineApplication.class, args);

        System.out.println("databse test");

        Address address1 = new Address("Cracow", "30-300", "Poland", "1", "1", "1");
        Address address2 = new Address("Warsaw", "30-300", "Poland", "1", "1", "1");
        AddressDao addressDao = ctx.getBean(AddressDao.class);
        //addressDao.save(address1);
        addressDao.save(address2);

        address1 = addressDao.get(address1);


        List<Address> result= addressDao.getAll();
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i).getPlace());
        }

    }
}

