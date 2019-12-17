package requestData;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import testbase.BaseTest;

public class Get_Request_Employees extends BaseTest{
	
	
	@BeforeClass
	public void name() {
		
		logger.info("user given in the useage request");
		
		RestAssured.baseURI="https://reqres.in/";
		
		httprequest=RestAssured.given();
		
		response=httprequest.get("api/users?page=2");
		
	}
	
	@Test
	void Reponsebody() {
		
		
		logger.info("to cheking the infomramtion body");
		
		
		String reponsestaus=response.body().asString();
		
		logger.info("infomation about reponsebody"+reponsestaus);
		
		Assert.assertTrue(reponsestaus!=null);
		
	}
	
	@Test
	void Statuscode() {
		
		
		logger.info("to verfiy the statuscode");
		
		int reponsecode=response.getStatusCode();
		
		logger.info("staus code"+reponsecode);
		
		Assert.assertEquals(reponsecode, 200);
		
	}
	
	@Test
	void contenttype() {
		
		logger.info("to verfiy the contenttype");
		
		String contenttype=response.header("Content-Type");
		
		logger.info("content type"+contenttype);
		
		Assert.assertEquals(contenttype, "application/json; charset=utf-8");
		
	}
	
	
	
	
	
	
	
	
}
