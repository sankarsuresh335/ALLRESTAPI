package requestData;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestPut {
	
	public void putmethod() {
		
		
		int empid=15042;
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httprequest=RestAssured.given();
		
		JSONObject requestParams=new JSONObject();
		
		requestParams.put("name", "Zion"); 
		requestParams.put("age", 23);
		requestParams.put("salary", 12000);
		
		httprequest.header("Conten-Type","application/json");
		
		httprequest.body(requestParams.toJSONString());
		
		Response response = httprequest.put("/update/"+ empid);

		int statusCode = response.getStatusCode();
		System.out.println(response.asString());
		Assert.assertEquals(statusCode, 200);
		
		
		
		
		
		
		
	}

}
