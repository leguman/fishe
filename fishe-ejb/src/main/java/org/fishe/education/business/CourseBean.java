package org.fishe.education.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fishe.business.AbstractBean;
import org.fishe.education.domain.Course;

/**
 *
 * @author leguman
 */
@Stateless
public class CourseBean extends AbstractBean<Course> {

    @PersistenceContext
    private EntityManager em;

    public CourseBean() {
        super(Course.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Course> findAll() {
        return em.createQuery("select c from Course c order by c.name asc", Course.class).getResultList();
    }
}
