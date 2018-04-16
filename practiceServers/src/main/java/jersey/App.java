package jersey;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
	public static void main( String[] args ) throws FileNotFoundException
    {
    		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    		Reader reader;
//    		ApplicationContext cxt = new ClassPathXmlApplicationContext("spring-config.xml");
		Processor<Vector<Integer>> processor;
    		Integer selector;
    		Writer<Vector<Integer>> writer;
    		Integer[] inputNums;
    		Vector<Integer> outputNums = null;
    		Scanner in = new Scanner(System.in);
    		Boolean dbWriteInput = false, readFullDatbase = false;
    		DatabaseWriterForInput databaseWriter = context.getBean(DatabaseWriterForInput.class);
    		
    		System.out.println("Select the appropriate option - \n1) Console Reader \n2) File Read \n3) Database Read\n4) Console read and DatabaseWrite Input\n5) Read all the inputs from database");
    		selector = in.nextInt();
    		
    		
    		switch (selector) {
			case 1:
				reader = context.getBean(ConsoleReader.class);
				break;
			case 2:
				reader = context.getBean(FileReader.class);
				break;
			case 3:
				reader = context.getBean(DatabaseReader.class);
				break;
			case 4:
				reader = context.getBean(ConsoleReader.class);
				dbWriteInput = true;
				break;
			case 5:
				reader = context.getBean(FullDatabaseReader.class);
				readFullDatbase = true;
				break;
			default:
				System.out.println("Invalid selection");
				reader = context.getBean(ConsoleReader.class);
		}
    		
    		System.out.println("Select the appropriate option - \n1) Addition \n2) Subtraction \n3) Multiplication \n4) Multiplicatoin+Addition \n5)Positive parts of the complex numbers");
    		selector = in.nextInt();
    		
    		switch (selector) {
    			case 1:
    				processor = context.getBean(AdderP.class);
    				break;
    			case 2:
    				processor = context.getBean(Subtractor.class);
    				break;
    			case 3:
    				processor = context.getBean(MultiplierP.class);
    				break;
    			case 4:
    				processor = context.getBean(MulAdder.class);
    				break;
    			case 5:
    				processor = context.getBean(PositiveNumsPlusOne.class);
    				break;
    			default:
    				System.out.println("Invalid selection");
    				processor = context.getBean(AdderP.class);
    		}
    		
    		writer = context.getBean(ConsolePrinter.class);
    		
    		//Writer using lambda expression Intantiating and the implementation together
    		Writer<Vector<Integer>> printerPositiveNums = output -> output.forEach(System.out::println);
    		
    		inputNums = reader.takeInput();
    		
    		if(readFullDatbase && selector!=5) {
    			Integer[] tempInput = new Integer[4];
    			for (Integer i = 0; i<inputNums.length; i=i+4) {
    				tempInput = Arrays.copyOfRange(inputNums, i, i+4);
//    				Arrays.stream(tempInput).forEach(System.out::println);
    				outputNums = (Vector<Integer>) processor.arithmatic(tempInput);
    				writer.print(outputNums);
    			}
    		}
    		else {
    			outputNums = (Vector<Integer>) processor.arithmatic(inputNums);
    		}
    		
    		if(selector==5 && !outputNums.isEmpty()) {
    			printerPositiveNums.print(outputNums);
    		}
//    			writer.print(outputNums);    	
    		
    		if(dbWriteInput) {
    			databaseWriter.insert(inputNums);
    		}
    		
    		in.close();
    		context.close();
    		
    		
    }
}
