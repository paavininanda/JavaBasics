package FirstClass;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface Mapper {
	
	@Select("Select real1,img1,real2,img2 from input where SNo=index")
	public Integer[] getNums(Integer index);
	
	@Select("Select * from input")
	public Integer[][] getAllInputs();
	
	@Insert("Insert into input(real1,img1,real2,img2) values(#{input[0]},#{input[1]},#{input[2]},#{iinput[3]})")
	public int insertToInput(Integer[] input);
	
}
