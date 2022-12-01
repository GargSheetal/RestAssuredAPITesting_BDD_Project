package in.reqres.restassured.testcases;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class TC006_DELETE_User {
	
	@Test
	public void deleteUserTest()
	{

		when()
			.delete("https://reqres.in/api/users/2")
		.then()
			.statusCode(204)
			.statusLine("HTTP/1.1 204 No Content")
			.header("Content-Length", "0")
			.log().all();

	}

}
