package com.jspider.jdbc.Hibernate.employee.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private int EmployeeId;
	private String EmployeeName;
	private String EmployeeEmail;
	private int EmployeeAge;
	private double EmployeeSalary;
	private String EmployeeDesc;
	
	
	
	@Override
	public String toString() {
		return "Employee [EmployeeId=" + EmployeeId + ", EmployeeName=" + EmployeeName + ", EmployeeEmail="
				+ EmployeeEmail + ", EmployeeAge=" + EmployeeAge + ", EmployeeSalary=" + EmployeeSalary
				+ ", EmployeeDesc=" + EmployeeDesc + "]";
	}



	public int getEmployeeId() {
		return EmployeeId;
	}



	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}



	public String getEmployeeName() {
		return EmployeeName;
	}



	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}



	public String getEmployeeEmail() {
		return EmployeeEmail;
	}



	public void setEmployeeEmail(String employeeEmail) {
		EmployeeEmail = employeeEmail;
	}



	public int getEmployeeAge() {
		return EmployeeAge;
	}



	public void setEmployeeAge(int employeeAge) {
		EmployeeAge = employeeAge;
	}



	public double getEmployeeSalary() {
		return EmployeeSalary;
	}



	public void setEmployeeSalary(double employeeSalary) {
		EmployeeSalary = employeeSalary;
	}



	public String getEmployeeDesc() {
		return EmployeeDesc;
	}



	public void setEmployeeDesc(String employeeDesc) {
		EmployeeDesc = employeeDesc;
	}

	


}
