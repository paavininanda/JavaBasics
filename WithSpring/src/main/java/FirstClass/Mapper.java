package FirstClass;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface Mapper {
	@Select("Select * from input where SNo=#{index}")
	public ComplexNumber getNums(Integer index);
	
	@Select("Select * from input")
	public ComplexNumber[] getAllInputs();
	
	@Insert("Insert into input(Real1,Img1,Real2,Img2) values(#{Real1},#{Img1},#{Real2},#{Img2})")
	public int insertToInput(ComplexNumber c);
	
}
