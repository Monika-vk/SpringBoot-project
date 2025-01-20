package com.jspider.jdbc.Hibernate.employee.entity;

import java.util.Scanner;

import com.jsp.hibernate.employeeDAO.EmployeeDAO;


public class App 
{
    public static void main( String[] args )
    {
    
    	EmployeeDAO dao = new EmployeeDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Add Employee");
            System.out.println("2. Find Employee By ID");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    dao.addEmployee();
                    break;
                case 2:
                    dao.findEmployeeById();
                    break;
                case 3:
                    dao.UpdateEmployeeDescAndSalaryById();
                    break;
                case 4:
                    dao.DeleteEmployeeById();
                    break;
                case 5:
                    System.out.println("Exiting application...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    
}
