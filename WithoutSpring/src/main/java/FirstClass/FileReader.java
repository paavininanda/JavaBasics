package FirstClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fileReader implements ReadInterface {
	public Integer[] takeInput() throws FileNotFoundException
	{
		Scanner in = new Scanner(new File("/Users/paavini/Desktop/Maven/WithoutSpring/src/main/java/FirstClass/ints.txt"));
		Integer i = 0;
		while (in.hasNext()){
			inp[i] = in.nextInt();
			i++;
		}
		return inp;
	}
}
