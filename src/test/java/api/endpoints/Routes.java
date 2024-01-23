package api.endpoints;
/*
 * Swagger URI - https://petstore.swagger.io
 *Pet_USer model
 * Create user(Post) : https://petstore.swagger.io/v2/user
 * Get user (Get) : https://petstore.swagger.io/v2/user/{username}
 * Update user (Put) : https://petstore.swagger.io/v2/user/{username}
 * Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}
 * 
 * Store_module
 * Place an order (Post):https://petstore.swagger.io/v2/store/order
 * Find purchase order by ID(Get) :https://petstore.swagger.io/v2/store/order/{id}
 * Delete purchase order by ID(Delete):https://petstore.swagger.io/v2/store/order/{id} 
 * 
 */


public class Routes {
	//petStore 
public static String base_url="https://petstore.swagger.io/v2";

//user module
public static String post_url=base_url+"/user";
public static String get_url=base_url+"/user/{username}";
public static String update_url=base_url+"/user/{username}";
public static String delete_url=base_url+"/user/{username}";

//store module
public static String store_post_url=base_url+"/store/order";
public static String store_get_url=base_url+"/store/order/{id}";
public static String store_delete_url=base_url+"/store/order/{id}";

//Store model

// Here add store URL's

//Pet model
// here add pet URL's 

}
