/**
 * MainActivity.java 2014-07-16
 * Copyright 
 */

package com.parkpkg.parkapp;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

/**
 * 
 * @author 
 * @version 0.0.2
 * 
 * This is the MainActivity class with the map fragment
 * It connects to google play and sets up the google map.
 */

public class MainActivity extends Activity {



	public GoogleMap googleMap;
	
	private static final String TAG = "MainActivity";
	private static final String TAG1 = "Parkingdata";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Draw google map only if connected to google play
        if(connectionToGooglePlay()){
        	

            //  This if-statement makes sure I can run network code in
            //  the UI thread

        	if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy = 
                        new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                }
        	
        	setContentView(R.layout.activity_main);
        	setUpMapIfNeeded();       	
        	Log.i(TAG, "--------MainActivity-------");
    		
        	
            ParkingService ps = new ParkingService();
            Parking parking = new Parking(ps.getAllParkings());

            double dlatlng = parking.getLng() + parking.getLat();
            
            Log.i(TAG1, parking.getName());
            

            
    		




        }
        
    }
    
    /**
     * Test connection between the app and Google Play
     * @return boolean
     */
    private boolean connectionToGooglePlay(){
    	int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
    	if(status == ConnectionResult.SUCCESS){
    		return true;
    	}else{
    		((Dialog) GooglePlayServicesUtil.getErrorDialog(status,this,10)).show();
    	}return false;
    		
    		
    }
    

    
    /**
     * This method is used to make sure we can interact and customize the map
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            
            /** 
             * Check if we were successful in obtaining the map.
             * If it works, we can start using the map
             */
            if (googleMap != null) {
            	getLocation();


            }
        }
    }
    
    private void getLocation(){
    	// Get my current location
    	googleMap.setMyLocationEnabled(true);
    	
    	LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
    	String provider = lm.getBestProvider(new Criteria(), true);
    	Location pos = lm.getLastKnownLocation(provider);
    	
        
		ParkingService ps = new ParkingService();
        Parking parking = new Parking(ps.getAllParkings());
		
        LatLng latlng = new LatLng(pos.getLatitude(), pos.getLongitude());
        LatLng parkpos = new LatLng(parking.getLat(),parking.getLng());
		
        googleMap.addMarker(new MarkerOptions().position(parkpos).title(parking.getItems()));	
		googleMap.addMarker(new MarkerOptions().position(latlng).title("Home"));
		
		googleMap.moveCamera(CameraUpdateFactory.newLatLng(parkpos));
		googleMap.animateCamera(CameraUpdateFactory.zoomTo(13));
		
    }
    
    
    
}