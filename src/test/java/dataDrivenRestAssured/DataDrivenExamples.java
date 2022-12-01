package dataDrivenRestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExamples extends DataProviderClass {

//	@Test(dataProvider = "dataForPost")
	public void test_postDD(String firstName, String lastName, int subjectId)
	{
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectId", subjectId);
		
		given()
			.contentType(ContentType.JSON)	// passing data as json
			.accept(ContentType.JSON) 	// will accept data as json
			.header("Content-Type", "application/json")
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.statusLine("HTTP/1.1 201 Created")
			.log().all();
	}
	
	
//	@Test(dataProvider = "deleteData")
	public void test_delete(int userId)
	{
		baseURI = "http://localhost:3000";
		
		when()
			.delete("/users/" + userId)
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Parameters({"userId"})
	@Test()
	public void test_delete2(int userId)
	{
		System.out.println("Value for userId is: " + userId);
		baseURI = "http://localhost:3000";
		
		when()
			.delete("/users/" + userId)
		.then()
			.statusCode(200)
			.log().all();
	}

	
	
	
	
	
}
