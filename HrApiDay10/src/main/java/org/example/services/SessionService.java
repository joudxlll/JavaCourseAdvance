package org.example.services;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;

@SessionScoped
public class SessionService implements Serializable {

    private int count;

    public int getCount() {
        return ++count;
    }
}