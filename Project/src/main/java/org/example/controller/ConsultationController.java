package org.example.controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.dao.ConsultationsDAO;
import org.example.dto.ConsultationFilterDto;
import org.example.dto.ConsultationsDTO;
import org.example.exceptions.DataNotFoundException;
import org.example.models.Consultations;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/Consultations")
public class ConsultationController {
    @Inject
    ConsultationsDAO dao;

    //doctor
    @GET
    public Response getAllConsultation(
            @BeanParam ConsultationFilterDto filter
    ){
        try {
            GenericEntity<ArrayList<ConsultationsDTO>> consultation = new GenericEntity<ArrayList<ConsultationsDTO>>(dao.selectAllCon(filter)) {};

            if(filter.getDoctor_id() != null && consultation.getEntity().isEmpty()){
                throw new DataNotFoundException("Doctor With ID:"+filter.getDoctor_id()+" Has No Pending Consultations");
            }
            else if (consultation.getEntity().isEmpty()) {
                throw new DataNotFoundException("No data found in consultations");
            }
            return Response
                    .ok(consultation, MediaType.APPLICATION_JSON)
//                    .header("Access-Control-Allow-Origin","*")
//                    .header("Access-Control-Allow-Methods","GET, POST,DELETE,PUT")
//                    .header("Created by", "Joud")
                    .build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //patient
    @GET
    @Path("{conId}")
    public Response getConsultation(@PathParam("conId") int conId){
        try {
            ConsultationsDTO con = dao.selectCon(conId);

            if (con == null) {
                throw new DataNotFoundException("Consultation " + conId + " Not found");
            }

//            ConsultationsDTO dto = ConsultationMapper.INSTANCE.toConDto(con);

            return Response
                    .ok(con)
//                    .header("Access-Control-Allow-Origin","*")
//                    .header("Access-Control-Allow-Methods","GET, POST,DELETE,PUT")
                    .build();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    //patient
    @POST
    public Response insertCon(Consultations con) {
        try {
            dao.insertCon(con);
            return Response
                    .ok(con)
                    .type(MediaType.APPLICATION_JSON)
                    .status(Response.Status.CREATED)
//                    .header("Access-Control-Allow-Origin","*")
//                    .header("Access-Control-Allow-Methods","GET, POST,DELETE,PUT")
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //doctor
    @PUT
    @Path("{conId}")
    public Response updateCon(@PathParam("conId") int conId, Consultations con) {

        try {
            con.setDoctor_id(conId);
            dao.updateCon(con);
            return Response
                    .ok(con)
//                    .header("Access-Control-Allow-Origin","*")
//                    .header("Access-Control-Allow-Methods","GET, POST,DELETE,PUT")
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //patient
    @PUT
    @Path("/Rate/{conId}")
    public Response updateRate(@PathParam("conId") int conId, Consultations con) {

        try {
            con.setConsultation_id(conId);
            dao.updateRate(con);
            return Response
                    .ok(con)
//                    .header("Access-Control-Allow-Origin","*")
//                    .header("Access-Control-Allow-Methods","GET, POST,DELETE,PUT")
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
