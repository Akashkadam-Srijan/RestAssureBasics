package Day7;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Authentications {
	
	//@Test(priority=1)
	void testBasicAuthentications()
	{
		given()
			.auth().basic("postman", "password") // Try to dynamic pass Username and Password
		
		.when()
			.get("https://postman-echo.com/basic-auth")
		
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
		
	}
	
	//@Test(priority=2)
	void testDigestAuthentications()
	{
		given()
			.auth().digest("postman", "password")
		
		.when()
			.get("https://postman-echo.com/basic-auth")
		
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
		
	}
	
	//@Test(priority=3)
	void testPreemptiveAuthentications()
	{
		given()
			.auth().preemptive().basic("postman", "password")
		
		.when()
			.get("https://postman-echo.com/basic-auth")
		
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
		
	}
	
	//@Test(priority=4)
	void testBearerTokenAuthentications()
	
	{
		
		String bearerToken= "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";
		
		given()
			.header("Authorization", "Bearer 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")
		
		.when()
			.get("https://github.com/Akashkadam-Srijan")
		
		
		.then()
			.statusCode(200)
			.log().status()
			.log().all();
			
	}

	//@Test
	void testOAuth1Authentications()
	{
		given()
			.auth().oauth("consumerKey","consumeSecrat", "accessToken", "tokenSecrat") // this is for OAuth1.0 Authentications 
		
		.when()
			.get("URL")
		
		.then()
			.statusCode(200);
	}
	
	//@Test(priority=5)
	void testOAuth2Authentications()
	{
		given()
			.auth().oauth2("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")
		
		.when()
			.get("https://github.com/Akashkadam-Srijan")
		
		.then()
			.statusCode(200)
			.log().status()
			.log().all();
	}
	
	@Test(priority=6)
	void testAPIKeysAuthentications()
	{
		given()
			.queryParam("appid","fe9c5cddb7e01d747b4611c3fc9eaf2c") // aapid is APIKey
			.pathParam("mypath", "data/2.5/forecast/daily")
			.queryParam("q", "Delhi")
			.queryParam("cnt", "1")
		
		.when()
			//.get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&cnt=1")
			.get("https://api.openweathermap.org/{mypath}")
		
		
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
}
