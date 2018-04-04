package FirstClass;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
	public static void main( String[] args ) throws FileNotFoundException
    {
    		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    		Reader reader = context.getBean(ConsoleReader.class);
		Processor<Vector<Integer>> processor = context.getBean(AdderP.class);
    		Integer selector;
    		Writer<Vector<Integer>> writer;
    		Integer[] inputNums;
    		Vector<Integer> outputNums;
    		Scanner in = new Scanner(System.in);
    		
    		System.out.println("Select the appropriate option - \n1) Console Reader \n2) File Read \n ");
    		selector = in.nextInt();
    		
    		switch (selector) {
			case 1:
				reader = context.getBean(ConsoleReader.class);
				break;
			case 2:
				reader = context.getBean(FileReader.class);
				break;
			default:
				System.out.println("Invalid selection");
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
    				processor = context.getBean(PositiveNums.class);
    				break;
    			default:
    				System.out.println("Invalid selection");
    		}
    		
    		writer = context.getBean(ConsolePrinter.class);
    		
    		//Writer using lambda expression Intantiating and the implementation together
    		Writer<Vector<Integer>> printerPositiveNums = (Vector<Integer> output) -> output.forEach(System.out::println);
    		
    		inputNums = reader.takeInput();
    		outputNums = (Vector<Integer>) processor.arithmatic(inputNums);
    		if(selector!=5)
    			writer.print(outputNums);
    		else {
    			printerPositiveNums.print(outputNums);
    		}
    			
    		context.close();
    		
    }
}
