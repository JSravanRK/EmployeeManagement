package com.sj.empmanagmentapplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    Connection conn = DBConnection.getConnection();

    // Add employee
    public void addEmployee(Employee emp) {

        try {

            String query = "INSERT INTO employees VALUES (?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setInt(3, emp.getAge());
            ps.setString(4, emp.getDesiganation());
            ps.setString(5, emp.getDepartment());
            ps.setDouble(6, emp.getSalary());

            ps.executeUpdate();

            System.out.println("Employee added successfully");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // View all employees
    public List<Employee> getAllEmployees(){

        List<Employee> list = new ArrayList<>();

        try {

            String query = "SELECT * FROM employees";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            while(rs.next()){

                Employee emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("designation"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                );

                list.add(emp);
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    // Get employee by ID
    public Employee getEmployeeById(int id){

        try {

            String query = "SELECT * FROM employees WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                return new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("designation"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                );
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    // Update employee
    public void updateEmployee(int id,String name,double salary){

        try {

            String query="UPDATE employees SET name=?, salary=? WHERE id=?";

            PreparedStatement ps=conn.prepareStatement(query);

            ps.setString(1,name);
            ps.setDouble(2,salary);
            ps.setInt(3,id);

            ps.executeUpdate();

            System.out.println("Employee updated successfully");

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    // Delete employee
    public void deleteEmployee(int id){

        try {

            String query="DELETE FROM employees WHERE id=?";

            PreparedStatement ps=conn.prepareStatement(query);

            ps.setInt(1,id);

            ps.executeUpdate();

            System.out.println("Employee deleted successfully");

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}