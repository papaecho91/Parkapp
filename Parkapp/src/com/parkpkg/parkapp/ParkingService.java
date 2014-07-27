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
	
	public JSONObject getAllParkings() {
		String data = null;
		JSONObject json = new JSONObject();
		JSONArray jsonarray = new JSONArray();
		String jsonobject = null;

		try{
			URL url = new URL(publicTollParkings);
			try{
				URLConnection connect = url.openConnection();
				BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
				data = in.readLine();
				in.close();
				
				try {
					jsonarray = json.getJSONArray(data);
					json = jsonarray.getJSONObject(0);

				} catch (JSONException e) {
					Log.i(TAG, "JSONException");
					e.printStackTrace();
				}//JSON

			}catch (IOException e){
				e.printStackTrace();
			}//IO
			
		}catch (MalformedURLException e){
			e.printStackTrace();
		}//URL
		

		
		
		

		return json;


	}
	
	
//	Id: Unikt id för parkeringen, om det är en kommunal parkering är det dess LTF-nummer
//	Name: Namn på parkeringen, oftast en adress eller namnet på P-huset
//	Owner: Anger vem som äger parkeringen, mer information om ägaren kan fås via metoden ParikingOwners
//	FreeSpaces: Antal ledig platster just nu
//	FreeSpacesDate: När antal lediga platser senast uppdaterades
//	ParkingSpaces: Totalt antal parkeringsplatser
//	ParkableLength: Antal meter fickparkeringar
//	ParkingSpaceCount: Antal P-rutor
//	PhoneParkingCode: Telefonparkeringskod (fr.o.m. v2.0)
//	ParkingCharge: Taxa
//	ParkingCost: Kostnad i klartext
//	CurrentParkingCost: Kostnad per timme att parkera just nu
//	MaxParkingTime: Max tillåten P-tid
//	MaxParkingTimeLimitation: Ytterligare villkor till max tillåten P-tid
//	ResidentialParkingArea: Boendeparkering, t.ex M4
//	ExtraInfo: Övrig info, t.ex. städzon mm
//	Distance: Avstånd i meter från aktuell position (returneras endast om egen position skickats in)
//	Lat: Latitud i WGS84
//	Long: Longitud i WGS84

	
	

		


}
