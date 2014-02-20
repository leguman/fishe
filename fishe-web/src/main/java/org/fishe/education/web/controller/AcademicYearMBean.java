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
import org.fishe.education.business.AcademicYearBean;
import org.fishe.education.domain.AcademicYear;

/**
 *
 * @author sarace
 */
@ManagedBean
@RequestScoped
public class AcademicYearMBean {
    
    @EJB
    private AcademicYearBean academicYearBean;
    
    private AcademicYear academicYear;
    private List<AcademicYear> academicYears;
    
    @ManagedProperty(value="#{param.id}")
    private Integer id;
    
    @PostConstruct
    public void load() {
        if(id != null) {
            academicYear = academicYearBean.find(id);
        }
        else {
            academicYear = academicYearBean.create();
        }
    }

    public String save() {
        academicYearBean.save(academicYear);
        return "academic_years";
    }

    public String remove() {
        academicYearBean.remove(academicYear.getId());
        return "academic_years";
    }

    public AcademicYear getAcademicYear() {
        return academicYear;
    }

    public List<AcademicYear> getAcademicYears() {
         if(academicYears == null) {
            academicYears = academicYearBean.findAll();
        }
        return academicYears;
    }

    public void setId(Integer id) {
        this.id = id;
    }    
}
