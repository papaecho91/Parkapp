package com.parkpkg.parkapp;

import java.io.Serializable;
import org.json.JSONObject;

/*
 * Represents a parking lot
 */
public class Parking implements  Serializable{

	private static final long serialVersionUID = 5903081263978771481L;
	
	private String id;
	private String name;
	private String owner;
	private int phoneParkingCode;
	private int freeSpaces;	
	private double lng;
	private double lat;
	private int parkingSpaces;
	private String extraInfo;	
	private int currentParkingCost;
	private String parkingCost;
	private String residentialParking;	
	private int parkingSpaceCount;
	private int parkableLength;
	private String maxParking;

	
	public Parking() {

	}

	/*
	 * 
	 */
	public Parking(JSONObject json) {
		
		id = json.optString("Id");
		name = json.optString("Name");
		owner = json.optString("Owner");
		phoneParkingCode = json.optInt("PhoneParkingCode");
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
	
	public String getName() {
		return name;
	}

	public String getOwner(){
		return owner;
	}
	
	public int getPhoneParkingCode(){
		return phoneParkingCode;
	}
	
	public int getFreeSpaces() {
		return freeSpaces;
	}

	public int getParkableLength() {
		return parkableLength;
	}
	
	public double getLat() {
		return lat;
	}
	
	public double getLng() {
		return lng;
	}

	public int getParkingSpaces() {

		return parkingSpaces;
	}
	
	public String getExtraInfo() {
		return extraInfo;
	}
	
	public int getCurrentParkingCost() {
		return currentParkingCost;
	}
	
	public String getParkingCost() {

		return parkingCost;
	}
	
	public int getParkingSpaceCount() {

		return parkingSpaceCount;
	}

	public String getResidentialParking() {
		return residentialParking;
	}
	
	public String getMaxParking() {
		return maxParking;
	}
	
	
	public void setLng(float lng) {
		this.lng = lng;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	
	
	public String getAllAttr(){
		return getId() + getExtraInfo() + getParkableLength() +
				getParkingSpaces() + getParkingSpaceCount() +
				getFreeSpaces() + getParkingCost() + getLng() +
				getCurrentParkingCost() + getResidentialParking() +
				getResidentialParking() + getLat() + getName() +
				getMaxParking();
				
	}
	
	public String getItems(){
		if(getFreeSpaces() == 0){
			return getName()
					+"\nBolag: "+getOwner()
					+ "\nAntal platser: "+getParkingSpaces() 
					+ "\nTelefonkod: "+getPhoneParkingCode()
					+ "\nKostnad: "+getCurrentParkingCost() +"kr"
					;
		}else {
			return getName()
					+"\nBolag: "+getOwner()
					+"\nAntal platser: "+getParkingSpaces()
					+"\nSpacecount"+getParkingSpaceCount()
					+"\nLediga platser: "+getFreeSpaces()
					+"\nTelefonkod: "+getPhoneParkingCode()
					+"\nKostnad: "+getCurrentParkingCost() +"kr"
					;
		}
	}
	
	public double getLatLng(){
		return getLat() + getLng();
	}
}

	//Id: Unikt id för parkeringen, om det är en kommunal parkering är det dess LTF-nummer
	//Name: Namn på parkeringen, oftast en adress eller namnet på P-huset
	//Owner: Anger vem som äger parkeringen, mer information om ägaren kan fås via metoden ParikingOwners
	//FreeSpaces: Antal ledig platster just nu
	//FreeSpacesDate: När antal lediga platser senast uppdaterades
	//ParkingSpaces: Totalt antal parkeringsplatser
	//ParkableLength: Antal meter fickparkeringar
	//ParkingSpaceCount: Antal P-rutor
	//PhoneParkingCode: Telefonparkeringskod (fr.o.m. v2.0)
	//ParkingCharge: Taxa
	//ParkingCost: Kostnad i klartext
	//CurrentParkingCost: Kostnad per timme att parkera just nu
	//MaxParkingTime: Max tillåten P-tid
	//MaxParkingTimeLimitation: Ytterligare villkor till max tillåten P-tid
	//ResidentialParkingArea: Boendeparkering, t.ex M4
	//ExtraInfo: Övrig info, t.ex. städzon mm
	//Distance: Avstånd i meter från aktuell position (returneras endast om egen position skickats in)
	//Lat: Latitud i WGS84
	//Long: Longitud i WGS84
