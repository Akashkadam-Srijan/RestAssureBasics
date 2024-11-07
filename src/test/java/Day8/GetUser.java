package Day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;



public class GetUser {
	
	@Test
	void test_GetUser(ITestContext context)
	{
		
		//int id =(int) context.getAttribute("user_Id"); // This should come from CreateUser request
		int id =(int) context.getSuite().getAttribute("user_Id");
		
		String barerToken = "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";
		
		
		 given()
		 	.headers("Authorization","Bearer "+barerToken)
		 	.pathParam("id", id)
			
		
		.when()
			.get("https://reqres.in/api/users?page=2/{id}")
			
		.then()
			.statusCode(200)
			.log().all();
		 
		
		
		
		
	}
	
	

}
