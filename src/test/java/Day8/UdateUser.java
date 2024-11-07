package Day8;


import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class UdateUser {
	
	@Test
	void test_udateUser(ITestContext context)
	{
		Faker faker= new Faker();
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "Active");
		
		String barerToken = "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";
		
		//int id =(int) context.getAttribute("user_Id");
		int id =(int) context.getSuite().getAttribute("user_Id");
		
		 given()
		 	.headers("Authorization","Bearer "+barerToken )
			.contentType("application/json")
			.body(data.toString())
			.pathParam("id", id)
		
		.when()
			.put("https://reqres.in/api/users/{id}")
			
		
		.then()
			.statusCode(200)
			.log().all();
		
		
	}
	
	

}
