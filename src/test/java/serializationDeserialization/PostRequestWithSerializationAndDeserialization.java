package serializationDeserialization;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostRequestWithSerializationAndDeserialization {
	
	@Test(priority=1)
	public void createNewPostSerialization()
	{
		PostComments pc = new PostComments();
		
		pc.setUserId(10);
		pc.setId(101);
		pc.setTitle("posting new comment");
		pc.setBody("posting first comment using serialization");
		
		given()
		.contentType(ContentType.JSON)
			.body(pc)
		.when()
			.post("https://jsonplaceholder.typicode.com/posts")
		.then()
			.statusCode(201)
			.body("it", equalTo(101))
			.body("postBody", equalTo("10 101 posting new comment posting first comment using serialization"))
			.log().all();
	
	}

}
