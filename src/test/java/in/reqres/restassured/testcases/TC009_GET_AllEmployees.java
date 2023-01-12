package in.reqres.restassured.testcases;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class TC009_GET_AllEmployees {
	
	@Test
	public void getAllEmployees()
	{
		given()
		.when()
			.get("https://dummy.restapiexample.com/api/v1/employees")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.header("Content-Type", "application/json")
			.body("message", equalTo("Successfully! All records has been fetched."))
			.body("status", equalTo("success"))
			.body("data.employee_name", hasItems("Tiger Nixon", "Airi Satou", "Doris Wilder"))
			.log().all();
		
	}	

}
