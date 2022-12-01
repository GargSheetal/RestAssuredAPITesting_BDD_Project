package miscellaneous.restassured.testcases;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TC007_Validations {
	
	// Validating status code
	@Test(priority=1)
	public void testStatusCode()
	{
		when()
			.get("https://jsonplaceholder.typicode.com/posts/5")
		.then()
			.statusCode(200);
		//	.log().all();		
	}
	
	// Validating status code
	@Test(priority=2)
	public void testLogging()
	{
		when()
			.get("https://jsonplaceholder.typicode.com/users/8")
		.then()
			.statusCode(200)
			.log().all();		
	}
	
	// Verifying Single content in the response body
	@Test(priority=3)
	public void testSingleContent()
	{
		when()
			.get("https://jsonplaceholder.typicode.com/users/8")
		.then()
			.statusCode(200)
			.body("address.zipcode", equalTo("45169"));
					
	}
	
	// Verifying Multiple content in the response body
	@Test(priority=4)
	public void testMultipleContent()
	{
		when()
			.get("https://jsonplaceholder.typicode.com/users")
		.then()
			.statusCode(200)
			.body("username", hasItems("Bret", "Antonette", "Samantha"));
					
	}
	
	// Adding params and headers to the post request
		@Test(priority=5)
		public void testParamsAndHeaders()
		{
			given()
				.formParam("email", "eve.holt@reqres.in")
				.formParam("password", "pistol")
	//			.header("Content-Type", "application/json")
			.when()
				.post("https://reqres.in/api/register")
			.then()
				.statusCode(200)
				.log().all();
						
		}


}
