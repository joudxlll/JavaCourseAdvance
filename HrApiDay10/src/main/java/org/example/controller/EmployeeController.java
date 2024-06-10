package org.example.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.example.dao.EmployeeDAO;
import org.example.dao.JobDAO;
import org.example.dto.EmployeeDto;
import org.example.dto.EmployeeFilterDto;
import org.example.exceptions.EmployeeServiceException;
import org.example.mappers.EmployeeMapper;
import org.example.mappers.JobMapper;
import org.example.models.Employees;
import org.example.exceptions.DataNotFoundException;
import org.example.models.Jobs;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/employees")
public class EmployeeController {
    EmployeeDAO dao = new EmployeeDAO();
    @Context UriInfo uriInfo;
    @Context HttpHeaders headers;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, "text/csv"})
    public Response getAllEmployees(
            @BeanParam EmployeeFilterDto filter
    ){
        try {
            GenericEntity<ArrayList<Employees>> emps = new GenericEntity<ArrayList<Employees>>(dao.selectAllEmps(filter)) {};
            if(headers.getAcceptableMediaTypes().contains(MediaType.valueOf(MediaType.APPLICATION_XML))) {
                return Response
                        .ok(emps)
                        .type(MediaType.APPLICATION_XML)
                        .build();
            }
            else if(headers.getAcceptableMediaTypes().contains(MediaType.valueOf("text/csv"))) {
                return Response
                        .ok(emps)
                        .type("text/csv")
                        .build();
            }

            return Response
                    .ok(emps, MediaType.APPLICATION_JSON)
                    .build();

        } catch (Exception e) {
            throw new EmployeeServiceException("An unexpected error occurred while fetching employees");
        }

    }

//    @GET
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, "text/csv"})
//    public ArrayList<Employees> getAllEmployees(){
//        try {
//            try {
//                return dao.selectAllEmps();
//            } catch (ClassNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }


    @GET
    @Path("{empId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, "text/csv"})
    public Response getEmployee(@PathParam("empId") int empId){
        try {
            Employees emp = null;
            Jobs job;
            try {
                emp = dao.selectEMP(empId);
                job = new JobDAO().selectjob(emp.getJob_id());

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            if (emp == null) {
                throw new DataNotFoundException("Employee " + empId + " Not found");
            }
//            Location loc = locDao.selectLoc(dept.getLocationId());

//            DepartmentDto dto = DepartmentMapper.INSTANCE.toDeptDto(dept, loc);

            EmployeeDto dto = EmployeeMapper.INSTANCE.toEmpDto(emp, job);
//            dto.setEmployee_id(emp.getEmployee_id());
//            dto.setHire_date(emp.getHire_date());
//            dto.setJob_id(emp.getJob_id());

            addLinks(dto);

            return Response.ok(dto).build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void addLinks(EmployeeDto dto) {
        URI selfUri = uriInfo.getAbsolutePath();
        URI empsUri = uriInfo.getAbsolutePathBuilder()
                .path(JobsController.class)
                .build();

        dto.addLink(selfUri.toString(), "self");
        dto.addLink(empsUri.toString(), "employee job");
    }

    @POST
    public void insertEmployee(Employees emp) {

        try {
            dao.insertEmp(emp);
        } catch (Exception e) {
            throw new EmployeeServiceException("An unexpected error occurred while inserting employee");
        }
    }

    @DELETE
    @Path("{empId}")
    public void deleteEmployee(@PathParam("empId") int empId) {

        try {
            dao.deleteEmp(empId);
        } catch (Exception e) {
            throw new EmployeeServiceException("An unexpected error occurred while deleting employee");
        }
    }

    @PUT
    @Path("{empId}")
    public void updateEmployee(@PathParam("empId") int emptId, Employees emp) {

        try {
            emp.setEmployee_id(emptId);
            dao.updateEmp(emp);
        } catch (Exception e) {
            throw new EmployeeServiceException("An unexpected error occurred while updating employee");
        }
    }
}
