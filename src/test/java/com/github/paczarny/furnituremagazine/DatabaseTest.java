package com.github.paczarny.furnituremagazine;

import com.github.paczarny.furnituremagazine.dao.AddressDao;
import com.github.paczarny.furnituremagazine.dao.MagazineDao;
import com.github.paczarny.furnituremagazine.dao.ShopDao;
import com.github.paczarny.furnituremagazine.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DatabaseTest {
    @Autowired
    private ShopDao shopDao;
    @Autowired
    private MagazineDao magazineDao;

    @Test
    public void testSavingObjects() {
        Producer producer = new Producer("producer");
        Style style = new Style("style");
        Address address = new Address("Cracow", "30-300", "Poland", "1", "1", "1");
        Catalog catalog = new Catalog("catalog");
        Section section = new Section("section");
        Furniture furniture = new Furniture("krzeslo", 22, producer, style, section, catalog);
        Magazine magazine = new Magazine("magazine", address, null);
        magazine.addFurniture(furniture);
        Shop shop = new Shop("shop", null, null);
        shop.addCatalog(catalog);
        shop.addSection(section);

        magazineDao.save(magazine);
        shopDao.save(shop);

        Shop shop1 = shopDao.get(shop);

        System.out.println(shop.getName());
        System.out.println(shop.getCatalogsList().get(0).getName());
        System.out.println(shop.getSectionList().get(0).getName());







        /*// given
        Address address = new Address("Cracow", "30-300", "Poland", "1", "1", "1");
        assert addressDao.getAll().size() == 0 : "Could not prepare DB for test";

        // when save object
        addressDao.save(address);

        // then should be found
        List<Address> addressList = addressDao.getAll();
        assertEquals(1, addressList.size());
        Address retreivedAddress = addressList.get(0);
        assertEquals(address, retreivedAddress);

        // when save 2nd object
        Address address2 = new Address("Waw", "20-200", "Poland", "1", "1", "1");
        addressDao.save(address2);

        // then should find 2 objects
        addressList = addressDao.getAll();
        assertEquals(2, addressList.size());

        // when save 1st address multiple times
        addressDao.save(address2);

        // then should be still 2 objects in db
        addressList = addressDao.getAll();
        assertEquals(2, addressList.size());*/
    }

}
