package api.endpoints;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User; // imported payload class package
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//Created to perform CRUD  (CReate Read,Update,Delete)requests to the user API

public class UserEndPoints2 {
	
	//method created for getting URL's from properties file
	
	
	static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");//load properties file."routes"- name of the properties file
		return routes;
	}
	public static Response createUser(User payload)
	{
		String post_url=getURL().getString("post_url");//get the URL from properties file
		Response response=given()
		
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(post_url); //url name from properties file
	
		return response;
		
	}
	public static Response readUser(String userName)
	{
		String get_url=getURL().getString("get_url");
		Response response=given()
		.pathParam("username", userName)
		.when()
		.get(get_url);
		
		return response;
	}
	public static Response updateUser(String userName,User payload)
	{
		String update_url=getURL().getString("update_url");
		Response response=given()
		
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		
		.when()
		.put(update_url); //static method
	
		return response;
		
	}
	public static Response deleteUser(String userName)
	{
		String delete_url=getURL().getString("delete_url");
		Response response=given()
		.pathParam("username", userName)
		.when()
		.delete(delete_url);
		
		return response;
	}

}
