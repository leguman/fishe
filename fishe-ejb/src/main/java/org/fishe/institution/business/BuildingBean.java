package org.fishe.institution.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fishe.business.AbstractBean;
import org.fishe.institution.domain.Building;

/**
 *
 * @author leymouna
 */
@Stateless
public class BuildingBean extends AbstractBean<Building> {

    @PersistenceContext
    private EntityManager em;

    public BuildingBean() {
        super(Building.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Building> findAll() {
        return em.createQuery("select b from Building b order by b.name asc", Building.class).getResultList();
    }
}