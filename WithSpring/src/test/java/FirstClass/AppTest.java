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
	private Vector<Integer> outputNums;
	private Processor<Vector<Integer>> processor;
	
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
		processor = context.getBean(AdderP.class);
		outputNums = processor.arithmatic(inputNums);
		assertEquals(outputNums.get(0).intValue(),2);
		assertEquals(outputNums.get(1).intValue(),4);
	}
	
	@Test (expected=InputMismatchException.class)
	public void invalidInputTest() {
		ByteArrayInputStream in = new ByteArrayInputStream("My string".getBytes());
		System.setIn(in);
		Reader r = context.getBean(ConsoleReader.class);
		try {
			r.takeInput();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void subtractionOfTwoNumbersTesting() {
		processor = context.getBean(Subtractor.class);
		outputNums = processor.arithmatic(inputNums);
		assertEquals(outputNums.get(0).intValue(),0);
		assertEquals(outputNums.get(1).intValue(),0);
	}
	
	@Test
	public void multiplicationOfTwoNumbersTesting() {
		processor = context.getBean(MultiplierP.class);
		outputNums = processor.arithmatic(inputNums);
		assertEquals(outputNums.get(0).intValue(),-3);
		assertEquals(outputNums.get(1).intValue(),4);
	}
	
	@Test
	public void mulAddOfTwoNumbersTesting() {
		processor = context.getBean(MulAdder.class);
		outputNums = processor.arithmatic(inputNums);
		assertEquals(outputNums.get(0).intValue(),-2);
		assertEquals(outputNums.get(1).intValue(),6);
	}
	
	@Test
	public void positiveNumsPlusOneTesting() {
		processor = context.getBean(PositiveNumsPlusOne.class);
		outputNums = processor.arithmatic(inputNums);
		assertEquals(outputNums.get(0).intValue(),2);
		assertEquals(outputNums.get(1).intValue(),3);
		assertEquals(outputNums.get(2).intValue(),2);
		assertEquals(outputNums.get(3).intValue(),3);
	}
	
}
