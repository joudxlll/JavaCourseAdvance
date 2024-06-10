package org.example.services;


import jakarta.enterprise.context.ApplicationScoped;

//depents on the server (ex: terminal)
@ApplicationScoped
public class ApplicationService {

    private int count;

    public int getCount() {
        return ++count;
    }
}