package miscellaneous.restassured.testcases;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class FakeAPI_RequestExamples {
	
//	@Test(priority=1)
	public void test_get()
	{
		baseURI = "http://localhost:3000";
		
		given()
			.param("name", "Automation")	// it means http://localhost:3000/subjects?name=Automation
			.get("/subjects")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
//	@Test(priority=2)
	public void test_post()
	{
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Tom");
		request.put("lastName", "Cooper");
		request.put("subjectId", 2);
		
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
	
//	@Test(priority=3)
	public void test_patch()
	{
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		
		request.put("lastName", "Miller");
		
		given()
			.contentType(ContentType.JSON)	// passing data as json
			.accept(ContentType.JSON) 	// will accept data as json
			.header("Content-Type", "application/json")
			.body(request.toJSONString())
		.when()
			.patch("/users/4")
		.then()
			.statusCode(200)
			.log().all();
	}
	
//	@Test(priority=4)
	public void test_put()
	{
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Mary");
		request.put("lastName", "Jane");
		request.put("subjectId", 2);
		
		given()
			.contentType(ContentType.JSON)	// passing data as json
			.accept(ContentType.JSON) 	// will accept data as json
			.header("Content-Type", "application/json")
			.body(request.toJSONString())
		.when()
			.put("/users/4")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority=5)
	public void test_delete()
	{
		baseURI = "http://localhost:3000";
		
		when()
			.delete("/users/4")
		.then()
			.statusCode(200)
			.log().all();
	}

}
