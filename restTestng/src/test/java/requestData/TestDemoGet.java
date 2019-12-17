package requestData;

import org.apache.poi.util.SystemOutLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestDemoGet {

	
	@Test
	public void Getwetherdetails() {

		// specify the base uri
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// request object

		RequestSpecification httprequest = RestAssured.given();

		// response object

		Response response = httprequest.request(Method.GET, "/Chennai");

		String reponsebody = response.getBody().asString();

		System.out.println("get reponsebody" + reponsebody);

		int statuscode = response.getStatusCode();

		System.out.println("staus code" + statuscode);

		Assert.assertEquals(statuscode, 200);
		
		String stausline = response.getStatusLine();

		System.out.println("status" + stausline);

		Assert.assertEquals(stausline, "HTTP/1.1 200 OK");

	}

}
