package stringcalc;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnitTests {

	StringCalculator sc = new StringCalculator();
	@Test
	public void testSingleNumber() throws Exception{
		assertEquals(1, sc.add("1"));
	}
	@Test
	public void testTwoNumbers() throws Exception{
		assertEquals(3, sc.add("1,2"));
	}
	@Test
	public void testEmptyString() throws Exception{
		assertEquals(0, sc.add(""));
	}
	@Test
	public void testMultipleNumbers() throws Exception{
		assertEquals(28, sc.add("1,2,3,4,5,6,7"));
	}
	@Test
	public void testNewLine() throws Exception{
		assertEquals(28, sc.add("1,2,3,4\n5,6,7"));
	}
	@Test
	public void testTooLarge() throws Exception{
		assertEquals(10, sc.add("1,2,3,5000,4"));
	}
	@Test
	public void testNewDelimiter() throws Exception{
		assertEquals(10, sc.add("//;\n1;2;3;4"));
	}
	@Test
	public void testLongDelimiter() throws Exception{
		assertEquals(10, sc.add("//Harambe\n1Harambe2Harambe3Harambe4"));
	}
	@Test(expected=Exception.class)
	public void testNegativeNumbers() throws Exception{
		sc.add("1,2,-3,4,-5,6,-7");
	}

}
