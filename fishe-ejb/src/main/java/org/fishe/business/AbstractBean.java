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

    public void remove(Integer id) {
        getEntityManager().remove(getEntityManager().find(this.entityClass, id));
    }

    public T find(Integer id) {
        return getEntityManager().find(entityClass, id);
    }
}