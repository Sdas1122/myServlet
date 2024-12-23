package com;

import java.util.Iterator;
import java.util.TreeMap;

public class TreeMapExample {

	public static void main(String[] args) {
		Employee e1 =new Employee("1001","Sourav","Dumdum");
		Employee e2 =new Employee("1002","Raja","Sinthi");
		Employee e3 =new Employee("1003","Arnav","Newtown");
		TreeMap<String,Employee> empMap=new TreeMap<String,Employee>();
		empMap.put("1002",e2);
		empMap.put("1001",e1);
		empMap.put("1003",e3);
		System.out.println(empMap);
		
		Iterator<String> itr=empMap.keySet().iterator();
		while(itr.hasNext())
		{
			String key=itr.next();
			Employee emp=(Employee)empMap.get(key);
			System.out.println(emp);
		}
		
		
		
		

	}

}
