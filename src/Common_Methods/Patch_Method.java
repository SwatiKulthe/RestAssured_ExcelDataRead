package Common_Methods;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class Patch_Method {
	public static int ResponseStatusCode (String BaseURI, String Resource, String RequestBody) {
		RestAssured.baseURI = BaseURI;
		
		int StatusCode = given().header("Content-Type","application/json").body(RequestBody).
				when().patch(Resource).then().extract().statusCode();
		return StatusCode;
	}
	
	public static String ResponseBody (String BaseURI, String Resource, String RequestBody) {
		RestAssured.basePath = BaseURI;
		
		String ResponseBody =given().header("Content-Type","application/json").body(RequestBody).
				when().patch(Resource).then().extract().response().asString();
		return ResponseBody;

}
}