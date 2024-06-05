package org.example.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.dao.DepartmentDAO;
import org.example.dto.DepartmentFilterDto;
import org.example.models.Department;

import java.util.ArrayList;
import jakarta.ws.rs.core.*;


@Path("/departments")
public class DepartmentController {

    DepartmentDAO dao = new DepartmentDAO();
    @Context UriInfo uriInfo;
    @Context HttpHeaders headers;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getAllDepartments(
//            @QueryParam("locId") Integer locId,
//            @QueryParam("limit") Integer limit,
//            @QueryParam("offset") int offset
            @BeanParam DepartmentFilterDto filter

    ) {
        try {
            GenericEntity<ArrayList<Department>> depts = new GenericEntity<ArrayList<Department>>(dao.selectAllDepts(filter)) {};
            if(headers.getAcceptableMediaTypes().contains(MediaType.valueOf(MediaType.APPLICATION_XML))) {
                return Response
                        .ok(depts)
                        .type(MediaType.APPLICATION_XML)
                        .build();
            }
            return Response
//                    .ok()
//                    .entity(depts)
//                    .type(MediaType.APPLICATION_JSON)
                    .ok(depts, MediaType.APPLICATION_JSON)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("{deptId}")
    public Department getDepartment(@PathParam("deptId") int deptId) {

        try {
            return dao.selectDept(deptId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @DELETE
    @Path("{deptId}")
    public void deleteDepartment(@PathParam("deptId") int deptId) {

        try {
            dao.deleteDept(deptId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void insertDepartment(Department dept) {

        try {
            dao.insertDept(dept);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    @POST
//    @Consumes(MediaType.APPLICATION_XML)
//    public Response insertDepartment(Department dept) {
//
//        try {
//            dao.insertDept(dept);
//
//            return Response
//                    .status(Response.Status.CREATED)
//                    .cookie((new NewCookie.Builder("usernamee"))
//                    .build();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
    @PUT
    @Path("{deptId}")
    public void updateDepartment(@PathParam("deptId") int deptId, Department dept) {

        try {
            dept.setDepartmentId(deptId);
            dao.updateDept(dept);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    @Path("{deptId}/employees")
//    public EmployeeController getEmployeeController() {
//        return new EmployeeController();
//    }
}
