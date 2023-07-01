package Test_class;

import java.io.IOException;
import org.testng.Assert;
import Common_Methods.Common_Utility_Method;
import Common_Methods.Put_Method;
import Request_Repository.Put_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Put_Ref_DataDriven {
	public static void extractor() throws IOException {
		for (int i = 0; i < 5; i++) {
			int StatusCode = Put_Method.ResponseStatusCode(Put_Req_Repository.baseURI(),
					Put_Req_Repository.Put_Resource(), Put_Req_Repository.Put_Req_TC1());
			if (StatusCode == 200) {

				System.out.println(StatusCode);
				String ResponseBody = Put_Method.ResponseBody(Put_Req_Repository.baseURI(),
						Put_Req_Repository.Put_Resource(), Put_Req_Repository.Put_Req_TC1());
				System.out.println(ResponseBody);
				Common_Utility_Method.EvidanceCreator("Put_Ref_Evidance", Put_Req_Repository.Put_Req_TC1(), StatusCode,
						ResponseBody);
				Put_Ref_DataDriven.Validator(Put_Req_Repository.Put_Req_TC1(), ResponseBody);
				break;
			}
		}

	}

	public static void Validator(String RequestBody, String ResponseBody) throws IOException 
	{// parse responsebody
		JsonPath JspResponse = new JsonPath(Put_Req_Repository.Put_Req_TC1());
		String Res_name = JspResponse.getString("name");
		String Res_job = JspResponse.getString("job");
		// Validate responseBody
		Assert.assertEquals(Res_name, "morpheus");
		Assert.assertEquals(Res_job, "zion resident");
	}
}
