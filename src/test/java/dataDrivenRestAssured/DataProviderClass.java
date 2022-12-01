package dataDrivenRestAssured;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	
	@DataProvider(name="dataForPost")
	public Object[][] dataForPostRequest()
	{
//		Object[][] data = new Object[2][3];
//		data [0][0] = "Albert";
//		data [0][1] = "Chuck";
//		data [0][2] = 1;
//		
//		data [1][0] = "Carie";
//		data [1][1] = "Harper";
//		data [1][2] = 2;
//		
//		return data;
		
		return new Object[][] {
			
			{"Graham", "Bell", 1},
			{"Henry", "Ford", 2}
		};
		
	}
	
	@DataProvider(name = "deleteData")
	public Object[] dataForDelete()
	{
		return new Object[] {
			4, 5
		};
	}

}
