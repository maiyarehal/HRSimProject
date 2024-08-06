package edu.waketech.csc251.hr.person;

import edu.waketech.csc251.collection.*;

public class Employee implements Measurable {
	
	private String name;
	private double salary;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}

   @Override
   public int getMeasure() {
      return (int) (getSalary() * 100);
   }
}
