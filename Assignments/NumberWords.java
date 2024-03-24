package Assignments;

public class NumberWords {

	public static void NumberWords(String word) {
		String Ones[] = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
		
		String Teens[] = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
		
		String Hundredths[] = {"Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	
		String labels[] = {"Hundred", "Thousand", "Million"};
		
		int number = Integer.parseInt(word);
		
		
		if (number == 0) {
			System.out.print("Zero");
		} else if(number < 10) {
			System.out.print(Ones[number - 1]);
		} else if (number >= 10 && number < 20) {
			System.out.print(Teens[number - 10]);
		} else if (number >= 20 && number <= 99) {
			 if (number % 10 == 0) {
				System.out.print(Hundredths[number / 10 - 2]);
			} else	{
				System.out.print(Hundredths[number / 10 - 2] + " " + Ones[number % 10 - 1]);
				 	}
	    } else if (number >= 100 && number <= 999) {
            System.out.print(Ones[number / 100 - 1] + " " + labels[0]);
            if (number % 100 != 0) {
                System.out.print(" and ");
                NumberWords(Integer.toString(number % 100));
            }
        } else if (number >= 1000 && number <= 999999) {
            int thousands = number / 1000;
            int remainder = number % 1000;
            NumberWords(Integer.toString(thousands));
            System.out.print(" " + labels[1]);
            if (remainder != 0) {
                System.out.print(" ");
                if (remainder < 100) {
                    System.out.print("and ");
                }
                NumberWords(Integer.toString(remainder));
            }
        }
		else if (number >= 1000000 && number <= 999999999) {
            int millions = number / 1000000;
            int remainder = number % 1000000;
            NumberWords(Integer.toString(millions));
            System.out.print(" " + labels[2]);
            if (remainder != 0) {
                System.out.print(" ");
                if (remainder < 1000) {
                    System.out.print("and ");
                }
                NumberWords(Integer.toString(remainder));
            }
       }
	
	}
	
	public static void convertToWords(String[] args) {
		 if (args.length != 1) {
	            System.out.println("Input some numbers to convert.");
	            return;
	        }
	        NumberWords(args[0]);
	    }

}
