package FirstClass;

import java.util.Scanner;

public class Reader implements consoleReadInterface
{
	public Integer[] takeInput()
	{
		Scanner in = new Scanner(System.in);
		for (Integer i = 0; i<4 ; i++)
		{
			if(i%2==0)
				System.out.println("Enter number " + (i/2+1));
			inp[i] = in.nextInt();
		}
		return inp;
	}
}