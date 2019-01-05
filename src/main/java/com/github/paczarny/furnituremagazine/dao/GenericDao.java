package com.github.paczarny.furnituremagazine.dao;

import com.db4o.ObjectContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Component
public abstract class GenericDao<T> {

    @Autowired
    protected ObjectContainer db;
    private Class<T> type;

    @SuppressWarnings("unchecked")
    GenericDao() {
        type = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public void save(T entity) {
        db.store(entity);
    }

    public List<T> getAll() {
        List<T> list = db.query(type);
        return list;
    }

    public T get(T entity){
        List<T> list = db.queryByExample(entity);
        if(!list.isEmpty())
            return list.get(0);
        else return null;
    }

    public void delete(T entity){
        db.delete(entity);
    }

    public void update(T entity){
        db.store(entity);
    }
}