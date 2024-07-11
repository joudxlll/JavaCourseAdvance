package org.example.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.dao.Medical_ReportDAO;
import org.example.models.Medical_Reports;

import java.util.ArrayList;

@Path("/MR")
public class Medical_ReportsController {
    @Inject
    Medical_ReportDAO dao;

    //patient and doctor
    @GET
    @Path("{patId}")
    public Response getAllMR(@PathParam("patId") int patId){
        try {
            GenericEntity<ArrayList<Medical_Reports>> MR = new GenericEntity<ArrayList<Medical_Reports>>(dao.selectAllMR(patId)) {};

            return Response
                    .ok(MR, MediaType.APPLICATION_JSON)
//                    .header("Access-Control-Allow-Origin","*")
//                    .header("Access-Control-Allow-Methods","GET, POST,DELETE,PUT")
                    .build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
