package org.fishe.web.institution.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.fishe.institution.business.BuildingBean;
import org.fishe.institution.domain.Building;

/**
 * 
 * @author leymouna
 */
@ManagedBean
@RequestScoped
public class BuildingMBean {

    @EJB
    private BuildingBean buildingBean;

    private List<Building> buildings;

    @ManagedProperty(value="#{param.id}")
    private Integer id;

    private Building building;

    public List<Building> getBuildings() {
        if(buildings == null) {
            buildings = buildingBean.findAll();
        }
        return buildings;
    }

    public void setId(Integer id) {
        this.id = id;
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
        buildingBean.save(this.building);
        return "buildings";
    }

    public String remove() {
        buildingBean.remove(this.building.getId());
        return "buildings";
    }
}