package FirstClass;

import java.io.FileNotFoundException;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
    	
//    	Declarations
    		fileReader file = new fileReader();
    		consoleReader con = new consoleReader();
    		processorAdd add = new processorAdd();
    		processorSubtract sub = new processorSubtract();
    		Printer pr = new Printer();
    		processorMultiply mul = new processorMultiply();
    		processorMulAdd mulAdd = new processorMulAdd(); 
    		
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
    }
}
