package com.aloknath.restraurant_app.Activities;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.aloknath.restraurant_app.Fragments.Fragment_Entertainment;
import com.aloknath.restraurant_app.Fragments.Fragment_Food;
import com.aloknath.restraurant_app.Fragments.Fragment_Billing;
import com.aloknath.restraurant_app.Fragments.Fragment_Blog;
import com.aloknath.restraurant_app.R;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends ActionBarActivity implements Fragment_Entertainment.OnItemSelectedListener1{

    Fragment_Entertainment fragmentEntertainment;

    String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        android.support.v7.app.ActionBar actionBar1 =  getSupportActionBar();
//        actionBar1.hide();

//        //Remove title bar
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//        //Remove notification bar
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //set content view AFTER ABOVE sequence (to avoid crash)
        setContentView(R.layout.activity_main);

        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentEntertainment = new Fragment_Entertainment();
        path =  "android.resource://"+ getPackageName() + "/res/drawable/entertainment.jpg";
        fragmentTransaction.replace(R.id.fragmentEntertainment, fragmentEntertainment.newInstance(path), "frag_entertainment");
        Fragment_Food fragmentFood = new Fragment_Food();
        fragmentTransaction.replace(R.id.fragmentFood, fragmentFood.newInstance("Food"), "frag_food");
        Fragment_Billing fragmentBilling = new Fragment_Billing();
        fragmentTransaction.replace(R.id.fragmentBilling, fragmentBilling.newInstance("Billing"), "frag_billing");
        Fragment_Blog fragmentBlog = new Fragment_Blog();
        fragmentTransaction.replace(R.id.fragmentBlog, fragmentBlog.newInstance("Blog"), "frag_blog");
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();



        fragmentEntertainment = (Fragment_Entertainment) getSupportFragmentManager()
                .findFragmentByTag("frag_entertainment");

    }



    @Override
    public void onItemSelect() {

        if (fragmentEntertainment != null && fragmentEntertainment.isInLayout()){
            Intent intent = new Intent(MainActivity.this, EntertainmentActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(MainActivity.this, "Fragment_Entertainment is null", Toast.LENGTH_SHORT).show();
        }
    }
}
