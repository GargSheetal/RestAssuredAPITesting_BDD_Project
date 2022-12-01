package in.reqres.restassured.testcases;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class TC001_Get_AllUsers {
	
	@Test
	public void getAllUsers()
	{
		given()
			.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.assertThat().body("data.id[0]", equalTo(7))
			.body("data.first_name", hasItems("Michael", "Lindsay", "Tobias"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
		
		
		
		
		
	}

}
