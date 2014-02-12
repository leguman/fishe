package org.fishe.institution.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fishe.business.AbstractBean;
import org.fishe.institution.domain.Partner;

/**
 *
 * @author axel
 */
@Stateless
public class PartnerBean extends AbstractBean<Partner> {

    @PersistenceContext
    private EntityManager em;

    public PartnerBean() {
        super(Partner.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Partner> findAll() {
        return em.createQuery("SELECT p FROM Partner p ORDER BY p.name ASC", Partner.class).getResultList();
    }
}
