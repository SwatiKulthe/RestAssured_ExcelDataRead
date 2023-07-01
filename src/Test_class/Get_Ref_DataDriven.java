package Test_class;

import java.io.IOException;
import Common_Methods.Common_Utility_Method;
import Common_Methods.Get_Method;
import Request_Repository.Get_Req_Repository;

public class Get_Ref_DataDriven {
	public static void extractor() throws IOException {
		for (int i = 0; i < 5; i++) {
			int StatusCode = Get_Method.ResponseStatusCode(Get_Req_Repository.baseURI(),
					Get_Req_Repository.Get_Resource());
			System.out.println(StatusCode);
			if (StatusCode == 200) {
				System.out.println(StatusCode);
				String ResponseBody = Get_Method.ResponseBody(Get_Req_Repository.baseURI(),
						Get_Req_Repository.Get_Resource());
				System.out.println(ResponseBody);
				Common_Utility_Method.EvidanceCreator("Get_Ref_Evidance", null, StatusCode, ResponseBody);
				break;
			}
		}

	}
}