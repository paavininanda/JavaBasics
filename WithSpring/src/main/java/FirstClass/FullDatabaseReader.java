package FirstClass;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class FullDatabaseReader implements Reader{

	ComplexNumberMapper complexNumberMapper;
	
	@Override
	public Integer[] takeInput() throws FileNotFoundException {
		ComplexNumber[] c = complexNumberMapper.getAllInputs();
		ArrayList<Integer> inputList = new ArrayList<Integer>();
		Stream<ComplexNumber> cStream= Arrays.stream(c);
		cStream.forEach( cNo -> {
			inputList.add(cNo.getReal1());
			inputList.add(cNo.getImg1());
			inputList.add(cNo.getReal2());
			inputList.add(cNo.getImg2());
		});
		Integer[] input = new Integer[inputList.size()];
		input = inputList.toArray(input);
		return input;
	}
	
	@Inject
	public FullDatabaseReader(ComplexNumberMapper mapper) {
		this.complexNumberMapper = mapper;
	}

}
