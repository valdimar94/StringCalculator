package stringcalc;

import java.util.ArrayList;

import edu.princeton.cs.algs4.Out;

public class StringCalculator {
	
	private String splitter;
	static StringCalculator s = new StringCalculator();

	public static void main(String[] args) throws Exception {
		s.test();
	}
	
	public int add(String numbers) throws Exception{
		Out out = new Out();
		ArrayList<Integer> negativeNums = new ArrayList<Integer>();
		int sum = 0;
		if(numbers.isEmpty()){
			return 0;
		}
		else{
			String[] nums;
			if(numbers.startsWith("//")){
				setSplitter(numbers.substring(2, numbers.indexOf("\n")));
				nums = numbers.substring(numbers.indexOf("\n") + 1, numbers.length()).split(getSplitter());
			}
			else{
				setSplitter(",|\n");
				nums = numbers.split(getSplitter());
			}
			for(String n : nums){
				int number = Integer.parseInt(n);
				if(number < 0){
					negativeNums.add(number);
				}
				if(number <= 1000){
					sum += number;
				}
			}
		}
		
		if(!negativeNums.isEmpty()){
			throw new Exception("Negatives not allowed: " + negativeNums.toString());
		}
		return sum;
	}
	
	public void test() throws Exception{
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
		
		String testInputToLarge = "1,2,3,5000,4";
		sum = add(testInputToLarge);
		out.println(sum); // outcome should be 10 as 5000 is ignored
		
		String testInputNewSplitter1 = "//;\n1;2;3;4";
		sum = add(testInputNewSplitter1);
		out.println(sum); // outcome should be 10, using ; as a delimiter
		
		String testInputNewSplitter2 = "//Harambe\n1Harambe2Harambe3Harambe4";
		sum = add(testInputNewSplitter2);
		out.println(sum); // outcome should be 10, using harambe in this case as a delimiter but any string can be used instead
		
		//Exception test always kept at bottom!
		String testInputNegative = "1,2,-3,4,-5,6,-7";
		sum = add(testInputNegative);
		out.println(sum); // this should throw exception: "Negatives not allowed: -3,-5,-7" 
	}

	public String getSplitter() {
		return splitter;
	}

	public void setSplitter(String splitter) {
		this.splitter = splitter;
	}

}
