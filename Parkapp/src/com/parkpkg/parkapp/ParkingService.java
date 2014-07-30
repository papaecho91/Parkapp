/**
 * MainActivity.java 2014-07-16
 * Copyright 
 */

package com.parkpkg.parkapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;







/**
 * @author 
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
	 * This method will download the data from the URL formatted in JSON  
	 * 
	 * @return JSONObject
	 *  
	 */
	
	public Parking[] getParkingArray() {

		String data = null;
		JSONObject jsondata = new JSONObject();
		JSONArray jsonarray = new JSONArray();
		JSONObject jsonobject = new JSONObject();
		String name = null;

		try{
			URL url = new URL(privateTollParkings);
			try{
				URLConnection connect = url.openConnection();
				BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
				
				URLConnection connection = new URL(url.toString()).openConnection();
				BufferedReader reader = new BufferedReader(new InputStreamReader(
						connection.getInputStream()), 1024 * 16);
				
				data = reader.readLine();
				reader.close();
				
				try {
					jsonarray = new JSONArray(data);
					
					//jsonobject = jsonarray.getJSONObject(5);
					Parking[] parkings = new Parking[jsonarray.length()];

					for (int i = 0; i < jsonarray.length(); i++) {
						parkings[i] = new Parking(jsonarray.getJSONObject(i));
					}

					return parkings;
					
				} catch (JSONException e) {
					Log.i(TAG, "JSONException");
					e.printStackTrace();
				}//JSON
				

			}catch (IOException e){
				Log.i(TAG, "IOException");
				e.printStackTrace();
			}//IO
			
		}catch (MalformedURLException e){
			Log.i(TAG, "MalformedURLException");
			e.printStackTrace();
		}//URL
		

		
		Log.i(TAG, "----------ParkingService-----------");
		return new Parking[0];

		


	}
	
	


	
	

		


}
