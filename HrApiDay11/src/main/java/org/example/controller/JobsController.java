package org.example.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.example.dao.JobDAO;
import org.example.dto.DepartmentDto;
import org.example.dto.JobFilterDto;
import org.example.dto.JobsDto;
import org.example.mappers.DepartmentMapper;
import org.example.mappers.JobMapper;
import org.example.models.Jobs;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/jobs")
public class JobsController {
        JobDAO dao = new JobDAO();
        @Context UriInfo uriInfo;
        @Context HttpHeaders headers;

        @GET
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        public Response getAllJobs(
//                  @QueryParam("minsalary") Double minSalary
                @BeanParam JobFilterDto filter

        ){ //queryParm written as /?minsalary = 4200
            try {
                try {
                    System.out.println("I'm here");
                    GenericEntity<ArrayList<Jobs>> jobs = new GenericEntity<ArrayList<Jobs>>(dao.selectAlljob(filter)) {};
                    if(headers.getAcceptableMediaTypes().contains(MediaType.valueOf(MediaType.APPLICATION_XML))) {
                        return Response
                                .ok(jobs)
                                .type(MediaType.APPLICATION_XML)
                                .build();
                    }
                    return Response
//                    .ok()
//                    .entity(depts)
//                    .type(MediaType.APPLICATION_JSON)
                            .ok(jobs, MediaType.APPLICATION_JSON)
                            .build();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

        }


        private void addLinks(JobsDto dto){
                    URI selfURL = uriInfo.getAbsolutePath();
                    URI empURL = uriInfo.getAbsolutePathBuilder()
                            .path(EmployeeController.class)
                            .build();

                    dto.addLink(selfURL.toString(), "self");
                    dto.addLink(empURL.toString(), "employee");

        }
//        @GET
//        @Path("{jobId}")
//        public Jobs getJobs(@PathParam("jobId") int jobId){ // we write the parameter without ?
//            try {
//                return dao.selectjob(jobId);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }

        @GET
        @Path("{jobId}")
        public Response getJobs(@PathParam("jobId") int jobId){ // we write the parameter without ?
            try {
                Jobs job = null;
                try {
                    job = dao.selectjob(jobId);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

//                JobsDto dto = new JobsDto();
//                dto.setJob_id(job.getJob_id());
//                dto.setJob_title(job.getJob_title());
//                dto.setJob_MinSalary(job.getJob_Minsalary());
                JobsDto dto = JobMapper.INSTANCE.tojobDto(job);

                addLinks(dto);

                return Response.ok(dto).build();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        @POST
        public Response insertJob(JobsDto dto) {

            try {
                Jobs job = JobMapper.INSTANCE.toModel(dto);

                dao.inserjob(job);
                NewCookie cookie = (new NewCookie.Builder("username")).value("OOOOO").build();
                URI uri = uriInfo.getAbsolutePathBuilder().path(job.getJob_id() + "").build();
                return Response
//                    .status(Response.Status.CREATED)
                        .created(uri)
//                    .cookie(new NewCookie("username", "OOOOO"))
                        .cookie(cookie)
                        .header("Created by", "Wael")
                        .build();
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


