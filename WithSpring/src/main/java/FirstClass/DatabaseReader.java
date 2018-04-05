package FirstClass;

import java.io.FileNotFoundException;

import javax.inject.Inject;
import org.springframework.stereotype.Component;

@Component
public class DatabaseReader implements Reader{
	
	@Inject
	private Mapper mapper;
	
	@Override
	public Integer[] takeInput() throws FileNotFoundException {
		return mapper.getNums(0);
	}
	
//	@Inject
//	public void setMapper(Mapper mapper) {
//		this.mapper = mapper;
//	}

}
