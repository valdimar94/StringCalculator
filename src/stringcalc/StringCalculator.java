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
		int sum = 0;
		for(int i = 0; i < numbers.length(); i++){
			char currentChar = numbers.charAt(i);
			if(currentChar == ',' || currentChar == '\n'){
				continue;
			}
			else{
				String n = Character.toString(currentChar);
				sum += Integer.parseInt(n);
			}
		}
		return sum;
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
		
		String testInputNewLine = "1,2,3,4\n5,6,7";
		sum = add(testInputNewLine);
		out.println(sum); // outcome should be 28, with newline instead of a comma
	}

}
