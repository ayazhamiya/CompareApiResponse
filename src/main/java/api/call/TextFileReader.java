package api.call;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap; 
/**
 * 
 * @author Ayaz Shahid (ayazhamiya@gmail.com)
 *
 */
public class TextFileReader {
	
	private HashMap<Object, Object> urlHash;

	//default constructor
	public TextFileReader() {}
	
	public Object[][] readFileData() throws IOException {
		
		urlHash = new HashMap<Object, Object>();	
		String file1 = "src/main/resources/file1.txt";
		String file2 = "src/main/resources/file2.txt";
		BufferedReader url1Br = new BufferedReader(new FileReader(file1));
		BufferedReader url2Br = new BufferedReader(new FileReader(file2));

		while (true) {
		    String url1 = url1Br.readLine();
		    String url2 = url2Br.readLine(); 
		    if (url1 == null || url2 == null)
		        break;  
		    urlHash.put(url1, url2);
		}
		
		Object[][] twoDarray = new Object[urlHash.size()][2];
		Object[] keys = urlHash.keySet().toArray();
		Object[] values = urlHash.values().toArray();

		for (int row = 0; row < twoDarray.length; row++) {
		    twoDarray[row][0] = keys[row];
		    twoDarray[row][1] = values[row];
		}
	return twoDarray;
	}


}
