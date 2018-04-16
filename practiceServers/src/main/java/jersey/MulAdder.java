package jersey;

import java.util.Vector;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Path("/mulAdd")
@Component
public class MulAdder implements Processor<Vector<Integer>> {
	private Adder adder;
	private Multiplier multiplier;
	
	@Override
	public Vector<Integer> arithmatic (Integer[] input) {
		//	Multiplying and two and then adding the multiplaction to first, just for the sake of having multiple dependencies
		Vector<Integer> temp = multiplier.arithmatic(input);
		input[2] = temp.get(0);
		input[3] = temp.get(1);
		return adder.arithmatic(input);
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String HTMLAdder(@QueryParam("Real1") Integer real1, @QueryParam("Img1") Integer img1, 
			@QueryParam("Real2") Integer real2 , @QueryParam("Img2") Integer img2) {
		Integer[] i = new Integer[4];
		i[0] = real1;
		i[1] = img1;
		i[2] = real2;
		i[3] = img2;
		Vector<Integer> output = this.arithmatic(i);
		String outputString = output.get(0).toString() + " + " + output.get(1).toString() + "i";
		return outputString;
	}
	
	@Inject
	public MulAdder(Adder adder, Multiplier multiplier) {
		this.adder=adder;
		this.multiplier=multiplier;
	}
}
