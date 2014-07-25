/**
 * MainActivity.java 2014-07-16
 * Copyright Patrik Evertsson
 */

package com.parkpkg.parkapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;



/**
 * @author Patrik Evertsson
 *
 * This class is used to download JSON data from a URL
 * and return the JSON data formatted as a string.
 * 
 */
public class ParkingService {
	
	private static final String TAG = "ParkingService";
	
	/**
	 * Final variables for URL from JSON source
	 * These URL can be customized. In this early version I choose not to.
	 * Just to keep it simple. The second row of this URL or String is the APPID
	 * from data.goteborg.se. The other variables of the URL (lat,long,radius,format) is optional.
	 *
	 */
	
	static final String publicTollParkings =
			"http://data.goteborg.se/ParkingService/v2.0/PublicTollParkings" +
				"/%7B57217002-37bb-43ce-8867-69a9b01cf6e9%7D?" +
				"latitude={LATITUDE}&" +
				"longitude={LONGITUDE}&" +
				"radius={RADIUS}&" +
				"format=json";
	
	static final String privateTollParkings =
			"http://data.goteborg.se/ParkingService/v2.1/PrivateTollParkings" +
					"/%7B57217002-37bb-43ce-8867-69a9b01cf6e9%7D?" +
					"latitude={LATITUDE}&" +
					"longitude={LONGITUDE}&" +
					"radius={RADIUS}&" +
					"format=json";
	
	
	/**
	 * This method will download the data from the URL formatted in JSON and 
	 * returned all JSON data in a string.
	 * @return String
	 */
	
	public String getAllParkings() {
		String data = null;
		try{
			URL url = new URL(publicTollParkings);
			try{
				URLConnection connect = url.openConnection();
				BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
				data = in.readLine();
				in.close();

			}catch (IOException e){
				e.printStackTrace();
			}
			
		}catch (MalformedURLException e){
			e.printStackTrace();
		}
		return data;
	}
	

		


}
