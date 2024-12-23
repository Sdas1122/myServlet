package string;
import java.util.Scanner;
public class Wordcount {

	public static void main(String[] args) {
		    Scanner Sc= new Scanner(System.in);
		    System.out.println("Enter a String:");
		    String s =Sc.nextLine().toUpperCase();
		    int wcount= 0;
		    for(int i=0 ; i<=s.length()-1; i++)
		    {
		      char c= s.charAt(i);
		       if(c!=' ')
		       {
			wcount ++;
		       }
		     }
		       System.out.println(wcount);
		   }
		
		 

	}


