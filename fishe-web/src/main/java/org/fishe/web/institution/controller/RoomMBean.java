package org.fishe.web.institution.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.fishe.institution.business.RoomBean;
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

    private List<Room> rooms;

    @ManagedProperty(value="#{param.id}")
    private Integer id;

    private Room room;

    public List<Room> getRooms() {
        if(rooms == null) {
            rooms = roomBean.findAll();
        }
        return rooms;
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
        }
        else {
            this.room = roomBean.create();
        }
    }

    public String save() {
        roomBean.save(this.room);
        return "rooms";
    }

    public String remove() {
        roomBean.remove(this.room.getId());
        return "rooms";
    }
}