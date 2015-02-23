package com.aloknath.restraurant_app.Activities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.aloknath.restraurant_app.R;

import java.io.IOException;
import java.io.InputStream;


/**
 * Created by ALOKNATH on 2/23/2015.
 */
public class SplashScreenActivity extends Activity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        ImageView view = (ImageView)findViewById(R.id.imageView);
        try
        {
            // get input stream
            InputStream ims = getAssets().open("restaurant.jpg");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            //view.setBackground(d);

            //this.findViewById(android.R.id.content).setBackground(d);
            view.setImageDrawable(d);
            view.setScaleType(ImageView.ScaleType.FIT_XY);

        }catch(IOException ex)
        {
            return;
        }

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
                SplashScreenActivity.this.startActivity(mainIntent);
                SplashScreenActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
