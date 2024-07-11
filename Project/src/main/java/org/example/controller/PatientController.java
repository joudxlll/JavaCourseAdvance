package org.example.controller;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.dao.PatientsDAO;
import org.example.models.Patients;

import java.util.ArrayList;

@Path("/Patients")
public class PatientController {
    @Inject
    PatientsDAO dao;

    //patient
    @POST
    public Response insertPat(Patients pat) {
        try {
            dao.insertPat(pat);
            return Response
                    .ok(pat)
//                    .header("Access-Control-Allow-Origin","*")
//                    .header("Access-Control-Allow-Methods","GET, POST,DELETE,PUT")
                    .status(Response.Status.CREATED)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //test
    @GET
    public Response getAllPatients(){
        try {
            GenericEntity<ArrayList<Patients>> patients = new GenericEntity<ArrayList<Patients>>(dao.selectAllPat()) {};

            return Response
                    .ok(patients, MediaType.APPLICATION_JSON)
                    .build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
