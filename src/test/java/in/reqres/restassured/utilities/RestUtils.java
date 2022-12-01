package in.reqres.restassured.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String getAuthorId()
	{
		String generatedString = RandomStringUtils.randomNumeric(2);
		return generatedString;
	}
	
	public static String getBookId()
	{
		String generatedString = RandomStringUtils.randomNumeric(3);
		return generatedString;
	}
	
	public static String getFirstName()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return ("John" +generatedString);
	}
	
	public static String getLastName()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return ("Miller" + generatedString);
	}
	
	public static String getJob()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(4);
		return ("job" + generatedString);
	}
	
	

}
