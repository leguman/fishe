package org.fishe.institution.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fishe.business.AbstractBean;
import org.fishe.institution.domain.Programme;

/**
 *
 * @author hanghoang
 */
@Stateless
@LocalBean
public class ProgrammeBean extends AbstractBean<Programme>{

    @PersistenceContext
    private EntityManager em;
    public ProgrammeBean() {
        super(Programme.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Programme> findAll() {
        return em.createQuery("select p from Programme p order by p.shortTitle asc", Programme.class).getResultList();
    }

}
