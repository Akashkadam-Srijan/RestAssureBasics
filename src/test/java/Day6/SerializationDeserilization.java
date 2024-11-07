package Day6;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;


public class SerializationDeserilization {
	
	
	//Convert POJO --> JSON - Serialization
	
	@Test
	void convertPOJO2Json() throws JsonProcessingException
	{
		Student stuPOJO = new Student();
		stuPOJO.setName("RK");
		stuPOJO.setJob("Data Analyst");
		
		// Convert java object to JSON object
		
		ObjectMapper objMapper = new ObjectMapper();
		
		String jsonData = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stuPOJO);
		
		System.out.println(jsonData);
		
	}

	
	// Convert JSON ---> POJO  De-Serialization
	
	@Test
	void convertJson2POJO() throws JsonProcessingException
	{
		
		String jsonData ="{\n"
				+ "  \"name\" : \"RK\",\n"
				+ "  \"job\" : \"Data Analyst\"\n"
				+ "}";
		
		
		// Convert JSON ---> POJO
		
		ObjectMapper objMapper = new ObjectMapper();
		
		Student stuPOJO = objMapper.readValue(jsonData, Student.class);
		
		System.out.println("Student Name : " + stuPOJO.getName());
		System.out.println("Student Job: " + stuPOJO.getJob());
		
		
		
	}
	
}
