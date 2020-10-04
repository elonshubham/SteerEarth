package com.example.steerearth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import gov.nasa.worldwind.WorldWindow;
import gov.nasa.worldwind.geom.Sector;
import gov.nasa.worldwind.layer.BackgroundLayer;
import gov.nasa.worldwind.layer.BlueMarbleLandsatLayer;
import gov.nasa.worldwind.layer.BlueMarbleLayer;
import gov.nasa.worldwind.layer.Layer;
import gov.nasa.worldwind.layer.LayerFactory;
import gov.nasa.worldwind.ogc.WmsLayer;
import gov.nasa.worldwind.ogc.WmsLayerConfig;

public class MainActivity extends AppCompatActivity {
    WorldWindow wwd;
    CardView mgeneralcard;
    CardView mcustomcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mgeneralcard=findViewById(R.id.generalcard);
        mcustomcard=findViewById(R.id.customcard);

        mgeneralcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent announcementclickintent =new Intent(MainActivity.this,TopicChooser.class);
                startActivity(announcementclickintent);
            }
        });



        //CollapsingToolbarLayout mcollapsingtoolbarlayout=findViewById(R.id.collapsing_toolbar);
        //mcollapsingtoolbarlayout.setExpandedTitleColor(Color.TRANSPARENT);
        //mcollapsingtoolbarlayout.setTitle("STEER EARTH");
        //mcollapsingtoolbarlayout.setCollapsedTitleTextColor(Color.WHITE);

        // Create a WorldWindow (a GLSurfaceView)...
        /*wwd = new WorldWindow(MainActivity.this);
// ... and add some map layers
       wwd.getLayers().addLayer(new BackgroundLayer());
       wwd.getLayers().addLayer(new BlueMarbleLayer());



        /*WmsLayerConfig config = new WmsLayerConfig();
        config.serviceAddress = "http://neowms.sci.gsfc.nasa.gov/wms/wms";
        config.wmsVersion = "1.1.1"; // NEO server works best with WMS 1.1.1
        config.layerNames = "MOD14A1_M_FIRE"; // Sea surface temperature (MODIS)
        WmsLayer layer = new WmsLayer(new Sector().setFullSphere(), 1e3, config); // 1km resolution

        // Add the WMS layer to the WorldWindow.
        wwd.getLayers().addLayer(layer);*/
        //FrameLayout globeLayout = (FrameLayout) findViewById(R.id.globe);
        //globeLayout.addView(wwd);

       /* LayerFactory layerFactory = new LayerFactory();

        // Create an OGC Web Map Service (WMS) layer to display the
        // surface temperature layer from NASA's Near Earth Observations WMS.
        layerFactory.createFromWms(
                "https://neo.sci.gsfc.nasa.gov/wms/wms", // WMS server URL
                "MOD14A1_M_FIRE",                         // WMS layer name
                new LayerFactory.Callback() {
                    @Override
                    public void creationSucceeded(LayerFactory factory, Layer layer) {
                        // Add the finished WMS layer to the WorldWindow.
                        wwd.getLayers().addLayer(layer);

                    }

                    @Override
                    public void creationFailed(LayerFactory factory, Layer layer, Throwable ex) {
                        // Something went wrong connecting to the WMS server.
                        Log.e("gov.nasa.worldwind", "WMS layer creation failed", ex);
                    }
                }
        );*/
    }


}