package Day3;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;


// Small data sent from the server for session management. 

public class CookiesDemo {
	
	@Test(priority=1)
	void testCookies()
	{
		
		given()
		
		.when()
			.get("https://www.google.com/")
		
		.then()
			//.cookie("AEC","AVYB7cq88YpvBiYxi_KWuxwtV7W-V-KHDvShltaqt5A-ZSPgfmhgkXZHc3E") // Value keep change every time
			//.log().all();
			.log().cookies();
	}
	
	
	// Retrieve cookies information
	
	@Test(priority=2)
	void getCookiesInfo()
	{
		
		Response res = given()
		
		.when()
			.get("https://www.google.com/");
		
		// Get Single cookies information  
		
		 String cookies_value= res.getCookie("AEC");
		 System.out.println("cookies_value ---> " + cookies_value);
		 
		 // Get all cookies information
		 
		 Map<String, String> cookies_values = res.getCookies();
		 
		 for(String k:cookies_values.keySet())
		 {
			 String cookies_value1 = res.getCookie(k);
			 System.out.println(k+ "    "+ cookies_value1);
			 
		 }
		 
		
	}


}
