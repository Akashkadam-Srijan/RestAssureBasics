package Day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.given;



// Different ways to create post request body
// 1. HashMap 2. Org.JSON 3. POJO class 4. External JSON file data

public class DiffWaysCreatePostRequestBody {
	
	
	@Test(priority = 1)
	void testPostUsingHashmap()
	{
		
		HashMap data = new HashMap();
		data.put("name", "AK");
		data.put("job", "Testing");
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/api/users")
		
		.then()
			.statusCode(201)
			.log().all();
		
	}
	
	@Test(priority = 2)
	void testPostUsingJsonLibrary()
	{
		
		JSONObject data = new JSONObject();
		data.put("name", "MK");
		data.put("job", "Developer");
		
		given()
			.contentType("application/json")
			.body(data.toString()) // When we using JSONobject need to convert data into String format
		
		.when()
			.post("https://reqres.in/api/api/users")
		
		.then()
			.statusCode(201)
			.log().all();
		
	}
	
	@Test(priority = 3)
	void testPostUsingPOJO_()
	{
		
		POJO_PostRequest data = new POJO_PostRequest();
		data.setName("RK");
		data.setJob("Data Analyst");
		
		
		
		given()
			.contentType("application/json")
			.body(data) 
			
			
		.when()
			.post("https://reqres.in/api/api/users")
		
		.then()
			.statusCode(201)
			.log().all();
		
	}
	
	@Test(priority = 4)
	void testPostUsingExternalJsonFile() throws FileNotFoundException
	{
		
		
		File f= new File("/Users/akashkadam/eclipse-workspace/RestAssuredTraining/body.json");
		FileReader fr = new FileReader(f);
		
		JSONTokener tr = new JSONTokener(fr);
		JSONObject data = new JSONObject(tr);
		
		
		given()
			.contentType("application/json")
			.body(data.toString()) 
			
			
		.when()
			.post("https://reqres.in/api/api/users")
		
		.then()
			.statusCode(201)
			.log().all();
		
	}

}
