package org.example.controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.example.dao.DoctorsDAO;
import org.example.dto.DoctorFilterDTO;
import org.example.dto.DoctorConsultationScheduleDTO;
import org.example.models.Doctors;

import java.util.ArrayList;

@Path("/Doctors")
public class DoctorController {
    @Inject
    DoctorsDAO dao;

    //doctor
    @POST
    public Response insertDoc(Doctors doc) {
        try {
            dao.insertDoc(doc);
            return Response
                    .ok(doc)

                    .type(MediaType.APPLICATION_JSON)
                    .status(Response.Status.CREATED)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //test
    @GET
    public Response getAllDoctors(){
        try {
            GenericEntity<ArrayList<Doctors>> doctors = new GenericEntity<ArrayList<Doctors>>(dao.selectAllDoc()) {};

            return Response
                    .ok(doctors, MediaType.APPLICATION_JSON)
                    .build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //patient
    @GET
    @Path("/Search")
    public Response getDoctorsBySearch(
            @BeanParam DoctorFilterDTO filter

    ){
        try {
            GenericEntity<ArrayList<DoctorConsultationScheduleDTO>> doctors = new GenericEntity<ArrayList<DoctorConsultationScheduleDTO>>(dao.SearchDoctors(filter)) {};

            return Response
                    .ok(doctors, MediaType.APPLICATION_JSON)

                    .build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
