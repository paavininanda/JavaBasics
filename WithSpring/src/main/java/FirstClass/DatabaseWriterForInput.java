package FirstClass;


import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class DatabaseWriterForInput{

	private Mapper mapper;

	public void insert(Integer inputNums[]) {
		Integer sNoDefault = 1;
		ComplexNumber c = new ComplexNumber(sNoDefault,inputNums[0],inputNums[1],inputNums[2],inputNums[3]);
		mapper.insertToInput(c);
	}
	
	@Inject
	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}

}
