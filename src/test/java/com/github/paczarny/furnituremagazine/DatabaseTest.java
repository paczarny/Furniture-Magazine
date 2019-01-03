package com.github.paczarny.furnituremagazine;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.github.paczarny.furnituremagazine.domain.Address;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseTest {
    @Autowired
    private ObjectContainer db;

    @Test
    public void testSavingObjects() {
        // given
        Address address = new Address("Cracow", "30-300", "Poland", "1", "1", "1");
        assert db.query(Address.class).size() == 0 : "Could not prepare DB for test";

        // when save object
        db.store(address);

        // then should be found
        ObjectSet<Address> addresses = db.query(Address.class);
        assertEquals(1, addresses.size());
        Address retreivedAddress = addresses.get(0);
        assertEquals(address, retreivedAddress);

        // when save 2nd object
        Address address2 = new Address("Waw", "20-200", "Poland", "1", "1", "1");
        db.store(address2);

        // then should find 2 objects
        addresses = db.query(Address.class);
        assertEquals(2, addresses.size());

        // when save 1st address multiple times
        db.store(address);

        // then should be still 2 objects in db
        addresses = db.query(Address.class);
        assertEquals(2, addresses.size());
    }

    @After
    public void tearDown() throws Exception {
        db.rollback();
    }
}
