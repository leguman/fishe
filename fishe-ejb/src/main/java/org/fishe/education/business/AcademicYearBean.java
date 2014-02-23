package org.fishe.education.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fishe.business.AbstractBean;
import org.fishe.education.domain.AcademicYear;

/**
 *
 * @author sarace
 */
@Stateless
public class AcademicYearBean extends AbstractBean<AcademicYear> {

    @PersistenceContext
    private EntityManager em;

    public AcademicYearBean() {
        super(AcademicYear.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Find all Academic Years
     *
     * @return The list of all academics years in the database.
     */
    public List<AcademicYear> findAll() {
        return em.createQuery("select ay from AcademicYear ay order by ay.academicYear asc", AcademicYear.class).getResultList();
    }

}
