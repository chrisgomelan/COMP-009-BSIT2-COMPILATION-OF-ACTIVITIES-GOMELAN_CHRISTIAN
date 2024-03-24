package Assignments;
import java.util.Scanner;

public class Fibonacci {
	
	public static void words(int num){
		int a = 0; //starting 0
		int b = 1; // starting 1
		int temp = 0; //temporary variable
		int c = 1;
		
		System.out.print("Zero" + ", " + "One" + ", ");
		while (c <= num) {
			temp = a + b;
				if(temp >= 0) {
					  NumberWords.NumberWords(Integer.toString(temp));
					System.out.print(", ");
			c++;
			} else if (c == num) {
				 NumberWords.NumberWords(Integer.toString(c));
				 System.out.print("");
				
			}
		
			
			a = b;
			b = temp;
			
		}
	}
	
	public static void numbers(int num){
		int a = 0; //starting 0
		int b = 1; // starting 1
		int temp = 0; //temporary variable
		int c = 1;
		
		System.out.print(a + ", " + b +  ", ");
		
		while (c <= num) {
			temp = a + b;
				if(temp >= 0) {
					  System.out.print(temp);
					System.out.print(", ");
			c++;
			} else if (c == num) {
				  System.out.print(c);
				 System.out.print("");
				
			}
		
			
			a = b;
			b = temp;
			
		}
	}
	
	public static void main(String[] args) {
		NumberWords convert = new NumberWords();
		Scanner sc = new Scanner(System.in);
		Scanner num = new Scanner(System.in);
		
		int nums;
		System.out.print("How do you want the elements to be displayed?: \n A - Numbers \n B - Words \nEnter your choice: ");
		char choice = sc.next().charAt(0);
		
		if (choice == 'a' || choice == 'A') {
			System.out.print("How many elements you want to display?: ");
			nums = num.nextInt();
			
			numbers(nums);
		}
		else if (choice == 'b' || choice == 'B') {
			System.out.print("How many elements you want to display?: ");
			nums = num.nextInt();
			
			words(nums);
			
		} 
			
		

}
		
	}
