package Test_class;

import java.io.IOException;

import org.testng.Assert;

import Common_Methods.Common_Utility_Method;
import Common_Methods.Post_Method;
import Request_Repository.Post_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Post_Ref_DataDriven {
	public static void extractor() throws IOException
	{
		for(int i=0; i<5; i++)
		{
			int StatusCode =Post_Method.ResponseStatusCode(Post_Req_Repository.BaseURI(),Post_Req_Repository.Post_Resource(),Post_Req_Repository.RequestBody());
			
			if(StatusCode == 201)
			{
				System.out.println(StatusCode);
				String ResponseBody = Post_Method.ResponseBody(Post_Req_Repository.BaseURI(),Post_Req_Repository.Post_Resource(),Post_Req_Repository.RequestBody());
				System.out.println(ResponseBody);
				Common_Utility_Method.EvidanceCreator("Post_Ref_Evidance",Post_Req_Repository.RequestBody(), StatusCode, ResponseBody);
				Post_Ref_DataDriven.validator(Post_Req_Repository.RequestBody(), ResponseBody);
				break;
			}
		}
	}
	
    public static void validator(String RequestBody, String ResponseBody) throws IOException
    {
    	//declare expected result
    			JsonPath JspRequest = new JsonPath(Post_Req_Repository.RequestBody());
    			String Req_name = JspRequest.getString("name");
    			String Req_job = JspRequest.getString("job");
    			//parse ResponseBody
    			JsonPath JspResponse = new JsonPath(ResponseBody);
    			String Res_name = JspResponse.getString("name");
    			String Res_job = JspResponse.getString("job");
    			//validation
    			Assert.assertEquals(Res_name, Req_name);
    			Assert.assertEquals(Res_job, Req_job);
    }
}
