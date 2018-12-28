package com.github.paczarny.furnituremagazine.config;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class Config {
    @Value("${databasePath}")
    String databasePath;

    @Bean
    public ObjectContainer getDB4O(){
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded
                .newConfiguration(), databasePath);
        return db;
    }
}
