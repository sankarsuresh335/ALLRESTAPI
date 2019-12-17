package requestData;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Httppostverbal {
	
	@Test
	public void postmethod() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		RequestSpecification Httprequest=RestAssured.given();
		
		JSONObject requestParams= new JSONObject();
		
		requestParams.put("FirstName",  "Virender"); 
		requestParams.put("LastName", "Singh");

		requestParams.put("UserName", "simpleuser001");
		requestParams.put("Password", "password1");
		requestParams.put("Email", "someuser@gmail.com");
		
		Httprequest.header("Content-Type","application/json");
		
		Httprequest.body(requestParams.toJSONString());
		
		Response response=Httprequest.post("/register");
		
		int statuscode=response.getStatusCode();
		
		Assert.assertEquals(statuscode, 200);
		
		System.out.println(statuscode);
		
		System.out.println("system sccess code"+response.body().asString());
		
		String sucesscode =response.jsonPath().get("SuccessCode");
		
		Assert.assertEquals( "Correct Success code was returned", sucesscode, "OPERATION_SUCCESS");
		
		
		
	}

}
