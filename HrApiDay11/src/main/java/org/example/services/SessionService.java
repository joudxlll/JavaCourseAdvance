package org.example.services;

import java.io.Serializable;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import org.example.dao.DepartmentDAO;

//depents on the client (ex: browser)
@SessionScoped
public class SessionService implements Serializable {

    private int count;

    @Inject
    DepartmentDAO dao;

    public int getCount() {
        return ++count;
    }

    //check if the creation is done ..
    @PostConstruct
    public void init(){
        System.out.println("object created succ");

    }

    //if we want to kill the conn with db or ...
    @PreDestroy
    public void kill(){
        System.out.println("object will be killed");
    }
}