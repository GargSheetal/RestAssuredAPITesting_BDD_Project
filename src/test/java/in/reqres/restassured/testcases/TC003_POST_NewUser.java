package in.reqres.restassured.testcases;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import in.reqres.restassured.utilities.RestUtils;
import io.restassured.http.ContentType;

public class TC003_POST_NewUser {
	
	
	@Test
	public void testNewUser()
	{
		HashMap map = new HashMap();
		map.put("name", RestUtils.getFirstName());
		map.put("job", RestUtils.getJob());
		
		System.out.println(map);
		JSONObject request = new JSONObject(map);
		
		System.out.println(request);
		
		given()
			.body(request.toJSONString())
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.statusLine("HTTP/1.1 201 Created")
			.log().all();
	}

}
