/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fishe.institution.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.fishe.domain.Identified;

/**
 *
 * @author hanghoang
 */
@Entity
@Table (name="programme")
public class Programme implements Serializable, Identified<Integer>{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="short_title")
    private String shortTitle;

    @Column(name="full_title")
    private String fullTitle;
    
    @Column (name="number_of_credit")
    private int creditsTotal;
    
    @Column (name="degree")
    private String degree;
    
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getDegree() {
        return degree;
    }
    
    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getCreditsTotal() {
        return creditsTotal;
    }

    public void setCreditsTotal(int creditsTotal) {
        this.creditsTotal = creditsTotal;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programme)) {
            return false;
        }
        Programme other = (Programme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return fullTitle;
    }
    
}
