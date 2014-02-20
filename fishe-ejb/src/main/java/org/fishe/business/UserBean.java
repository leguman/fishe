package org.fishe.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fishe.domain.User;

/**
 *
 * @author Hildeberto Mendonça
 */
@Stateless
public class UserBean extends AbstractBean<User> {

    @PersistenceContext
    private EntityManager em;

    public UserBean() {
        super(User.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<User> findAll() {
        return em.createQuery("select u from User u order by u.firstName, u.lastName asc", User.class).getResultList();
    }
}