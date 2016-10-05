package stringcalc;

import edu.princeton.cs.algs4.Out;

public class StringCalculator {

	public static void main(String[] args) {
		test();
	}
	
	public static int add(String numbers){
		if(numbers.isEmpty()){
			return 0;
		}
		else if(numbers.indexOf(",") != -1){ //if a comma is in the string
			String[] num = numbers.split(",");
			int sum = 0;
			for(String number : num){
				sum += Integer.parseInt(number);
			}
			return sum;
			
		}
		else{ //if no comma is in the string and not empty, so just one number
			int num = Integer.parseInt(numbers);
			return num;
		}
	}
	
	public static void test(){
		Out out = new Out();
		String testInputEmpty = "";
		int sum = add(testInputEmpty);
		out.println(sum); // outcome should be 0
		
		String testInputOne = "1";
		sum = add(testInputOne);
		out.println(sum); // outcome should be 1
		
		String testInputTwo = "1,2";
		sum = add(testInputTwo);
		out.println(sum); // outcome should be 3
		
		String testInputLarge = "1,2,3,4,5,6,7";
		sum = add(testInputLarge);
		out.println(sum); // outcome should be 28
	}

}
