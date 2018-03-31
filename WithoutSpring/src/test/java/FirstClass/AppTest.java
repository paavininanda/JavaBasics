package FirstClass;

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{	
	
	private Integer[] inputNums = new Integer[4];
	private Integer[] outputNums;
	
	@Before
	public void before() throws Exception{
		inputNums[0] = 1;
		inputNums[1] = 2;
		inputNums[2] = 1;
		inputNums[3] = 2;
	}
	
	@Test
	public void additionOfTwoNumbersTesting() {
		
		processorAdd add = new processorAdd();
		outputNums = add.arithmatic(inputNums);
		assertEquals(outputNums[0].intValue(),2);
		assertEquals(outputNums[1].intValue(),4);
	}
	
	@Test (expected=InputMismatchException.class)
	public void invalidInputTest() {
		ByteArrayInputStream in = new ByteArrayInputStream("My string".getBytes());
		System.setIn(in);
		consoleReader r = new consoleReader();
		r.takeInput();
	}
	
	@Test
	public void subtractionOfTwoNumbersTesting() {
		processorSubtract sub = new processorSubtract();
		outputNums = sub.arithmatic(inputNums);
		assertEquals(outputNums[0].intValue(),0);
		assertEquals(outputNums[1].intValue(),0);
	}
	
	@Test
	public void multiplicationOfTwoNumbersTesting() {
		processorMultiply mul = new processorMultiply();
		outputNums = mul.arithmatic(inputNums);
		assertEquals(outputNums[0].intValue(),-3);
		assertEquals(outputNums[1].intValue(),4);
	}
	
	@Test
	public void mulAddOfTwoNumbersTesting() {
		processorMulAdd mulAdd = new processorMulAdd();
		outputNums = mulAdd.arithmatic(inputNums);
		assertEquals(outputNums[0].intValue(),-2);
		assertEquals(outputNums[1].intValue(),6);
	}
	
}
