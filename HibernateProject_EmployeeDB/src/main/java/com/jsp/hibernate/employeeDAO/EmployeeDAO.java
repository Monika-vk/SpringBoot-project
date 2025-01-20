package com.jsp.hibernate.employeeDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jspider.jdbc.Hibernate.employee.entity.Employee;


public class EmployeeDAO {
	


		public static Session getSession() {
			Configuration cfg=new Configuration();
			cfg.configure();
			cfg.addAnnotatedClass(Employee.class);

			SessionFactory sf=cfg.buildSessionFactory();
			Session session =sf.openSession();
			return session;

		}

		public void addEmployee(){
			Session session=getSession();
			Employee e=new Employee();
			e.setEmployeeId(101);
			e.setEmployeeName("Monika");
			e.setEmployeeEmail("m@123");
			e.setEmployeeAge(22);
			e.setEmployeeSalary(20000);
			e.setEmployeeDesc("Trainer");
			
			
			session.save(e);
			Transaction tran=session.beginTransaction();
			tran.commit();
			session.close();

		}
		public void findEmployeeById() {
			Session session=getSession();
			Transaction tran=session.beginTransaction();

			Employee e=session.get(Employee.class,101);
			System.out.println(e);

			tran.commit();
			session.close();

		}

		public void UpdateEmployeeDescAndSalaryById() {
			Session session=getSession();
			Transaction tran=session.beginTransaction();

			Employee e=session.get(Employee.class,101);
			e.setEmployeeDesc("javaDeveloper");
			e.setEmployeeAge(500000);

			session.update(e);

			tran.commit();
			session.close();
		}

		public void DeleteEmployeeById() {
			Session session=getSession();
			Transaction tran=session.beginTransaction();

			Employee e=session.get(Employee.class,101);
			session.delete(e);

			tran.commit();
			session.close();
		}
	}

