package com.aloknath.restraurant_app.Activities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

import com.aloknath.restraurant_app.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ALOKNATH on 2/25/2015.
 */
public class BlogDetailActivity extends Activity {
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blog_detail_layout);
        ImageView photo = (ImageView)findViewById(R.id.blog_image);

        try
        {
            // get input stream
            InputStream ims = getAssets().open("biryani.jpg");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            photo.setBackground(d);
            photo.setScaleType(ImageView.ScaleType.FIT_XY);

        }catch(IOException ex)
        {
            return;
        }
    }
}
