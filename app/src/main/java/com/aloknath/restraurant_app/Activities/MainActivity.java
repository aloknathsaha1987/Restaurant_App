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

        android.support.v7.app.ActionBar actionBar1 =  getSupportActionBar();
        actionBar1.hide();

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


        //fragmentTransaction.addToBackStack("Entertainment");
        fragmentTransaction.commit();

////        fragmentEntertainment = new Fragment_Entertainment();
////        fragmentTransaction.replace(R.id.fragmentEntertainment, fragmentEntertainment.newInstance("Entertainment"), "frag_entertainment");
//          getSupportFragmentManager().beginTransaction().add(R.id.fragmentEntertainment, fragmentEntertainment.newInstance("Entertainment"), "frag_entertainment").commit();
////        Fragment_Food fragmentFood = new Fragment_Food();
////


        fragmentEntertainment = (Fragment_Entertainment) getSupportFragmentManager()
                .findFragmentByTag("frag_entertainment");
//        if (fragmentEntertainment == null){
//            Toast.makeText(MainActivity.this, "Fragment is null", Toast.LENGTH_SHORT).show();
//        }
//        else{
//            Toast.makeText(MainActivity.this, "Fragment is NOT null", Toast.LENGTH_SHORT).show();
//        }
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

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
