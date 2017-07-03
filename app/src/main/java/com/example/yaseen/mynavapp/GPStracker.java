package com.example.yaseen.mynavapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import android.widget.Toast;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by yaseen on 6/30/2017.
 */

public class GPStracker implements LocationListener {


    Context context;

    public GPStracker(Context c) {

        context = c;
    }


    public GPStracker() {
        super();
    }


    public Location getlocation() {


        if(ContextCompat.checkSelfPermission(context,Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){


            Toast.makeText(context, "Permission not Granted", Toast.LENGTH_SHORT).show();
            return null;


        }


        LocationManager lm = (LocationManager) context.getSystemService(context.LOCATION_SERVICE);


        boolean isGPSEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (isGPSEnabled) {




            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);


            Location l = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            return l;


        }

        else{

            Toast.makeText(context, "Please enable GPS", Toast.LENGTH_LONG).show();
        }



          return  null;

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
