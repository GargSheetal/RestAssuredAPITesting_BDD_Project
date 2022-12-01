package serializationDeserialization;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class PostRequestNoSerialization {

	public HashMap map = new HashMap();
	
	@Test(priority=1)
	public void createNewPost()
	{
		map.put("userId", "10");
		map.put("it", "101");
		map.put("title", "posting new comment");
		map.put("body", "posting first comment without using serialization");

		given()
			.contentType(ContentType.JSON)
			.body(map)
		.when()
			.post("https://jsonplaceholder.typicode.com/posts")
		.then()
			.statusCode(201)
			.body("it", equalTo("101"))
			.log().all();
		

	}
	
	// Get request
	@Test(priority=2)
	public void getPost()
	{
		given()
		.when()
			.get("https://jsonplaceholder.typicode.com/posts/100")
		.then()
			.statusCode(200)
			.assertThat().body("id", equalTo(100))
			.log().all();
	}
	
	
	
}
