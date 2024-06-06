package org.example.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.dao.DepartmentDAO;
import org.example.dto.DepartmentDto;
import org.example.dto.DepartmentFilterDto;
import org.example.exceptions.DataNotFoundException;
import org.example.models.Department;

import java.net.URI;
import java.sql.SQLException;
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
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, "text/csv"})
    public Response getDepartment(@PathParam("deptId") int deptId) {

        try {
            Department dept = null;
            try {
                dept = dao.selectDept(deptId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if (dept == null) {
                throw new DataNotFoundException("Department " + deptId + "Not found");
            }

            DepartmentDto dto = new DepartmentDto();
            dto.setDepartmentId(dept.getDepartmentId());
            dto.setDepartmentName(dept.getDepartmentName());
            dto.setLocationId(dept.getLocationId());

            addLinks(dto);

            return Response.ok(dto).build();
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private void addLinks(DepartmentDto dto) {
        URI selfUri = uriInfo.getAbsolutePath();
        URI empsUri = uriInfo.getAbsolutePathBuilder()
                .path(EmployeeController.class)
                .build();

        dto.addLink(selfUri.toString(), "self");
        dto.addLink(empsUri.toString(), "employees");
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
//    @Consumes(MediaType.APPLICATION_XML)
    public Response insertDepartment(Department dept) {

        try {
            dao.insertDept(dept);
            NewCookie cookie = (new NewCookie.Builder("username")).value("OOOOO").build();
            URI uri = uriInfo.getAbsolutePathBuilder().path(dept.getDepartmentId() + "").build();
            return Response
//                    .status(Response.Status.CREATED)
                    .created(uri)
//                    .cookie(new NewCookie("username", "OOOOO"))
                    .cookie(cookie)
                    .header("Created by", "Joud")
                    .build();
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

    @Path("{deptId}/employees")
    public EmployeeController getEmployeeController() {
        return new EmployeeController();
    }
}
