package com.example.a3hards79.mapapp2;


//let us run on older andirods then the current sdk
import android.support.v7.app.AppCompatActivity;
// intent and bundle are for passing
import android.content.Intent;
import android.os.Bundle;
//access preferences app
import android.preference.PreferenceManager;
//work with other screens
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


//osmdroid lets us use other maps apart from google street map
import org.osmdroid.config.Configuration;
//access a database that holds each map tile
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
//lat and long, maybe ?hight?
import org.osmdroid.util.GeoPoint;
//lets you see the map
import org.osmdroid.views.MapView;


//imports and uses appcompat or we wouldnt be able to run on older apks
//will make new methords to let older phones run the app. But adds size to the app regardess
public class MainActivity extends AppCompatActivity {

    //stores an object with the type of mapview called mp;

    Mapview mp;

//@override forces you to deal with the oncreate. Its like a comment but with an error alet
    @Override

    //onCreate loads when the app is first created 
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // This line sets the user agent, a requirement to download OSM maps
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

        setContentView(R.layout.activity_main);

        mv = (MapView)findViewById(R.id.map1);
        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(16);
        mv.getController().setCenter(new GeoPoint(51.05,-0.72));
    }
}
