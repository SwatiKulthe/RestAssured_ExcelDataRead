package Common_Methods;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class Post_Method {
	public static int ResponseStatusCode (String BaseURI, String Resource, String RequestBody)
	{
		RestAssured.baseURI= BaseURI;
		int StatusCode = given().header("Content-Type","application/json").body(RequestBody).when().post(Resource)
				.then().extract().statusCode();
		return StatusCode;
	}

	public static String ResponseBody(String BaseURI, String Resource, String RequestBody)
	{
		RestAssured.baseURI = BaseURI;
		String ResponseBody= given().header("Content-Type","application/json").body(RequestBody).when().post(Resource)
				.then().extract().response().asString();
		return ResponseBody;
	}
	
}
