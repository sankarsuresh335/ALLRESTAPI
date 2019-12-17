package testbase;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

	public static RequestSpecification httprequest;

	public static Response response;

	public String empid = "51328";

	public Logger logger;

	@BeforeClass
	public void commmanmethod() {

		
		  logger=Logger.getLogger("BaseTest.class");
		  PropertyConfigurator.configure("Log4j.propertiesfile");

		logger.setLevel(Level.DEBUG);

	}

}
