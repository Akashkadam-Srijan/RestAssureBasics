package Day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


// Key-value pairs providing metadata about the request

public class HeaderDemo {
	
	@Test
	void testHeaders()
	{
		
		given()
		
		.when()
			.get("https://www.google.com/")
		
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.and()
			.header("Content-Encoding", "gzip")
			.and()
			.log().headers();
		
		// for single header use .header method
		// for all header use .headers method
	}

}
