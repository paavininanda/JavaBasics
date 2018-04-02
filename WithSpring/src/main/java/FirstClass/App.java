package FirstClass;

import java.io.FileNotFoundException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
    	
//    	Declarations
   		
    		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    		ProcessInterface add = context.getBean(ProcessorAdd.class);
    		ProcessInterface sub = context.getBean(ProcessorSubtract.class);
    		ProcessInterface mul = context.getBean(ProcessorMultiply.class);
    		ProcessInterface mulAdd = context.getBean(ProcessorMulAdd.class);
    		ReadInterface file = context.getBean(FileReader.class);
    		ReadInterface con = context.getBean(ConsoleReader.class);
    		PrintInterface pr = context.getBean(Printer.class);
    	
    		Integer[] inputNums;
    		Integer[] outputNums;
    		for(Integer i = 0; i< 2 ; i++) {
    			if(i==0) {
//    		    	 For file inputs	
    				 inputNums = file.takeInput();
    			}
    			else {
//    		    	For console inputs
    				inputNums =  con.takeInput();
    			}
    			
    			outputNums = add.arithmatic(inputNums);
    			System.out.println("Sum is : ");
        		pr.printSum(outputNums);
        		
        		outputNums = sub.arithmatic(inputNums);
        		System.out.println("Difference is : ");
        		pr.printSum(outputNums);
        		
        		outputNums = mul.arithmatic(inputNums);
        		System.out.println("Multiplication is : ");
        		pr.printSum(outputNums);
        		
        		outputNums = mulAdd.arithmatic(inputNums);
        		System.out.println("Multiplication and adding is : ");
        		pr.printSum(outputNums);
    		}
    		
    		context.close();
    }
}
