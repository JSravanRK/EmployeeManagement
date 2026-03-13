package com.sj.empmanagmentapplication;

import java.util.Scanner;

public class EmployeeService {

    Scanner sc = new Scanner(System.in);

    EmployeeDAO dao = new EmployeeDAO();

    public void addEmp() {

        System.out.println("Enter id:");
        int id = sc.nextInt();

        System.out.println("Enter name:");
		sc.nextLine();
		String name = sc.nextLine();

        System.out.println("Enter age:");
        int age = sc.nextInt();

        System.out.println("Enter designation:");
        String designation = sc.next();

        System.out.println("Enter department:");
        String department = sc.next();

        System.out.println("Enter salary:");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, age, designation, department, salary);

        dao.addEmployee(emp);
    }

    public void viewAllEmps() {

        for(Employee emp : dao.getAllEmployees()) {
            System.out.println(emp);
        }

    }

    public void viewEmp(){

        System.out.println("Enter id:");
        int id = sc.nextInt();

        Employee emp = dao.getEmployeeById(id);

        if(emp != null){
            System.out.println(emp);
        }
        else{
            System.out.println("Employee not found");
        }
    }

    public void updateEmployee(){

        System.out.println("Enter id:");
        int id = sc.nextInt();

        System.out.println("Enter new name:");
        String name = sc.next();

        System.out.println("Enter new salary:");
        double salary = sc.nextDouble();

        dao.updateEmployee(id, name, salary);
    }

    public void deleteEmp(){

        System.out.println("Enter id:");
        int id = sc.nextInt();

        dao.deleteEmployee(id);
    }
}