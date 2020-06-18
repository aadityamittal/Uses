import java.io.*;
import java.net.*;
public class Read{
	public static void main(String args[]) {
		try {
			URL url =new URL("https://www.google.com/");
			HttpURLConnection hurl=(HttpURLConnection)url.openConnection();
			if(hurl.getResponseCode()==200) {
				InputStream i=hurl.getInputStream();
				BufferedReader br=new BufferedReader(new InputStreamReader(i));
				String str=br.readLine();
				while(str!=null) {
					System.out.println(str);
					str=br.readLine();
				}
				br.close();
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
