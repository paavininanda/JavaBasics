package jersey;

import java.util.Vector;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Component
@Path("/add/{Real1}/{Img1}/{Real2}/{Img2}")
public class AdderP implements Processor<Vector<Integer>> {
	
	private Adder adder;
	
	@Override
	public Vector<Integer> arithmatic(Integer[] input) {
		return adder.arithmatic(input);
	}
	
		
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String HTMLAdder(@PathParam("Real1") Integer real1, @PathParam("Img1") Integer img1, @PathParam("Real2") Integer real2 , @PathParam("Img2") Integer img2) {
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
	public AdderP(Adder adder) {
		this.adder = adder;
	}
}
