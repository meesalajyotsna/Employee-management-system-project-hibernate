package com.empEanagementSys.Employee_management_system;

/**
 * Hello world!
 */

import com.empEanagementSys.Employee_management_system.EmployeeDAO;
import com.empEanagementSys.Employee_management_system.Employee;

import java.util.List;

import java.util.Scanner;
public class App {
	 private static final EmployeeDAO employeeDAO = new EmployeeDAO();

         // Add employees
    	 public static void main(String[] args) {
    	        Scanner scanner = new Scanner(System.in);
    	        boolean running = true;

    	        while (running) {
    	            System.out.println("\n--- Employee Management System ---");
    	            System.out.println("1. Add Employee");
    	            System.out.println("2. Update Employee");
    	            System.out.println("3. Delete Employee");
    	            System.out.println("4. View Employee");
    	            System.out.println("5. View All Employees");
    	            System.out.println("6. Exit");
    	            System.out.print("Choose an operation: ");
    	            int choice = scanner.nextInt();

    	            switch (choice) {
    	                case 1 -> addEmployee(scanner);
    	                case 2 -> updateEmployee(scanner);
    	                case 3 -> deleteEmployee(scanner);
    	                case 4 -> viewEmployee(scanner);
    	                case 5 -> viewAllEmployees();
    	                case 6 -> {
    	                    running = false;
    	                    System.out.println("Exiting system. Goodbye!");
    	                }
    	                default -> System.out.println("Invalid choice. Please try again.");
    	            }
    	        }
    	        scanner.close();
    	    }

    	    private static void addEmployee(Scanner scanner) {
    	        scanner.nextLine(); // Consume newline
    	        System.out.print("Enter Employee Name: ");
    	        String name = scanner.nextLine();
    	        System.out.print("Enter Department: ");
    	        String department = scanner.nextLine();
    	        System.out.print("Enter Salary: ");
    	        double salary = scanner.nextDouble();

    	        Employee employee = new Employee(name, department, salary);
    	        employeeDAO.addEmployee(employee);
    	        System.out.println("Employee added successfully!");
    	    }

    	    private static void updateEmployee(Scanner scanner) {
    	        System.out.print("Enter Employee ID to update: ");
    	        int id = scanner.nextInt();
    	        scanner.nextLine(); // Consume newline

    	        Employee employee = employeeDAO.getEmployee(id);
    	        if (employee != null) {
    	            System.out.print("Enter new Name (current: " + employee.getName() + "): ");
    	            String name = scanner.nextLine();
    	            System.out.print("Enter new Department (current: " + employee.getDepartment() + "): ");
    	            String department = scanner.nextLine();
    	            System.out.print("Enter new Salary (current: " + employee.getSalary() + "): ");
    	            double salary = scanner.nextDouble();

    	            employee.setName(name);
    	            employee.setDepartment(department);
    	            employee.setSalary(salary);
    	            employeeDAO.updateEmployee(employee);
    	            System.out.println("Employee updated successfully!");
    	        } else {
    	            System.out.println("Employee ID not found.");
    	        }
    	    }

    	    private static void deleteEmployee(Scanner scanner) {
    	        System.out.print("Enter Employee ID to delete: ");
    	        int id = scanner.nextInt();
    	        employeeDAO.deleteEmployee(id);
    	        System.out.println("Employee deleted successfully!");
    	    }

    	    private static void viewEmployee(Scanner scanner) {
    	        System.out.print("Enter Employee ID to view: ");
    	        int id = scanner.nextInt();
    	        Employee employee = employeeDAO.getEmployee(id);
    	        if (employee != null) {
    	            System.out.println(employee);
    	        } else {
    	            System.out.println("Employee ID not found.");
    	        }
    	    }

    	    private static void viewAllEmployees() {
    	        System.out.println("\n--- All Employees ---");
    	        for (Employee employee : employeeDAO.getAllEmployees()) {
    	            System.out.println(employee);
    	        }
    	    }
}
