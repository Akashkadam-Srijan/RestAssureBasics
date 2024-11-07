package Day6;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class JSONSchemaValidation {
	
	@Test
	void jsonschemavalidation()
	{
		
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
			
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJSONSchema.json"));
		
		
		// XML Schema validation 
			
		//	.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("StoreXMLSchema.xsd"));
		
	}

}
