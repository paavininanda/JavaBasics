package jersey;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component

public class FileReader implements Reader {
	
	@Override
	public Integer[] takeInput() throws FileNotFoundException
	{
		Scanner in = new Scanner(new File("/Users/paavini/Desktop/Maven/WithSpring/src/main/java/FirstClass/ints.txt"));
		Integer i = 0;
		while (in.hasNext()){
			inp[i] = in.nextInt();
			i++;
		}
		in.close();
		return inp;
	}
}
