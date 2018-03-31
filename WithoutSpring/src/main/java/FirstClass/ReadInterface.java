package FirstClass;

import java.io.FileNotFoundException;

public interface ReadInterface 
{
	Integer[] inp = new Integer[4];
	public Integer[] takeInput() throws FileNotFoundException;
}