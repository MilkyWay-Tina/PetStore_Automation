package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	User userPayload;
	
	Faker faker;// generate random data 
	 public Logger logger; // created for logs to generate info
	@BeforeClass // execute before the class
	
	public void setUp()
	{
		faker =new Faker();// generate random data
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());//generates random number
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		//logs
		logger=LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("******Creating User***********");
		Response response=UserEndPoints.createUser(userPayload);
		response.then().log().all();// validate the output
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("***User is created***********");
	}
	
	@Test(priority=2)
	public void testGetUserbyName()
	{
		logger.info("******Reading User info***********");
		Response response=UserEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();//chia assertions is used which is based on RestAssured
		
		Assert.assertEquals(response.getStatusCode(), 200);//TestNg Assertions
		logger.info("******USer info is displayed***********");
	}
	
	@Test(priority=3)
	public void testUpdateUserbyName()
	{
		//update data using payload
	
		logger.info("******Updating USer***********");
	userPayload.setFirstName(faker.name().firstName());
	userPayload.setLastName(faker.name().lastName());
	userPayload.setEmail(faker.internet().safeEmailAddress());
	
	Response response=UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
	response.then().log().body();//chia assertions is used which is based on RestAssured
	
	Assert.assertEquals(response.getStatusCode(), 200);//TestNg Assertions
	
	//get the data to validate after update
	Response responseafterUpdate=UserEndPoints.readUser(this.userPayload.getUsername());
	Assert.assertEquals(responseafterUpdate.getStatusCode(), 200);
	logger.info("******USer Updated***********");
	
}
	
	@Test(priority=4)
	public void testDeleteUserbyName()
	{
		logger.info("******Deleting user***********");
		Response response=UserEndPoints.deleteUser(this.userPayload.getUsername());

		
		Assert.assertEquals(response.getStatusCode(), 200);//TestNg Assertions
		logger.info("******USer is deleted***********");
	}
	
}
