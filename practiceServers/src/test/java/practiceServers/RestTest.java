package practiceServers;

import static org.hamcrest.CoreMatchers.containsString;

import org.junit.Before;
import org.junit.Test;

import  com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

import  static com.jayway.restassured.RestAssured.get;
import  static com.jayway.restassured.RestAssured.given;


public class RestTest{
	
	@Before
	public void intialise() {
	    RestAssured.baseURI = "http://localhost";
	    RestAssured.port = 8080;
	}
	
	@Test
    public void testRestAdd() {
        	get("/practiceServers/add/1/2/3/4")
        .then().statusCode(200).body(containsString("4 + 6i"));;
    }
	
	@Test
    public void testRestSubtract() {
        	get("/practiceServers/subtract/?Real1=1&Img1=2&Real2=3&Img2=4")
        .then().statusCode(200).body(containsString("-2 + -2i"));;
    }
	
	@Test
    public void testRestMulAdd() {
        	get("/practiceServers/mulAdd/?Real1=1&Img1=2&Real2=3&Img2=4")
        .then().statusCode(200).body(containsString("-4 + 12i"));;
    }
	
	@Test
    public void testRestMul() {
        	get("/practiceServers/multiply/?Real1=1&Img1=2&Real2=3&Img2=4")
        .then().statusCode(200).body(containsString("-5 + 10i"));;
    }
	
	@Test
    public void testPositiveNums() {
        given().queryParam("Real1","1").queryParam("Img1","2").queryParam("Real2","3").queryParam("Img2","-5")
        .contentType(ContentType.URLENC).post("/practiceServers/positiveNums/")
        .then().statusCode(200).body(containsString("234"));;
    }
	
}
