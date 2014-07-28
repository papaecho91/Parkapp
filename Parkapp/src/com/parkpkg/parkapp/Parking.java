package com.parkpkg.parkapp;

import java.io.Serializable;
import org.json.JSONObject;

/*
 * Represents a parking lot
 */
public class Parking implements  Serializable {

	private static final long serialVersionUID = 5903081263978771481L;
	private String id;
	private double lng;
	private double lat;
	private String name;
	private String maxParking;
	private int currentParkingCost;
	private String residentialParking;
	private int parkableLength;
	private String extraInfo;
	private int parkingSpaceCount;
	private int parkingSpaces;
	private int freeSpaces;
	private String parkingCost;


	public Parking() {

	}

	/*  */
	public Parking(JSONObject json) {
		
		id = json.optString("Id");
		name = json.optString("Name");
		freeSpaces = json.optInt("FreeSpaces");
		lat = json.optDouble("Lat");
		lng = json.optDouble("Long");
		parkingSpaces = json.optInt("ParkingSpaces");
		extraInfo = json.optString("ExtraInfo");
		currentParkingCost = json.optInt("CurrentParkingCost");
		parkingCost = json.optString("ParkingCost");
		residentialParking = json.optString("ResidentialParkingArea");
		parkingSpaceCount = json.optInt("ParkingSpaceCount");
		parkableLength = json.optInt("ParkableLength");
		maxParking = json.optString("MaxParkingTime");
		
	}


	public String getId() {
		return id;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public int getParkableLength() {
		return parkableLength;
	}

	public int getParkingSpaces() {

		return parkingSpaces;
	}

	public int getParkingSpaceCount() {

		return parkingSpaceCount;
	}

	public int getFreeSpaces() {

		return freeSpaces;
	}

	public String getParkingCost() {

		return parkingCost;
	}

	public double getLng() {
		return lng;
	}

	public int getCurrentParkingCost() {
		return currentParkingCost;
	}

	public String getResidentialParking() {
		return residentialParking;
	}


	public void setLng(float lng) {
		this.lng = lng;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public double getLat() {
		return lat;
	}

	public void setName(String name) {
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void setMaxParking(String maxParking) {
		this.maxParking = maxParking;

	}

	public String getMaxParking() {
		return maxParking;
	}
	
	public String getAllAttr(){
		return getId() + getExtraInfo() + getParkableLength() +
				getParkingSpaces() + getParkingSpaceCount() +
				getFreeSpaces() + getParkingCost() + getLng() +
				getCurrentParkingCost() + getResidentialParking() +
				getResidentialParking() + getLat() + getName() +
				getMaxParking();
				
	}
}
