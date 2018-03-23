package FirstClass;

public class App 
{
    public static void main( String[] args )
    {
    		Reader r = new Reader();
    		Processor p = new Processor();
    		Printer pr = new Printer();
    		Integer[] inputNums = r.takeInput();
    		Integer[] outputNums = p.add(inputNums);
    		pr.printSum(outputNums);
    }
}
