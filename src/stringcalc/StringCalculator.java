package stringcalc;

import java.util.ArrayList;

public class StringCalculator {
	
	private String splitter;
	static StringCalculator s = new StringCalculator();
	
	public int add(String numbers) throws Exception{
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
	
	public String getSplitter() {
		return splitter;
	}

	public void setSplitter(String splitter) {
		this.splitter = splitter;
	}

}
