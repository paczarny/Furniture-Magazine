package com.github.paczarny.furnituremagazine.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Component
public abstract class GenericDao<T> {

    protected final EntityManager em;
    private Class<T> type;

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

    public List<T> getAll() {
        return em.createQuery("SELECT e FROM " + type.getSimpleName() + " e", type).getResultList();
    }

    public T get(T entity) {
        return em.find(type, entity);
    }

    public void delete(T entity) {
        em.remove(entity);
    }

    public void update(T entity) {
        save(entity);
    }
}