package requestData;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AllTheHeader {
	
	@Test
	public void allheder() {
		
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httprequest=RestAssured.given();
		
		
		Response response=httprequest.get("/Chennnai");
		
		Headers head=response.headers();
		
		
		for (Header header : head) {
			
			
			System.out.println("key name" + header.getName() +"value name "+ header.getValue());
			
		}
		

		
		
		
		
	}

}
