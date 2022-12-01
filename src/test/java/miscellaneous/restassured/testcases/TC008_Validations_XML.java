package miscellaneous.restassured.testcases;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TC008_Validations_XML {
	
	// Verifying single content in XML response
	@Test(priority=1)
	public void testSingleContent() {
		
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.body("CUSTOMER.ID", equalTo("15"))
			.log().all();
		
	}

	// Verifying multiple content in XML response
	@Test(priority=2)
	public void testMultipleContent() {
	
		when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.body("CUSTOMER.ID", equalTo("15"))
			.body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
			.body("CUSTOMER.LASTNAME", equalTo("Clancy"))
			.body("CUSTOMER.STREET", equalTo("319 Upland Pl."))
			.body("CUSTOMER.CITY", equalTo("Seattle"));
			
	}

	// Verifying multiple content in XML response in one go
	@Test(priority=3)
	public void testMultipleContentInONeGo() {
	
		when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"));
			
	}

	// Find values using XML path in XML response
	@Test(priority=4)
	public void testUsingXPath() {
	
		when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.body(hasXPath("/CUSTOMER/FIRSTNAME"), containsString("Bill"));
			
	}
	
	// XPath with text() function
	@Test(priority=5)
	public void testUsingXPath2() {
	
		when()
			.get("http://thomas-bayer.com/sqlrest/INVOICE/")
		.then()
			.body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
			.log().all();
			
	}
	
}
