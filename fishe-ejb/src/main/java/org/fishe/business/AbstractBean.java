package org.fishe.business;

import javax.persistence.EntityManager;
import org.fishe.domain.Identified;

/**
 *
 * @author Hildeberto Mendonca
 * @param <T>
 */
public abstract class AbstractBean<T extends Identified> {

    private final Class<T> entityClass;

    public AbstractBean(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public T save(T entity) {
        if(entity.getId() == null) {
            getEntityManager().persist(entity);
        }
        else {
            entity = getEntityManager().merge(entity);
        }
        return entity;
    }

    public void remove(Number id) {
        T entity = find(id);
        if(entity != null) {
            getEntityManager().remove(entity);
        }
    }

    public T find(Number id) {
        return getEntityManager().find(entityClass, id);
    }
}