/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fishe.institution.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fishe.business.AbstractBean;
import org.fishe.institution.domain.Course;

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
