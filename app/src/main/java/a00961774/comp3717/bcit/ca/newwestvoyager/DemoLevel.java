package a00961774.comp3717.bcit.ca.newwestvoyager;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DemoLevel extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // hide application title
        setContentView(R.layout.activity_demo_level);
        SupportMapFragment mapFragment = (SupportMapFragment) this.getSupportFragmentManager().findFragmentById(R.id.mapView);

        mapFragment.getMapAsync(this);
    }

    private boolean checkLocationPermission () {
        int res = getApplicationContext ().checkCallingOrSelfPermission ("android.permission.ACCESS_FINE_LOCATION");
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    @Override
    public void onMapReady (GoogleMap map) {
        LatLng sydney = new LatLng (-33.867, 151.206);

        if (!checkLocationPermission ()) {
           System.exit (1);
        }

        map.setMyLocationEnabled (true);
        map.moveCamera (CameraUpdateFactory.newLatLngZoom (sydney, 13));

        map.addMarker (new MarkerOptions ()
                .title   ("Sydney")
                .snippet ("The most populous city in Australia.")
                .position (sydney));

        map.addMarker (new MarkerOptions ()
           .position (new LatLng (10, 10))
           .title    ("Hello World"));
    }

    public void onClickMainMenu(final View view) {
        final Intent intent;
        intent = new Intent(getApplicationContext(), MainMenu.class);
        startActivity(intent);
    }
}
