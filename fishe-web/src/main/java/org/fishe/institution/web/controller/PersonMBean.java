/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fishe.institution.web.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.fishe.institution.business.PersonBean;
import org.fishe.institution.domain.Person;


/**
 *
 * @author bosman
 */
@ManagedBean
@RequestScoped
public class PersonMBean {

    /**
     * Creates a new instance of PersonMBean
     */
   @EJB
   private PersonBean personBean;
    private List<Person> people;

    @ManagedProperty(value="#{param.id}")
    private Integer id;

    private Person person;

    public List<Person> getPeople() {
        if(people == null) {
            people = personBean.findAll();
        }
        return people;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return this.person;
    }

    @PostConstruct
    public void load() {
        if(id != null) {
            this.person = personBean.find(id);
        }
        else {
            this.person = personBean.create();
        }
    }

    public String save() {
        personBean.save(this.person);
        return "people";
    }

    public String remove() {
        personBean.remove(this.person.getId());
        return "people";
    }
    
}
