package com.demo.Employee;
 
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
	 Scanner sc=new Scanner(System.in);
	public static void main( String[] args )
    {
		App obj = new App();
        System.out.println("Welcome to Company!");
        obj.insertData();
        obj.readData();
        obj.updateData();
        obj.deleteData();
        
    }
    
	
    public  void insertData()
    {
    	
    	Session session=HibernateUtil.getSession();
    	Employee e=new Employee();
    	System.out.println("Enter the name of Employee");
    	e.setEmp_name(sc.next());
    	System.out.println("Enter the Salary of Employee");
    	e.setEmp_sal(sc.nextInt());
    	
    	Transaction tx = ((SharedSessionContract) session).beginTransaction();
        (session).save(e);
        tx.commit();

        session.close();
    }
    public void readData() {
        Session session = HibernateUtil.getSession();
        System.out.println("List of Employees:");
        session.createQuery("from Employee", Employee.class)
               .getResultList()
               .forEach(emp -> System.out.println(emp.getEmp_id() + ": " + emp.getEmp_name() + " - " + emp.getEmp_sal()));
        session.close();
    }

    public void updateData() {
        Session session = HibernateUtil.getSession();
        System.out.println("Enter the employee ID to update:");
        int empId = sc.nextInt();
        Employee e = session.get(Employee.class, empId);
        if (e != null) {
            System.out.println("Enter the new name of Employee");
            e.setEmp_name(sc.next());
            System.out.println("Enter the new Salary of Employee");
            e.setEmp_sal(sc.nextInt());
            Transaction tx = session.beginTransaction();
            session.update(e);
            tx.commit();
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee with ID " + empId + " not found.");
        }
        session.close();
    }

    public void deleteData() {
        Session session = HibernateUtil.getSession();
        System.out.println("Enter the employee ID to delete:");
        int empId = sc.nextInt();
        Employee e = session.get(Employee.class, empId);
        if (e != null) {
            Transaction tx = session.beginTransaction();
            session.delete(e);
            tx.commit();
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee with ID " + empId + " not found.");
        }
        session.close();
    }
}
