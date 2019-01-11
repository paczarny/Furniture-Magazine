package com.github.paczarny.furnituremagazine.dao;

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
public class FurnitureDaoTest {
    @Autowired
    private StyleDao styleDao;
    @Autowired
    private ProducerDao producerDao;
    @Autowired
    private FurnitureDao furnitureDao;

    @Test
    public void listForStyle() {
        // given
        Style rokoko = new Style("rokoko");
        styleDao.save(rokoko);
        Style barok = new Style("barok");
        styleDao.save(barok);

        Producer producer = new Producer("MEB-POL");
        producerDao.save(producer);

        Furniture krzeslo = new Furniture("krzeslo", 12, producer, rokoko);
        Furniture krzeslo2 = new Furniture("krzeslo2", 55.6, producer, barok);
        Furniture stol = new Furniture("stol", 34, producer, rokoko);

        furnitureDao.save(krzeslo);
        furnitureDao.save(krzeslo2);
        furnitureDao.save(stol);

        // when
        List<Furniture> furnitures = furnitureDao.listForStyle("rokoko");

        // then
        assertEquals(2, furnitures.size());
        assertThat(furnitures, contains(krzeslo, stol));

    }
}