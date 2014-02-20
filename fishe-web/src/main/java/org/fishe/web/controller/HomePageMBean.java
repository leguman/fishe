package org.fishe.web.controller;

import org.fishe.business.WebSourceBean;
import org.fishe.domain.WebSource;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

/**
 * Created by mendoncafilh on 19/02/14.
 */
@ManagedBean
@RequestScoped
public class HomePageMBean {

    @EJB
    private WebSourceBean webSourceBean;

    private WebSource webSource;

    public WebSource getWebSource() {
        if(this.webSource == null) {
            this.webSource = webSourceBean.loadWebSource("http://fishe.org/feed/");
        }
        return this.webSource;
    }
}