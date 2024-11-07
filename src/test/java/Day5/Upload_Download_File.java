package Day5;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Upload_Download_File {
	
	@Test(priority=1)
	void singleFile_Upload() 
	{
		
		File myfile = new File("/Users/akashkadam/eclipse-workspace/RestAssuredTraining/Test.txt"); // Insert the File path
		// need to use relative path
		
		given()
			.multiPart("file",myfile)
			.contentType("multipart/from-data")
		
		.when()
			.post("")  // Need correct API
		
		.then()
			.statusCode(200)
			.body("filename",equalTo("Test.txt"))
			.log().all();
	}
	
	@Test 
	void MultipleFile_Upload() 
	{
		
		File myfile1 = new File("/Users/akashkadam/eclipse-workspace/RestAssuredTraining/Test.txt1"); 
		File myfile2 = new File("/Users/akashkadam/eclipse-workspace/RestAssuredTraining/Test.txt2"); 
		
		
		given()
			.multiPart("file1",myfile1)
			.multiPart("file2",myfile2)
			.contentType("multipart/from-data")
		
		.when()
			.post("") // Need correct API
		
		.then()
			.statusCode(200)
			.body("filename1",equalTo("Test.txt1"))
			.body("filename2",equalTo("Test.txt2"))
			.log().all();
	}
	
	@Test(priority=2)
	void downloadFile()
	{
		given()
		
		.when() 
			.get("")  // Need correct API
			
		.then()
			.statusCode(200)
			.log().body();
	}

}
