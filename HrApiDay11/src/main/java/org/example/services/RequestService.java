package org.example.services;


import jakarta.enterprise.context.RequestScoped;

//every time it create a new object
@RequestScoped
public class RequestService {

    private int count;

    public int getCount() {
        return ++count;
    }


}