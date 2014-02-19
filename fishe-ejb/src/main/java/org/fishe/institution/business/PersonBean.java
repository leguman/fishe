/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
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
import org.fishe.institution.domain.Person;

/**
 *
 * @author bosman
 */
@Stateless
public class PersonBean extends AbstractBean<Person> {
    @PersistenceContext
    private EntityManager em;

   

    public PersonBean() {
        super(Person.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public List<Person> findAll() {
        return em.createQuery("select p from Person p order by p.firstName, p.lastName asc", Person.class).getResultList();
    }
}
