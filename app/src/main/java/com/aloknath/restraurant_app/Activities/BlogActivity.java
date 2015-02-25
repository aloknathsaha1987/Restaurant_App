package com.aloknath.restraurant_app.Activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import com.aloknath.restraurant_app.Adapters.BlogViewAdapter;
import com.aloknath.restraurant_app.R;


/**
 * Created by ALOKNATH on 2/21/2015.
 */
public class BlogActivity extends FragmentActivity {
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blog_layout);

        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new BlogViewAdapter(getSupportFragmentManager()));


    }
}