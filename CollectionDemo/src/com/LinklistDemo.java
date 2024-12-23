package com;

import java.util.Iterator;
import java.util.LinkedList;

public class LinklistDemo {

	public static void main(String[] args) {
		
		Employee e1 =new Employee("1001","Sourav","Dumdum");
		LinkedList<Employee> eList=new LinkedList<>();
		eList.add(e1);
		
		Iterator eIterator=eList.iterator();
		
		while (eIterator.hasNext()) {
			Employee e=(Employee)eIterator.next();
			System.out.println("Employee Id:"+e.getEmpid()+" Employee Name:"+e.getEmpname()+" Address:"+e.getAddress());
		}
	}

}
