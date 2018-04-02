package FirstClass;

import org.junit.*;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Before
	public void before() throws Exception{
		inputNums[0] = 1;
		inputNums[1] = 2;
		inputNums[2] = 1;
		inputNums[3] = 2;
	}
	
	@Test
	public void additionOfTwoNumbersTesting() {
		ProcessInterface add = context.getBean(ProcessorAdd.class);
		outputNums = add.arithmatic(inputNums);
		assertEquals(outputNums[0].intValue(),2);
		assertEquals(outputNums[1].intValue(),4);
	}
	
	@Test (expected=InputMismatchException.class)
	public void invalidInputTest() {
		ByteArrayInputStream in = new ByteArrayInputStream("My string".getBytes());
		System.setIn(in);
		ReadInterface r = context.getBean(ConsoleReader.class);
		try {
			r.takeInput();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void subtractionOfTwoNumbersTesting() {
		ProcessInterface sub = context.getBean(ProcessorSubtract.class);
		outputNums = sub.arithmatic(inputNums);
		assertEquals(outputNums[0].intValue(),0);
		assertEquals(outputNums[1].intValue(),0);
	}
	
	@Test
	public void multiplicationOfTwoNumbersTesting() {
		ProcessInterface mul = context.getBean(ProcessorMultiply.class);
		outputNums = mul.arithmatic(inputNums);
		assertEquals(outputNums[0].intValue(),-3);
		assertEquals(outputNums[1].intValue(),4);
	}
	
	@Test
	public void mulAddOfTwoNumbersTesting() {
		ProcessInterface mulAdd = context.getBean(ProcessorMulAdd.class);
		outputNums = mulAdd.arithmatic(inputNums);
		assertEquals(outputNums[0].intValue(),-2);
		assertEquals(outputNums[1].intValue(),6);
	}
	
}
