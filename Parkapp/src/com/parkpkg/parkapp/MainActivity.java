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

public class MainActivity extends Activity implements LocationListener{

	// instance variables

	private GoogleMap googleMap;
	
	
	
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
            
            // Check if we were successful in obtaining the map.
            if (googleMap != null) {
                
            	googleMap.setMyLocationEnabled(true);
            	LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
            	String provider = lm.getBestProvider(new Criteria(), true);
            	
            	if (provider == null) {
            		onProviderDisabled(provider);
            	}
            	
            	Location loc = lm.getLastKnownLocation(provider);
            	if(loc != null){
            		onLocationChanged(loc);
            	}

            }
        }
    }
	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub
		LatLng latLng = new LatLng(57.7000, 11.9667);
		
		googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
		googleMap.animateCamera(CameraUpdateFactory.zoomTo(10));
	}
	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}
    

}