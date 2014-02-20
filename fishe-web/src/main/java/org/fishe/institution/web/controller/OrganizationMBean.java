package org.fishe.institution.web.controller;

import org.fishe.institution.business.BuildingBean;
import org.fishe.institution.business.OrganizationBean;
import org.fishe.institution.domain.Building;
import org.fishe.institution.domain.Organization;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

/**
 * 
 * @author Hildeberto Mendonça
 */
@ManagedBean
@RequestScoped
public class OrganizationMBean {

    @EJB
    private OrganizationBean organizationBean;

    private List<Organization> organizations;
    private List<Organization> underOrganizations;

    @ManagedProperty(value="#{param.id}")
    private Integer id;

    private Organization organization;

    public List<Organization> getOrganizations() {
        if(this.organizations == null) {
            this.organizations = organizationBean.findParents();
        }
        return this.organizations;
    }

    public List<Organization> getUnderOrganizations() {
        if(this.underOrganizations == null && this.organization != null) {
            this.underOrganizations = organizationBean.findUnder(this.organization);
        }
        return this.underOrganizations;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Organization getOrganization() {
        return this.organization;
    }

    @PostConstruct
    public void load() {
        if(id != null) {
            this.organization = organizationBean.find(id);
        }
        else {
            this.organization = organizationBean.create();
        }
    }

    public String save() {
        organizationBean.save(this.organization);
        return "organizations";
    }

    public String remove() {
        organizationBean.remove(this.organization.getId());
        return "organizations";
    }
}