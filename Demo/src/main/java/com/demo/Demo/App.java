package com.demo.Demo;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
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
    	App obj=new App();
        System.out.println( "Hello World!" );
        //obj.insertData();
        //obj.getStudentById();
        obj.getAllRecords();
        
        
    }
    
    public  void insertData()
    {
    	
    	Session session=HibernateUtil.getSession();
    	Student s=new Student();
    	System.out.println("Enter Student Name");
    	s.setStud_name(sc.next());
    	System.out.println("Enter Student Email");
    	s.setStud_email(sc.next());
    	
    	Transaction tx=session.beginTransaction();
    	session.save(s);
    	System.out.println(s);
    	tx.commit();
    	session.close();
    	
    }
    public void getStudentById()
    {
    	Session session=HibernateUtil.getSession();
    	Transaction tx=session.beginTransaction();
    	
    	System.out.println("Enter student ID");
    	int id=sc.nextInt();
    	Student s1=session.get(Student.class, id);
    	
    	System.out.println("Name:"+s1.getStud_name());
    	System.out.println("Gmail"+s1.getStud_email());
    	tx.commit();
    	session.close();
    }
    public void getAllRecords()
    {
    	Session session=HibernateUtil.getSession();
    	Transaction tx=session.beginTransaction();
    	Query qur=session.createQuery("from Student");
    	
    	List<Student> list_students=qur.getResultList();
    	for(Student s:list_students)
    	{
    		System.out.println("Student ID"+s.getStud_id());
    		System.out.println("Student ID"+s.getStud_name());
    		System.out.println("Student ID"+s.getStud_email());
    	}
    	tx.commit();
    	session.close();
    }
}

