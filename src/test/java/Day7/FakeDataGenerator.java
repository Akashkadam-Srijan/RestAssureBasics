package Day7;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakeDataGenerator {
	
	@Test
	public void testDummyDataGenerator()
	{
		
		Faker faker= new Faker();
		
		String fullName = faker.name().fullName();
		String lastName = faker.name().lastName();
		String firstname = faker.name().firstName();
		
		
		String city = faker.address().city();
		String username = faker.name().username();
		String pass = faker.internet().password();
		
		
		System.out.println("fullName: "+ fullName);
		System.out.println("lastName: "+ lastName);
		System.out.println("firstname: "+ firstname);
		System.out.println("city: "+ city);
		System.out.println("username: "+ username);
		System.out.println("pass: "+ pass);
		
		
		
		 String[] data = {fullName, lastName, firstname};
		 
		 for(String i: data)
		 {
			 System.out.println(i);
		 }
		
	}

}
