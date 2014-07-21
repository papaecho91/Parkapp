package com.parkpkg.parkapp;

import java.net.URL;

/**
 * @author Patrik
 *
 */
public class ParkingService {
	static final String host =
			"http://data.goteborg.se/ParkingService/v2.0/PublicTollParkings" +
			"/%7B57217002-37bb-43ce-8867-69a9b01cf6e9%7D?" +
			"latitude={LATITUDE}&" +
			"longitude={LONGITUDE}&" +
			"radius={RADIUS}&f" +
			"ormat=json";
	
	
	public void ParkingData(){
		URL url = new URL();
	}

}
