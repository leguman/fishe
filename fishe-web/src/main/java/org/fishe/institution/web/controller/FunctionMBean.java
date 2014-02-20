/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fishe.institution.web.controller;



import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.fishe.institution.business.FunctionBean;
import org.fishe.institution.domain.Function;

/**
 *
 * @author enizeyimana
 */

@ManagedBean
@RequestScoped
public class FunctionMBean {
    
    @EJB
    private transient FunctionBean functionBean;
    private List<Function> functions;
    private Function function;
    @ManagedProperty(value = "#{param.id}")
    private Integer id;

    @PostConstruct
    public void load() {
        if (id != null) {
            this.function = functionBean.find(id);
        } else {
            this.function = functionBean.create();
        }
    }

    public String save() {
        functionBean.save(this.function);
        return "functions";
    }

    public String remove() {
        functionBean.remove(this.function.getId());
        return "functions";
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FunctionBean getFunctionBean() {
        return functionBean;
    }

    public void setFunctionBean(FunctionBean functionBean) {
        this.functionBean = functionBean;
    }

    public List<Function> getFunctions() {
          if (functions == null) {
            functions = functionBean.findAll();
        }
        return functions;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

 
    
 
}