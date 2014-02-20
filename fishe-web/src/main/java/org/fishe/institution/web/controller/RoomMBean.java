package org.fishe.institution.web.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.fishe.institution.business.BuildingBean;
import org.fishe.institution.business.OrganizationBean;
import org.fishe.institution.business.RoomBean;
import org.fishe.institution.domain.Building;
import org.fishe.institution.domain.Organization;
import org.fishe.institution.domain.Room;

/**
 *
 * @author Hildeberto Mendonca
 */
@ManagedBean
@RequestScoped
public class RoomMBean {

    @EJB
    private RoomBean roomBean;

    @EJB
    private OrganizationBean organizationBean;

    @EJB
    private BuildingBean buildingBean;

    private List<Room> rooms;
    private List<Organization> organizations;
    private List<Building> buildings;

    private Integer selectedBuilding;

    @ManagedProperty(value="#{param.id}")
    private Integer id;

    @ManagedProperty(value = "#{organizationFilterMBean}")
    private OrganizationFilterMBean organizationFilterMBean;

    private Room room;

    public List<Room> getRooms() {
        if(rooms == null) {
            rooms = roomBean.findAll();
        }
        return rooms;
    }

    public List<Organization> getOrganizations() {
        if(this.organizations == null) {
            this.organizations = organizationBean.findAll();
        }
        return organizations;
    }

    public List<Building> getBuildings() {
        if(this.buildings == null && this.organizationFilterMBean.getSelectedOrganization() != null) {
            Organization organization = organizationBean.find(this.organizationFilterMBean.getSelectedOrganization());
            this.buildings = buildingBean.findBy(organization);
        }
        return buildings;
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

    public Integer getSelectedBuilding() {
        return selectedBuilding;
    }

    public void setSelectedBuilding(Integer selectedBuilding) {
        this.selectedBuilding = selectedBuilding;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Room getRoom() {
        return this.room;
    }

    @PostConstruct
    public void load() {
        if(id != null) {
            this.room = roomBean.find(id);
            if(this.room.getBuilding() != null) {
                this.selectedBuilding = this.room.getBuilding().getId();
                this.setSelectedOrganization(this.room.getBuilding().getOrganization().getId());
            }
        }
        else {
            this.room = roomBean.create();
        }
    }

    public String save() {
        Building building = buildingBean.find(this.selectedBuilding);
        this.room.setBuilding(building);

        roomBean.save(this.room);
        return "rooms";
    }

    public String remove() {
        roomBean.remove(this.room.getId());
        return "rooms";
    }
}