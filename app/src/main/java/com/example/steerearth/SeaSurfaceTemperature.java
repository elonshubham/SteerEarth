package com.example.steerearth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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

public class SeaSurfaceTemperature extends AppCompatActivity {
    WorldWindow wwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.worldexplore);
        this.setTitle("Aerosol Optical Thickness");


        // Create a WorldWindow (a GLSurfaceView)...
        wwd = new WorldWindow(SeaSurfaceTemperature.this);
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
        FrameLayout globeLayout = (FrameLayout) findViewById(R.id.globe2);
        globeLayout.addView(wwd);

        LayerFactory layerFactory = new LayerFactory();

        // Create an OGC Web Map Service (WMS) layer to display the
        // surface temperature layer from NASA's Near Earth Observations WMS.
        layerFactory.createFromWms(
                "https://neo.sci.gsfc.nasa.gov/wms/wms", // WMS server URL
                "AVHRR_CLIM_M",                         // WMS layer name
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
        );
    }

    public void onResume() {
        super.onResume();
        wwd.onResume(); // resumes a paused rendering thread
    }

    /**
     * Pauses the WorldWindow's rendering thread
     */
    @Override
    public void onPause() {
        super.onPause();
        wwd.onPause(); // pauses the rendering thread
    }
}
