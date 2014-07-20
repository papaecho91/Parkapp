/**
 * MainActivity.java 2014-07-16
 * Copyright Patrik Evertsson
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
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

/**
 * 
 * @author Patrik Evertsson
 * @version 0.0.2
 *
 */

public class MainActivity extends Activity {

	// instance variables

	public GoogleMap googleMap;
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(connectionToGooglePlay()){
        	setContentView(R.layout.activity_main);
        	setUpMapIfNeeded();
        }
        
    }
    /**
     * Test connection between the app and Google Play
     * @return true if the connection works, false it displays a dialog with the error
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

    	LatLng latlng = new LatLng(pos.getLatitude(), pos.getLongitude());
		googleMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
		googleMap.animateCamera(CameraUpdateFactory.zoomTo(13));
		
		googleMap.addMarker(new MarkerOptions().position(latlng).title("Home"));
		
    }
}