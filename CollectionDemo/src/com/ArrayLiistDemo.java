package com;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayLiistDemo {

	public static void main(String[] args) {
		
		Student s1=new Student("S001","Sourav","Dumdum");
		Student s2=new Student("S002","Arnav","Newtown");
		
		ArrayList<Student> sList=new ArrayList<>();
		sList.add(s1);
		sList.add(s2);
		
		Iterator sIterator=sList.iterator();
		
		while(sIterator.hasNext())
		{
			Student s=(Student)sIterator.next();
			System.out.println("Student Id:"+s.getSid()+" Student Name:"+s.getSname()+" Address:"+s.getAddress());
			
		}
		

	}

}
