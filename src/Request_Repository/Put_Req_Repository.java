package Request_Repository;

import java.io.IOException;
import java.util.ArrayList;

import Common_Methods.Common_Utility_Method;

public class Put_Req_Repository {
	public static String baseURI() {
		String baseURI = "https://reqres.in/";
		return baseURI;
	}

	public static String Put_Resource() {
		String Put_Resource = "api/users/2";
		return Put_Resource;
	}
	
	public static String Put_Req_TC1() throws IOException {
		ArrayList<String> Req_Data = Common_Utility_Method.ReadDataExcel("Put_Ref", "TC1");
		// System.out.println(Req_Data);
		String Req_name = Req_Data.get(1);
		String Req_job = Req_Data.get(2);
		String RequestBody = "{\r\n" + "    \"name\": \"" + Req_name + "\",\r\n" + "    \"job\": \"" + Req_job
				+ "\"\r\n" + "}";
		return Put_Req_TC1();

}
}
