package com.demo.Employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="Employee")

public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  private int Emp_id;
	
	 @Column(name="name",length=30)
  private String Emp_name;
 
	 @Column(name = "Emp_sal")
  private int Emp_sal;
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(int emp_id, String emp_name, int emp_sal) {
	super();
	Emp_id = emp_id;
	Emp_name = emp_name;
	Emp_sal = emp_sal;
}
public int getEmp_id() {
	return Emp_id;
}
public void setEmp_id(int emp_id) {
	Emp_id = emp_id;
}
public String getEmp_name() {
	return Emp_name;
}
public void setEmp_name(String emp_name) {
	Emp_name = emp_name;
}
public int getEmp_sal() {
	return Emp_sal;
}
public void setEmp_sal(int emp_sal) {
	Emp_sal = emp_sal;
}
@Override
public String toString() {
	return "Employee [Emp_id=" + Emp_id + ", Emp_name=" + Emp_name + ", Emp_sal=" + Emp_sal + "]";
}
 
  
  
}
