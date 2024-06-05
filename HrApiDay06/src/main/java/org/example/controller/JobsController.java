package org.example.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.dao.JobDAO;
import org.example.dto.DepartmentFilterDto;
import org.example.dto.JobFilterDto;
import org.example.models.Department;
import org.example.models.Jobs;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/jobs")
public class JobsController {
        JobDAO dao = new JobDAO();

        @GET
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        public ArrayList<Jobs> getAllJobs(
//                  @QueryParam("minsalary") Double minSalary
                @BeanParam JobFilterDto filter

        ){ //queryParm written as /?minsalary = 4200
            try {
                try {
                    return dao.selectAlljob(filter);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

        @GET
        @Path("{jobId}")
        public Jobs getJobs(@PathParam("jobId") int jobId){ // we write the parameter without ?
            try {
                return dao.selectjob(jobId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        @POST
        public void insertJob(Jobs job) {

            try {
                dao.inserjob(job);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @DELETE
        @Path("{jobId}")
        public void deleteJob(@PathParam("jobId") int jobId) {

            try {
                dao.deletejob(jobId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


        @PUT
        @Path("{jobId}")
        public void updateJob(@PathParam("jobId") int jobId, Jobs job) {

            try {
                job.setJob_id(jobId);
                dao.updatejob(job);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


