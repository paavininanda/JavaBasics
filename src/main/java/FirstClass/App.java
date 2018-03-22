package FirstClass;

public class App 
{
    public static void main( String[] args )
    {
    		Reader r = new Reader();
    		Processor p = new Processor();
    		Printer pr;
    		Integer[] inputNums = r.takeInput();
    		Integer[] outputNums = p.add(inputNums);
    		Printer.printSum(outputNums);
    }
}
