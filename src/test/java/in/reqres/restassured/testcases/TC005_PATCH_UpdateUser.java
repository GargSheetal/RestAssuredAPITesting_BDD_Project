package in.reqres.restassured.testcases;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import in.reqres.restassured.utilities.RestUtils;

public class TC005_PATCH_UpdateUser {
	
	@Test
	public void updateUserByPATCH()
	{
		JSONObject request = new JSONObject();
		request.put("name", RestUtils.getFirstName());
		request.put("job", RestUtils.getJob());
		
		given()
			.body(request)
			.header("Content-Type", "application/json")
		.when()
			.patch("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.log().all();
		
		
		
	}

}
