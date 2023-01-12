package in.reqres.restassured.testcases;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC007_GET_SingleUser {
	
	@Test
	public void getSingleUser()
	{
		given()
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all()
			.body("data.id", equalTo(2));
		
	}

}
