package Day1;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

// Use Gerkin  keywords:

//	1. given() --> Content type, Set cookies, Add auth, Add param, Set headers Info 
//	
//	2. when() --> get , post, put, delete 
//	
//	3. then() --> validation status code, extract response, extract headers cookies and response body


public class HTTPRequests {
	
	int id;
	
	@Test(priority=1)
	void getUser()
	{
		
		given()
		
		
		.when()
			.get("https://reqres.in/api/users?page=2") // get method --> retrieve data
		
		
		.then()
			.statusCode(200) // validation 
			.body("page",equalTo(2)) // validation 
			.log().all(); // Display all response on console 
		
	}
	
	@Test(priority=2)
	void createUser() {
		
		HashMap data= new HashMap();
		data.put("name","Akash");
		data.put("job","QA");
		
		
		id=given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/api/users")  // Post method --> Insert the data
			.jsonPath().getInt("id");
//		.then()
//			.statusCode(201)
//			.log().all();
	}
	
	@Test(priority=3, dependsOnMethods = {"createUser"})
	void updateUser() {
		
		HashMap data= new HashMap();
		data.put("name","John");
		data.put("job","Lead");
		
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.put("https://reqres.in/api/api/users" + id)  // Put method --> Update the data
		
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority = 4)
	void deleteUser()
	{
		
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+ id)
		
		.then()
			.statusCode(204)
			.log().all();
		
		
	}

}
