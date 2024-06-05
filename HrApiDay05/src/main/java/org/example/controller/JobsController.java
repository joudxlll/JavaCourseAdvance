package org.example.controller;

import jakarta.ws.rs.*;
import org.example.dao.JobDAO;
import org.example.models.Jobs;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/jobs")
public class JobsController {
        JobDAO dao = new JobDAO();

        @GET
        public ArrayList<Jobs> getAllJobs(){
            try {
                return dao.selectAlljob();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

        @GET
        @Path("{jobId}")
        public Jobs getJobs(){
            try {
                return dao.selectjob(5);
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


