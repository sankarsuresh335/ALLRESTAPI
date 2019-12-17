package requestData;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestDemoPost {
	@Test
	public void getPostmethod() {

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		RequestSpecification httprequest = RestAssured.given();

		JSONObject parameter = new JSONObject();

		parameter.put("FirstName", "sankar");
		parameter.put("LastName", "suresh");
		parameter.put("UserNmae", "sandy");
		parameter.put("password", "sanp335");
		parameter.put("Email", "Sanp335@gmail.com");

		httprequest.header("Content-type", "application/json");

		httprequest.body(parameter.toJSONString());

		Response response = httprequest.request(Method.POST, "/register");

		String responsebody = response.getBody().asString();

		System.out.println("getresponsebody" + responsebody);

		int stauscode = response.getStatusCode();

		System.out.println("staus code" + stauscode);

		Assert.assertEquals(stauscode, 200);

		String staus = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(staus,"OPERATION_SUCCESS");

	}

}
