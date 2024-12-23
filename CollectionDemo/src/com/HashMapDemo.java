package com;

import java.util.HashMap;

public class HashMapDemo {

	public static void main(String[] args) {
		String word="mathematics";
		HashMap<String,Integer> countMap=new HashMap<String,Integer>();
		for(int i=0;i<word.length();i++)
		{
			String convertedString=String.valueOf(word.charAt(i));
			if(countMap.containsKey(convertedString))
			{
			 Integer count=(Integer)countMap.get(convertedString);
			 countMap.put(convertedString,count+1);
			}
			else
			countMap.put(convertedString,1);
			
		}
		
		System.out.println(countMap);

	}

}
