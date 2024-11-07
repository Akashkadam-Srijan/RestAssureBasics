package Day4;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParsingJsonResponseData {
	
	
	@Test(priority=1)
	void testJsonResponse() 
	{
		
		// Approach 1 - Validate the data from bodies 
		
		given()
			.contentType(ContentType.JSON)
		
		.when()
			.get("https://reqres.in/api/users/2")
		
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all()
			.body("data.id", equalTo(2));	
	
	}
	

	@Test(priority=2)
	void testJsonResponse1() 
	{
		
		// Approach 2 - Mostly use this approach 
		
		Response res= given()
			.contentType(ContentType.JSON)
		
		.when()
			.get("https://reqres.in/api/users/2");
		
		Assert.assertEquals(res.statusCode(),200);
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		
		String orderId = res.jsonPath().get("data.id").toString();
		System.out.println(orderId);
		Assert.assertEquals(orderId,"2" );
		
		String emailId = res.jsonPath().get("data.email").toString();
		System.out.println(emailId);
		Assert.assertEquals(emailId,"janet.weaver@reqres.in");
			
	
	}
	
	@Test(priority=3)
	void testJsonResponseBodyData()
	{
			Response res= given()
				.contentType(ContentType.JSON)
			
			.when()
				.get("https://reqres.in/api/users?page=2");
		
			
			// Retrieve and validate the specific data from body Using JSONObject class
			
			JSONObject jo = new JSONObject(res.asString()); // Converting response to the JSON Object
			
			// Validation - Print all the email id from data
			
			Boolean status = false;
			
			for(int i=0; i<jo.getJSONArray("data").length(); i++)
			{
				String allEmails = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
				//System.out.println("Email ID: " + allEmails);
				
				if (allEmails.equals("michael.lawson@reqres.in"))
				{
					System.out.println("Email ID FOR Micheal : " + allEmails);
					status = true;
					break;
				}
				
				// Adding assertion
				Assert.assertEquals(status,true);
			}
	}
	
	
	// for XML Response Body only change the object
	
	@Test(priority= 4)
	void testXMLResponseBody()
	{
		Response res= given()
				.contentType(ContentType.JSON)
			
			.when()
				.get("https://reqres.in/api/users?page=2");
		
			
		XmlPath xmlobj= new XmlPath(res.asString());
		
		
	}

}
