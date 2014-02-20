/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fishe.education.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.fishe.business.AbstractBean;
import org.fishe.education.domain.Domain;

/**
 *
 * @author bruyere
 */
@Stateless
public class DomainBean  extends AbstractBean<Domain> {

    @PersistenceContext
    private EntityManager em;

    public DomainBean() {
        super(Domain.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Domain> findAll() {
        return em.createQuery("SELECT p FROM Domain p ORDER BY p.name ASC", Domain.class).getResultList();
    }
}
