package org.fishe.institution.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fishe.business.AbstractBean;
import org.fishe.institution.domain.Function;

/**
 *
 * @author enizeyimana
 */
@Stateless
public class FunctionBean extends AbstractBean<Function> {

    @PersistenceContext
    private EntityManager em;

    public FunctionBean() {
        super(Function.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Function> findAll() {
        return em.createQuery("SELECT f FROM Function f ORDER BY f.name ASC", Function.class).getResultList();
    }
}
