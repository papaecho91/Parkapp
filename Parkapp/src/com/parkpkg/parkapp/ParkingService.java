package com.parkpkg.parkapp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.util.Log;
import android.widget.Toast;

/**
 * @author 
 *
 */
public class ParkingService {
	
	private static final String TAG = "ParkingService";
	
	//Instance variables for URL
	static final String publicTollParkings =
			"http://data.goteborg.se/ParkingService/v2.0/PublicTollParkings" +
			"/%7B57217002-37bb-43ce-8867-69a9b01cf6e9%7D?" +
			"latitude={LATITUDE}&" +
			"longitude={LONGITUDE}&" +
			"radius={RADIUS}&f" +
			"ormat=json";
	static final String privateTollParkings =
			"http://data.goteborg.se/ParkingService/v2.1/PrivateTollParkings" +
					"/%7B57217002-37bb-43ce-8867-69a9b01cf6e9%7D?" +
					"latitude={LATITUDE}&" +
					"longitude={LONGITUDE}&" +
					"radius={RADIUS}&f" +
					"ormat=json";
	/**
	 * 
	 * @return line
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public String getAllParkings() throws Exception{
		String data = null;
		try{
			URL url = new URL("http://www.google.se");
			try{
				URLConnection connect = url.openConnection();
				BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
				data = in.readLine();
			}catch (IOException e){
				e.printStackTrace();
			}
			

		}catch (MalformedURLException e){
			e.printStackTrace();
		}
		return data;
		
//		BufferedReader in = null;
//		String data = null;
//		String line;
//		String newLine = System.getProperty("line.separator");
//		try{
//			HttpClient client = new DefaultHttpClient();
//			URI website = new URI("http://www.google.se");
//			HttpGet request = new HttpGet();
//			request.setURI(website);
//			HttpResponse response = client.execute(request);
//			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//			StringBuffer sb = new StringBuffer("");
//			
//			while((line = in.readLine()) !=null){
//				sb.append(line+newLine);
//			}
//			in.close();
//			data = sb.toString();
//			return data;
//		}finally{
//			if(in !=null){
//				try{
//					in.close();
//					return data;
//				}catch (Exception e){
//					e.printStackTrace();
//				}
//			}
//		}
	}

		


}
