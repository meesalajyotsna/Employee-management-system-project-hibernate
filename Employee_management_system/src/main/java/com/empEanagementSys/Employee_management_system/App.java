package com.empEanagementSys.Employee_management_system;

/**
 * Hello world!
 */

import com.empEanagementSys.Employee_management_system.EmployeeDAO;
import com.empEanagementSys.Employee_management_system.Employee;

import java.util.List;
public class App {
    public static void main(String[] args) {
    	 EmployeeDAO employeeDAO = new EmployeeDAO();

         // Add employees
         Employee emp1 = new Employee();
         emp1.setName("John Doe");
         emp1.setDepartment("IT");
         emp1.setSalary(50000);

         Employee emp2 = new Employee();
         emp2.setName("Jane Smith");
         emp2.setDepartment("HR");
         emp2.setSalary(60000);

         employeeDAO.saveEmployee(emp1);
         employeeDAO.saveEmployee(emp2);

         // Fetch and display employees
         List<Employee> employees = employeeDAO.getEmployees();
         employees.forEach(emp -> {
             System.out.println("ID: " + emp.getId());
             System.out.println("Name: " + emp.getName());
             System.out.println("Department: " + emp.getDepartment());
             System.out.println("Salary: " + emp.getSalary());
             System.out.println("-------------------");
         });
    }
}
