package com.github.paczarny.furnituremagazine.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@PropertySource("classpath:application.properties")
public class Config {
    @Value("${databasePath}")
    String databasePath;

    @Bean(name = "entityManagerFactory")
    public EntityManagerFactory getEntityManagerFactoryBean() {
        return Persistence.createEntityManagerFactory(databasePath);
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}
