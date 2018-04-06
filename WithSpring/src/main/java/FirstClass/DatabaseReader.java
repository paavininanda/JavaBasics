package FirstClass;

import java.io.FileNotFoundException;

import javax.inject.Inject;
import org.springframework.stereotype.Component;

@Component
public class DatabaseReader implements Reader{
	
	private Mapper mapper;
	
	@Override
	public Integer[] takeInput() throws FileNotFoundException {
		ComplexNumber c = mapper.getNums(1);
		Integer [] input = new Integer[4];
		input[0] = c.getReal1();
		input[1] = c.getImg1();
		input[2] = c.getReal2();
		input[3] = c.getImg2();
		return input;
	}
	
	@Inject
	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}

}
