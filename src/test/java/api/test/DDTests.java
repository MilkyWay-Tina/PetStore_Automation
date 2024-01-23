package api.test;
import org.testng.Assert;
import org.testng.annotations.Test;



import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

//Data driven test
// using dataproviders to create multiple user sending POST request
public class DDTests {


	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)//if data providers is created in different class,dataPRoviderCLass is used to access it 
	// mention  parameter order as per the data in excel sheet
	public void testPostUser(String userID,String userName,String fname,String lname,String useremail,String pwd,String ph)
	{
		User userPayload=new User();
		
		userPayload.setId(Integer.parseInt(userID));// converting String to Integer
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
        userPayload.setLastName(lname);
        userPayload.setEmail(useremail);
        userPayload.setPassword(pwd);
        userPayload.setPhone(ph);
		
        Response response = UserEndPoints.createUser(userPayload);
       Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	//delete the user
	public void testDeleteUSerByName(String userName)
	{
		Response response = UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
