package in.reqres.restassured.testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import in.reqres.restassured.utilities.RestUtils;

public class TC004_PUT_UpdateUser {

	JSONObject request;
	int id = 2;
	
	@BeforeClass
	public void updateData()
	{
		request = new JSONObject();
		request.put("name", RestUtils.getFirstName());
		request.put("job", RestUtils.getJob());
	}
	
	@Test
	public void updateUser()
	{
		given()
			.body(request)
			.header("Content-Type", "application/json")
		.when()
			.put("https://reqres.in/api/users/" + id)
		.then()
			.statusCode(200)
			.log().all();
			
			
	}
	
	
}
