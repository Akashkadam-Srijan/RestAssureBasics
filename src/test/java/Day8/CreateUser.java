package Day8;


import com.github.javafaker.Faker;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class CreateUser {
	
	@Test
	void testCreateUser(ITestContext context)
	{
		Faker faker= new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "Inactive");
		
		String barerToken = "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";
		
		
		int id = given()
		 	.headers("Authorization","Bearer "+barerToken )
			.contentType("application/json")
			.body(data.toString())
		
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		
		System.out.println("Generated id is:"+ id);
		
		//context.setAttribute("user_Id", id); // test level access
		context.getSuite().setAttribute("user_Id", id); // Suite level access
		
		
		
	}
	
	

}
