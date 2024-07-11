package org.example.controller;
import jakarta.ws.rs.Path;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.dao.SchedulesDAO;
import org.example.dto.SchedulesDTO;
import org.example.exceptions.DataNotFoundException;
import org.example.mappers.ScheduleMapper;
import org.example.models.Schedules;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/Schedule")
public class ScheduleController {
    @Inject
    SchedulesDAO dao;

    //doctor
    @POST
    public Response insertDoc(Schedules sch) {
        try {
            dao.insertSch(sch);
            return Response
                    .ok(sch)
                    .type(MediaType.APPLICATION_JSON)

//                    .header("Access-Control-Allow-Origin","*")
//                    .header("Access-Control-Allow-Methods","GET, POST,DELETE,PUT")
                    .status(Response.Status.CREATED)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //doctor
    @PUT
    @Path("{schId}")
    public Response updateSchedule(@PathParam("schId") int schId, Schedules sch) {

        try {
            sch.setSchedule_id(schId);
            dao.updateSch(sch);
            return Response
                    .ok(sch)
//                    .header("Access-Control-Allow-Origin","*")
//                    .header("Access-Control-Allow-Methods","GET, POST,DELETE,PUT")
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //test
    @GET
    public Response getAllSchedules(){
        try {
            GenericEntity<ArrayList<Schedules>> schedules = new GenericEntity<ArrayList<Schedules>>(dao.selectAllSch()) {};

            return Response
                    .ok(schedules, MediaType.APPLICATION_JSON)
//                    .header("Access-Control-Allow-Origin","*")
//                    .header("Access-Control-Allow-Methods","GET, POST,DELETE,PUT")
                    .build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //doctor
    @GET
    @Path("{docId}")
    public Response getSchedule(@PathParam("docId") int docId) {
        try {
            Schedules sch = dao.selectDoctorSch(docId);

            if (sch == null) {
                throw new DataNotFoundException("Doctor schedule not found");
            }

            SchedulesDTO dto = ScheduleMapper.INSTANCE.toSchDto(sch);

            return Response
                    .ok(dto)
//                    .header("Access-Control-Allow-Origin","*")
//                    .header("Access-Control-Allow-Methods","GET, POST,DELETE,PUT")
                    .build();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
