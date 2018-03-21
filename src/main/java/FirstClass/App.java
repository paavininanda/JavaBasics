package FirstClass;

import java.util.Scanner;

class Reader
{
	private int[] inp = new int[4];
	public int[] takeInput()
	{
		Scanner in = new Scanner(System.in);
		for (int i = 0; i<4 ; i++)
		{
			if(i%2==0)
				System.out.println("Enter number " + i);
			inp[i] = in.nextInt();
		}
		return inp;
	}
}


class Processor
{
	private int[] output = new int[2];
	public int[] add (int[] input) 
	{
		for (int i=0;i<2;i++) 
		{
			output [i] = input[i] + input[i+2];
		}
		return output;
	}
}

class Printer
{
	public static void printSum (int[] output)
	{
		System.out.println(output[0] + output[1]+"i");
	}
}


public class App 
{
    public static void main( String[] args )
    {
    		Reader r = new Reader();
    		Processor p = new Processor();
    		Printer pr;
    		int[] inputNums = r.takeInput();
    		int[] outputNums = p.add(inputNums);
    		Printer.printSum(outputNums);
    }
}
