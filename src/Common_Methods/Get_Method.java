package Common_Methods;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;

public class Get_Method {
public static int ResponseStatusCode(String BaseURI, String Resource) {
		
		RestAssured.baseURI = BaseURI;
		
		int StatusCode = given().header("Content-type","Application/json").body("RequestBody").
				when().get(Resource).then().extract().statusCode();
		return StatusCode;
	}
	
	public static String ResponseBody(String BaseURI, String Resource) {
		
		RestAssured.baseURI = BaseURI;
		
		String ResponseBody = given().header("Content-type","Application/json").body("RequestBody").
				when().get(Resource).then().extract().response().asString();
		return ResponseBody;
	}

}
