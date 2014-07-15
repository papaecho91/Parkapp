package com.parkpkg.parkapp;

import com.google.android.gms.maps.GoogleMap;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	
	private GoogleMap mMap;

	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

}