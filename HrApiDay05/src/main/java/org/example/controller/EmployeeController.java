package org.example.controller;

import jakarta.ws.rs.*;
import org.example.dao.EmployeeDAO;
import org.example.models.Employees;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/employees")
public class EmployeeController {
    EmployeeDAO dao = new EmployeeDAO();

    @GET
    public ArrayList<Employees> getAllEmployees(){
        try {
            return dao.selectAllEmps();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @GET
    @Path("{empId}")
    public Employees getEmployees(){
        try {
            return dao.selectEMP(5);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @POST
    public void insertEmployee(Employees emp) {

        try {
            dao.insertEmp(emp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DELETE
    @Path("{empId}")
    public void deleteEmployee(@PathParam("empId") int empId) {

        try {
            dao.deleteEmp(empId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("{empId}")
    public void updateEmployee(@PathParam("empId") int emptId, Employees emp) {

        try {
            emp.setEmployee_id(emptId);
            dao.updateEmp(emp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
