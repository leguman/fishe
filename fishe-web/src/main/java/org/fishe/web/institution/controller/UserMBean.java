package org.fishe.web.institution.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.fishe.institution.business.UserBean;
import org.fishe.institution.domain.User;

/**
 *
 * @author Hildeberto Mendonca
 */
@ManagedBean
@RequestScoped
public class UserMBean {

    @EJB
    private UserBean userBean;

    private List<User> users;

    @ManagedProperty(value="#{param.id}")
    private Integer id;

    private User user;

    public List<User> getUsers() {
        if(users == null) {
            users = userBean.findAll();
        }
        return users;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    @PostConstruct
    public void load() {
        if(id != null) {
            this.user = userBean.find(id);
        }
        else {
            this.user = new User();
        }
    }

    public String save() {
        userBean.save(this.user);
        return "users";
    }
}