package org.fishe.institution.business;

import org.fishe.business.AbstractBean;
import org.fishe.institution.domain.Building;
import org.fishe.institution.domain.Organization;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author leymouna
 */
@Stateless
public class OrganizationBean extends AbstractBean<Organization> {

    @PersistenceContext
    private EntityManager em;

    public OrganizationBean() {
        super(Organization.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Organization> findParents() {
        return em.createQuery("select o from Organization o where o.parent is null order by o.name", Organization.class)
                .getResultList();
    }

    public List<Organization> findUnder(Organization organization) {
        return em.createQuery("select o from Organization o where o.parent = :organization order by o.name", Organization.class)
                .setParameter("organization", organization)
                .getResultList();
    }
}