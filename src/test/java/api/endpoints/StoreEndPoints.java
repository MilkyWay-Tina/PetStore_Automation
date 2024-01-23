package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payload.Store;
import api.payload.User; // imported payload class package
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//Created to perform CRUD requests to the user API

public class StoreEndPoints {
	
	public static Response placeOrder(Store payload)
	{
		Response response=given()
		
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.store_post_url); //static method post_url
	
		return response;
		
	}
	public static Response getOrder(String id)
	{
		Response response=given()
		.pathParam("id",id)
		.when()
		.get(Routes.store_get_url);
		
		return response;
	}

	public static Response deleteOrder(String id)
	{
		Response response=given()
		.pathParam("id", id)
		.when()
		.delete(Routes.store_delete_url);
		
		return response;
	}

}
