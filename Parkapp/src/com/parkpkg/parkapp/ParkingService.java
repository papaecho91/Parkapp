package com.parkpkg.parkapp;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.util.Log;

/**
 * @author Patrik
 *
 */
public class ParkingService {
	
	//Instance variables for URL
	static final String PublicTollParkings =
			"http://data.goteborg.se/ParkingService/v2.0/PublicTollParkings" +
			"/%7B57217002-37bb-43ce-8867-69a9b01cf6e9%7D?" +
			"latitude={LATITUDE}&" +
			"longitude={LONGITUDE}&" +
			"radius={RADIUS}&f" +
			"ormat=json";
	static final String PrivateTollParkings =
			"http://data.goteborg.se/ParkingService/v2.1/PrivateTollParkings" +
					"/%7B57217002-37bb-43ce-8867-69a9b01cf6e9%7D?" +
					"latitude={LATITUDE}&" +
					"longitude={LONGITUDE}&" +
					"radius={RADIUS}&f" +
					"ormat=json";
	
	/**
	 * Create connection and parse the data
	 * @return 
	 * @throws MalformedURLException, IOException
	 */
	public String ParkingData() throws MalformedURLException, IOException{

	    InputStream is = null;
	    // Only display the first 500 characters of the retrieved
	    // web page content.
	    int len = 500;
	        
	    try {
	        URL url = new URL(PublicTollParkings);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setReadTimeout(10000 /* milliseconds */);
	        conn.setConnectTimeout(15000 /* milliseconds */);
	        conn.setRequestMethod("GET");
	        conn.setDoInput(true);
	        // Starts the query
	        conn.connect();
//	        int response = conn.getResponseCode();
//  	    Log.d(DEBUG_TAG, "The response is: " + response);
	        is = conn.getInputStream();


	        // Convert the InputStream into a string
	        String contentAsString = readIt(is, len);
	        System.out.println(contentAsString);
	        return contentAsString;
	        
	    // Makes sure that the InputStream is closed after the app is
	    // finished using it.
	    } finally {
	        if (is != null) {
	            is.close();
	        } 
	    }

	}
	// Reads an InputStream and converts it to a String.
	public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
	    Reader reader = null;
	    reader = new InputStreamReader(stream, "UTF-8");        
	    char[] buffer = new char[len];
	    reader.read(buffer);
	    return new String(buffer);
	}

}
