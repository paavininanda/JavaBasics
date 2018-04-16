package jersey;

import java.io.FileNotFoundException;

public interface Reader 
{
	Integer[] inp = new Integer[4];
	public Integer[] takeInput() throws FileNotFoundException;
}