package com.github.paczarny.furnituremagazine;

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

    @Test
    public void testSavingObjects() {
        // given
        Shop shop = new Shop("shop", null, null);
        Catalog catalog = new Catalog("catalog");
        Section section = new Section("section");
        shop.addCatalog(catalog);
        shop.addSection(section);
        assert shopDao.getAll().size() == 0 : "Could not prepare DB for test";

        // when save object
        shopDao.save(shop);

        // then should be found
        List<Shop> shopList = shopDao.getAll();
        assertEquals(1, shopList.size());
        Shop retreivedShop = shopDao.get(new Shop("shop",null,null));
        assertEquals(shop, retreivedShop);

        // when save 2nd object
        Shop shop1 = new Shop("shop1", null, null);
        Catalog catalog1 = new Catalog("catalog1");
        Section section1 = new Section("section1");
        shop1.addCatalog(catalog1);
        shop1.addSection(section1);
        shopDao.save(shop1);

        // then should find 2 objects
        shopList = shopDao.getAll();
        assertEquals(2, shopList.size());

        // when save 1st address multiple times
        shopDao.save(shop1);

        // then should be still 2 objects in db
        shopList = shopDao.getAll();
        assertEquals(2, shopList.size());
    }

}
