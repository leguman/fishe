/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fishe.education.web.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.fishe.education.business.DomainBean;
import org.fishe.education.domain.Domain;

/**
 *
 * @author bruyere
 */
@ManagedBean
@RequestScoped
public class DomainMBean {
    
    @EJB
    private transient DomainBean domainBean;
    private List<Domain> domains;
    private Domain domain;
    @ManagedProperty(value = "#{param.id}")
    private Integer id;

    @PostConstruct
    public void load() {
        if (id != null) {
            this.domain = domainBean.find(id);
        } else {
            this.domain = domainBean.create();
        }
    }

    public String save() {
        domainBean.save(this.domain);
        return "domain";
    }

    public String remove() {
        domainBean.remove(this.domain.getId());
        return "domains";
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Domain> getDomains() {
        if (domains == null) {
            domains = domainBean.findAll();
        }
        return domains;
    }

    public Domain getDomain() {
        return this.domain;
    }
}
