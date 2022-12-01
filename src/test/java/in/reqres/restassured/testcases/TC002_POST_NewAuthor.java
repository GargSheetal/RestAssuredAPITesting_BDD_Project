package in.reqres.restassured.testcases;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import in.reqres.restassured.utilities.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TC002_POST_NewAuthor {
	
	public HashMap map = new HashMap();
//	JSONObject request;
	
	@BeforeClass
	public void postData()
	{
		map.put("id", RestUtils.getAuthorId());
		map.put("idBook", RestUtils.getBookId());
		map.put("firstName", RestUtils.getFirstName());
		map.put("lastName", RestUtils.getLastName());
		
	//	request = new JSONObject(map);
		
		RestAssured.baseURI = "https://fakerestapi.azurewebsites.net";
		RestAssured.basePath = "/api/v1/Authors";
	}
	
	@Test
	public void postNewAuthor()
	{
		map = new HashMap();
		
		// Storing the response in the response object
		Response response =
				
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(map)
		.when()
			.post()
		.then()
			.statusCode(200)
			.header("Content-Type", equalTo("application/json; charset=utf-8; v=1.0"))
			.log().all()
			.extract().response();	// extract the response
		
		String jsonAsString = response.asString();
		Assert.assertEquals(jsonAsString.contains("id"), true);
		
	}

}
