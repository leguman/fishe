package org.fishe.institution.web.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.fishe.institution.business.BuildingBean;
import org.fishe.institution.business.OrganizationBean;
import org.fishe.institution.domain.Building;
import org.fishe.institution.domain.Organization;

/**
 * 
 * @author leymouna
 */
@ManagedBean
@RequestScoped
public class BuildingMBean {

    @EJB
    private BuildingBean buildingBean;

    @EJB
    private OrganizationBean organizationBean;

    private List<Building> buildings;

    @ManagedProperty(value="#{param.id}")
    private Integer id;

    @ManagedProperty(value = "#{organizationFilterMBean}")
    private OrganizationFilterMBean organizationFilterMBean;

    private Building building;

    private List<Organization> organizations;

    public List<Building> getBuildings() {
        if(buildings == null && organizationFilterMBean.getSelectedOrganization() != null) {
            Organization organization = organizationBean.find(organizationFilterMBean.getSelectedOrganization());
            buildings = buildingBean.findBy(organization);
        }
        return buildings;
    }

    public List<Organization> getOrganizations() {
        if(this.organizations == null) {
            this.organizations = organizationBean.findAll();
        }
        return this.organizations;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrganizationFilterMBean(OrganizationFilterMBean organizationFilterMBean) {
        this.organizationFilterMBean = organizationFilterMBean;
    }

    public Integer getSelectedOrganization() {
        return this.organizationFilterMBean.getSelectedOrganization();
    }

    public void setSelectedOrganization(Integer selectedOrganization) {
        this.organizationFilterMBean.setSelectedOrganization(selectedOrganization);
    }

    public Building getBuilding() {
        return this.building;
    }

    @PostConstruct
    public void load() {
        if(id != null) {
            this.building = buildingBean.find(id);
        }
        else {
            this.building = buildingBean.create();
        }
    }

    public String save() {
        Organization organization = organizationBean.find(this.organizationFilterMBean.getSelectedOrganization());
        this.building.setOrganization(organization);

        buildingBean.save(this.building);
        return "buildings?faces-redirect=true";
    }

    public String remove() {
        buildingBean.remove(this.building.getId());
        return "buildings?faces-redirect=true";
    }
}