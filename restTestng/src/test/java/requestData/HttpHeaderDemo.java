package requestData;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HttpHeaderDemo {

	@Test
	public void Hedertype() {

		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		RequestSpecification Httprequest = RestAssured.given();

		Response response = Httprequest.get("/Chennai");

		String reponseheder = response.header("Content-Type");

		System.out.println("conten type" + reponseheder);

		String servercode = response.header("Server");

		System.out.println("servercode" + servercode);

		String acceptLanguage = response.header("Content-Encoding");
		System.out.println("Content-Encoding: " + acceptLanguage);
		
		JsonPath jsonexcutor=response.jsonPath();
		
		String city=jsonexcutor.get("City");
		
		System.out.println("city name"+city);
	}

}
