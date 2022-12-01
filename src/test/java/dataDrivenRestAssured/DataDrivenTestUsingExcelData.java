package dataDrivenRestAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import in.reqres.restassured.utilities.ExcelUtils;
import io.restassured.http.ContentType;

public class DataDrivenTestUsingExcelData {

	@DataProvider(name = "dataForExcelTest")
	public Object[][] getDataForFakeApiFromExcel() throws IOException
	{
		String path = System.getProperty("user.dir") + "/data/restAssured-dataDrivenTestingData.xlsx";
		
		int rowcount = ExcelUtils.getRowCount(path, "Sheet1");
		int cellcount = ExcelUtils.getCellCount(path, "Sheet1", 1);
		
		Object data[][] = new Object[rowcount][cellcount];
		
		for(int i=1; i<=rowcount; i++)
		{
			for(int j=0; j<cellcount; j++)
			{
				data[i-1][j] = ExcelUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return data;
	
	}
	

	@Test(dataProvider = "dataForExcelTest")
	public void testPostRequestWithExcelData(String firstName, String lastName, String subjectId)
	{
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectId", subjectId);
		
		given()
			.contentType(ContentType.JSON)	// passing data as json
			.accept(ContentType.JSON) 	// will accept data as json
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.log().all();
	}
}

