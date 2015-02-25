package com.aloknath.restraurant_app.Activities;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.GridView;

import com.aloknath.restraurant_app.Adapters.BlogViewAdapter;
import com.aloknath.restraurant_app.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ALOKNATH on 2/21/2015.
 */
public class BlogActivity extends FragmentActivity {
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blog_layout);


        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new BlogViewAdapter(this));
        try
        {
            // get input stream
            InputStream ims = getAssets().open("blog.jpg");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            this.findViewById(android.R.id.content).setBackground(d);

        }catch(IOException ex)
        {
            return;
        }

    }
}