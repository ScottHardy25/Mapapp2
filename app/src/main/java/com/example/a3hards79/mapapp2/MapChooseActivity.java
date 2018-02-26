package com.example.a3hards79.mapapp2;

/**
 * Created by 3hards79 on 26/02/2018.
 */


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;

//for the buttons to work we need to implement the onclicklistener
public class MapChooseActivity extends AppCompatActivity implements View.OnClickListener{


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //accecss letschooseamap.xml and lays it out as it is set
        setContentView(R.layout.letschooseamap);

        // make a button called regular and on that button
        Button regular = (Button)findViewById(R.id.btnRegular);
        regular.setOnClickListener(this);

        Button hikebikemap = (Button)findViewById(R.id.btnHikeBikeMap);
        hikebikemap.setOnClickListener(this);

    }

    public void onClick(View v){

        //set up a intent, bundle and a boolen hikebike
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        boolean hikebikemap = false;

        //checks to see if the button that was clicked was the hikebike button
        if (v.getId() == R.id.btnHikeBikeMap){
            hikebikemap = true ;
        }

        // put hikebike into a bundle
        // the first "" if to give it a unique name, because bundles can be passed across different apps
        bundle.putBoolean("com.example.a3hards79.mapapp2.hikebiketest",hikebikemap);
        //putExtra and putExtras are diffrent!
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();

    }



}

