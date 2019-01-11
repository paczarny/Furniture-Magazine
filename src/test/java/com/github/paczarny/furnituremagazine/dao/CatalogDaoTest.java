package com.github.paczarny.furnituremagazine.dao;

import com.github.paczarny.furnituremagazine.domain.Catalog;
import com.github.paczarny.furnituremagazine.domain.Furniture;
import com.github.paczarny.furnituremagazine.domain.Producer;
import com.github.paczarny.furnituremagazine.domain.Style;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CatalogDaoTest {
    @Autowired
    private CatalogDao catalogDaoDao;
    @Autowired
    private FurnitureDao furnitureDao;

    @Test
    public void listForStyle() {
        // given
        Catalog catalog = new Catalog("zimowy");

        Furniture krzeslo = new Furniture("krzeslo", 12, null, null);
        Furniture krzeslo2 = new Furniture("krzeslo2", 55.6, null, null);
        Furniture stol = new Furniture("stol", 34, null, null);

        furnitureDao.save(krzeslo);
        furnitureDao.save(krzeslo2);
        furnitureDao.save(stol);

        catalog.addFurniture(krzeslo);
        catalog.addFurniture(krzeslo2);
        catalog.addFurniture(stol);

        catalogDaoDao.save(catalog);

        // when
        List<Furniture> furnitures = catalogDaoDao.listAllFurnituresByCatalog("zimowy");

        // then
        assertEquals(3, furnitures.size());
        assertThat(furnitures, contains(krzeslo, krzeslo2, stol));

    }
}
