package com.github.paczarny.furnituremagazine.dao;

import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericDao<T> {

    protected final EntityManager em;
    protected Class<T> type;

    @Autowired
    @SuppressWarnings("unchecked")
    GenericDao(EntityManager em) {
        type = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
        this.em = em;
    }

    @Transactional
    public void save(T entity) {
        em.persist(entity);
        em.flush();
    }

    public abstract List<T> getAll();

    public abstract T get(T entity);

    @Transactional
    public void delete(T entity) {
        em.remove(entity);
    }

    @Transactional
    public void update(T entity) {
        save(entity);
    }
}