package com.aloknath.restraurant_app.Activities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.GridView;

import com.aloknath.restraurant_app.Adapters.ButtonAdapter;
import com.aloknath.restraurant_app.CustomViews.CircleView;
import com.aloknath.restraurant_app.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ALOKNATH on 2/21/2015.
 */
public class FoodActivity extends Activity {



    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_layout);
        //circleView = (CircleView)findViewById(R.id.custCircleView);

        try
        {
            // get input stream
            InputStream ims = getAssets().open("food.jpg");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            this.findViewById(android.R.id.content).setBackground(d);
            //circleView.setBackground(d);
        }catch(IOException ex)
        {
            return;
        }

    }
}
