package in.reqres.restassured.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC008_POST_NewEmployee {
	
	@Test
	public void postNewEmployee()
	{
		HashMap map = new HashMap();
		map.put("name", "Milan");
		map.put("salary", "40000");
		map.put("age", "38");
		
		Response response =
		given()
			.body(map)
			.contentType("application/json")
		.when()
			.post("https://dummy.restapiexample.com/api/v1/create")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.header("Server", "Apache")
			.body("status", equalTo("success"))
			.body("message", equalTo("Successfully! Record has been added."))
			.log().all()
			.extract().response();
		
		String jsonString = response.asString();
		Assert.assertTrue(jsonString.contains("id"));
	
	}

}
