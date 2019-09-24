package api.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import api.call.ApiCalls;
import api.call.TextFileReader;
/**
 * 
 * @author Ayaz Shahid (ayazhamiya@gmail.com)
 *
 */
public class MainTest {
	@Test(dataProvider="getData")
	public void ApiTest(String url1, String url2) {
	  ApiCalls apiCall = new ApiCalls(url1, url2);
	  try {
		  Assert.assertTrue(apiCall.isEqual(), "URIs response is not equal");
	  }
	  catch(AssertionError e) {
		  e.setStackTrace(new StackTraceElement[0]);
		  throw e;
	  } 
  }
	
	@DataProvider
    public Object[][] getData() throws IOException {
       TextFileReader fReader = new TextFileReader();
       return fReader.readFileData();
    }
}
