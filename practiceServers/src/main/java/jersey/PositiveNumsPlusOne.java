package jersey;

import java.util.Arrays;
import java.util.Vector;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Path("/positiveNums")
@Component
public class PositiveNumsPlusOne implements Processor<Vector<Integer>>{

	@Override
	public Vector<Integer> arithmatic (Integer[] input) {
		Vector<Integer> output = new Vector<Integer>();
		Arrays.stream(input).filter(number -> number>0).map(num -> num+1).forEach(num -> output.add(num));
		return output;
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	public String HTMLAdder(@FormParam("Real1") Integer real1, @FormParam("Img1") Integer img1, @FormParam("Real2") Integer real2 , @FormParam("Img2") Integer img2) {
		Integer[] i = new Integer[4];
		i[0] = real1;
		i[1] = img1;
		i[2] = real2;
		i[3] = img2;
		Vector<Integer> output = this.arithmatic(i);
		String outputString = output.get(0).toString() + output.get(1).toString() + output.get(2).toString();
		return outputString;
	}
}
