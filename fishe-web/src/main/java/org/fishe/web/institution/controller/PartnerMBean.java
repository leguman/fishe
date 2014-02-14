package org.fishe.web.institution.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.fishe.institution.business.PartnerBean;
import org.fishe.institution.domain.Partner;

/**
 *
 * @author axel
 */
@ManagedBean
@RequestScoped
public class PartnerMBean {

    @EJB
    private transient PartnerBean partnerBean;
    private List<Partner> partners;
    private Partner partner;
    @ManagedProperty(value = "#{param.id}")
    private Integer id;

    @PostConstruct
    public void load() {
        if (id != null) {
            this.partner = partnerBean.find(id);
        } else {
            this.partner = partnerBean.create();
        }
    }

    public String save() {
        partnerBean.save(this.partner);
        return "partners";
    }

    public String remove() {
        partnerBean.remove(this.partner.getId());
        return "partners";
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Partner> getPartners() {
        if (partners == null) {
            partners = partnerBean.findAll();
        }
        return partners;
    }

    public Partner getPartner() {
        return this.partner;
    }
}
