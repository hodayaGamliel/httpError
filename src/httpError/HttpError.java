package httpError;

import javax.xml.ws.http.HTTPException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpError 
{
	public static void main(String[] args) 
	{
		
		test();
	}
	
	public static String getHTML(String urlToRead) throws Exception {
	      StringBuilder result = new StringBuilder();
	      URL url = new URL(urlToRead);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      String line;
	      while ((line = rd.readLine()) != null) {
	         result.append(line);
	      }
	      rd.close();
	      return result.toString();
	   }
	
	public static void test()
	{
		try 
		{
		    System.out.println(getHTML("http://localhost:8080/"));	 
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
