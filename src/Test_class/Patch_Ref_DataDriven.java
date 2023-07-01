package Test_class;

import java.io.IOException;
import org.testng.Assert;
import Common_Methods.Common_Utility_Method;
import Common_Methods.Patch_Method;
import Request_Repository.Patch_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Patch_Ref_DataDriven {
	public static void extractor() throws IOException {
		for (int i = 0; i < 5; i++) {
			int StatusCode = Patch_Method.ResponseStatusCode(Patch_Req_Repository.baseURI(),
					Patch_Req_Repository.Patch_Resource(), Patch_Req_Repository.Patch_Req_TC1());
			System.out.println(StatusCode);
			if (StatusCode == 200) {
				System.out.println(StatusCode);
				String ResponseBody = Patch_Method.ResponseBody(Patch_Req_Repository.baseURI(),
						Patch_Req_Repository.Patch_Resource(), Patch_Req_Repository.Patch_Req_TC1());
				System.out.println(ResponseBody);
				Common_Utility_Method.EvidanceCreator("Patch_Ref_Evidance", Patch_Req_Repository.Patch_Req_TC1(),
						StatusCode, ResponseBody);
				Patch_Ref_DataDriven.Validator(Patch_Req_Repository.Patch_Req_TC1(), ResponseBody);
				break;
			}
		}

	}

	public static void Validator(String RequestBody, String ResponseBody) {
		// parse responsebody
		JsonPath JspResponse = new JsonPath(ResponseBody);
		String Res_name = JspResponse.getString("name");
		String Res_job = JspResponse.getString("job");
		// validate responsebody
		Assert.assertEquals(Res_name, "morpheus");
		Assert.assertEquals(Res_job, "zion resident");
	}
}
