package Day8;


import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class DeleteUser {
	
	@Test
	void test_deleteUser(ITestContext context)
	{
	
		String barerToken = "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";
		//int id =(int) context.getAttribute("user_Id");
		int id =(int) context.getSuite().getAttribute("user_Id");
		
		 given()
		 	.headers("Authorization","Bearer "+barerToken )
			.pathParam("id", id)
		
		.when()
			.delete("https://reqres.in/api/users/{id}")
			
		
		.then()
			.statusCode(204)
			.log().status();
			
		
		
	}
	
	

}
