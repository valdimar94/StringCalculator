package stringcalc;

import java.awt.List;
import java.util.ArrayList;

import edu.princeton.cs.algs4.Out;

public class StringCalculator {
	
	private static String splitter = ",|\n";

	public static void main(String[] args) throws Exception {
		test();
	}
	
	public static int add(String numbers) throws Exception{
		ArrayList<Integer> negativeNums = new ArrayList<Integer>();
		int sum = 0;
		if(numbers.isEmpty()){
			return 0;
		}
		else{
			String[] nums = numbers.split(splitter);
			for(String n : nums){
				int number = Integer.parseInt(n);
				if(number < 0){
					negativeNums.add(number);
				}
				sum += number;
			}
		}
		
		if(!negativeNums.isEmpty()){
			throw new Exception("Negatives not allowed: " + negativeNums.toString());
		}
		return sum;
	}
	
	public static void test() throws Exception{
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
		
		String testInputNewLine = "1,2,3,4\n5,6,7";
		sum = add(testInputNewLine);
		out.println(sum); // outcome should be 28, with newline instead of a comma
		
		String testInputNegative = "1,2,-3,4,-5,6,-7";
		sum = add(testInputNegative);
		out.println(sum); // this should throw exception: "Negatives not allowed: -3,-5,-7" 
	}

}
