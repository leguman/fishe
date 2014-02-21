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
import org.fishe.education.business.ProgrammeBean;
import org.fishe.education.domain.Programme;

/**
 *
 * @author hanghoang
 */
@ManagedBean
@RequestScoped
public class ProgrammeMBean {
    @EJB
    private ProgrammeBean programmeBean;

    private List<Programme> programmes;

    @ManagedProperty(value="#{param.id}")
    private Integer id;

    private Programme programme;

    public List<Programme> getProgrammes() {
        if(programmes == null) {
            programmes = programmeBean.findAll();
        }
        return programmes;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }


    @PostConstruct
    public void load() {
        if(id != null) {
            this.programme = programmeBean.find(id);
        }
        else {
            this.programme = programmeBean.create();
        }
    }

    public String save() {
        programmeBean.save(this.programme);
        return "programmes";
    }

    public String remove() {
        programmeBean.remove(this.programme.getId());
        return "programmes";
    }
}