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


/*osmdroid lets us use other maps apart from google street map


this needfs to be added to the build.gradle(module.app)
with the code:
dependencies {
======other dependencies
compile 'org.osmdroid:osmdroid-android:5.6.5@aar'

}

 */
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

    MapView mp;

//@override forces you to deal with the oncreate. Its like a comment but with an error alet
    @Override

    //onCreate loads when the app is first created
    public void onCreate(Bundle savedInstanceState)
    {
        //super lets us use the methods from the parent oncreate. In this case savedInstanceState
        //savedInstanceState lets the app save its state while the app is in the background or is
        // going through a orientation change
        super.onCreate(savedInstanceState);
        // This line sets the user agent, a requirement to download OSM maps

        /*Configuration.getInstance():
         gets the current reference to the config provider.
         if one hasn't been set yet,
         the default provider and default configuration will be used
         */
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));


        setContentView(R.layout.activity_main);

        mp = (MapView)findViewById(R.id.map1);
        mp.setBuiltInZoomControls(true);
        //set the zoom level to 16 with 1 being the whole world. 16 is around 2.5 meters per pixal
        mp.getController().setZoom(16);
        //sets where on the world we are looking. This is unaffected by zoom
        mp.getController().setCenter(new GeoPoint(51.05,-0.72));
    }


    public boolean onCreateOptionsMenu(Menu choosemenu){

        //whats the point of this?
        MenuInflater inflater=getMenuInflater();
        //R.menu.menu: The first menu is talking about the menu folder, the second menu
        // is talking about the menu.xml
        inflater.inflate(R.menu.menu, choosemenu);
        return true;
    }
}
