package com.github.paczarny.furnituremagazine;

import com.github.paczarny.furnituremagazine.dao.AddressDao;
import com.github.paczarny.furnituremagazine.domain.Address;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseTest {
    private Address address;


    @Test
    public void databaseTest(){
        address = new Address("Cracow", "30-300", "Poland", "1", "1", "1");
    }

}
