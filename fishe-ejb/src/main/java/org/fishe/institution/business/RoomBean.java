package org.fishe.institution.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fishe.business.AbstractBean;
import org.fishe.institution.domain.Room;

/**
 *
 * @author verpoorten
 */
@Stateless
public class RoomBean extends AbstractBean<Room> {

    @PersistenceContext
    private EntityManager em;

    public RoomBean() {
        super(Room.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Room> findAll() {
        return em.createQuery("select u from Room u order by u.description asc", Room.class).getResultList();
    }
}