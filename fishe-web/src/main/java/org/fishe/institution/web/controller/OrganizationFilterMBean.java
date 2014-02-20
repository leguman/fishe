package org.fishe.institution.web.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by mendoncafilh on 20/02/14.
 */
@SessionScoped
@ManagedBean
public class OrganizationFilterMBean implements Serializable {

    private Integer selectedOrganization;

    public Integer getSelectedOrganization() {
        return selectedOrganization;
    }

    public void setSelectedOrganization(Integer selectedOrganization) {
        this.selectedOrganization = selectedOrganization;
    }

    @PostConstruct
    public void load() {

    }
}