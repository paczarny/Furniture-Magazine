package com.github.paczarny.furnituremagazine.dao;

import com.github.paczarny.furnituremagazine.domain.Furniture;
import com.github.paczarny.furnituremagazine.domain.Producer;
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
public class ProducerDaoTest {

    @Autowired
    private ProducerDao producerDao;
    @Autowired
    private FurnitureDao furnitureDao;

    @Test
    public void listAllWithAtLeastTwoFurniture() {
        Producer producer0Furniture = new Producer("p0");
        producerDao.save(producer0Furniture);

        Producer producer1Furniture = new Producer("p1");
        producerDao.save(producer1Furniture);

        Producer producer2Furniture = new Producer("p2");
        producerDao.save(producer2Furniture);

        Furniture f1 = new Furniture("f", 12, producer1Furniture, null);
        Furniture f2 = new Furniture("f2", 2.1, producer2Furniture, null);
        Furniture f3 = new Furniture("f3", 24, producer2Furniture, null);
        furnitureDao.save(f1);
        furnitureDao.save(f2);
        furnitureDao.save(f3);

        // when
        List<Producer> producers = producerDao.listAllWithAtLeastTwoFurniture();

        // then
        assertEquals(1, producers.size());
        assertThat(producers, contains(producer2Furniture));
    }
}