package com.aloknath.restraurant_app.Activities;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.aloknath.restraurant_app.Adapters.BlogViewAdapter;
import com.aloknath.restraurant_app.Fragments.Fragment_Blog_For_Adapter;
import com.aloknath.restraurant_app.R;


/**
 * Created by ALOKNATH on 2/21/2015.
 */
public class BlogActivity extends FragmentActivity implements Fragment_Blog_For_Adapter.FragmentBlogListner{

    private ViewPager pager;
    private Fragment_Blog_For_Adapter fragment0;
    private Fragment_Blog_For_Adapter fragment1;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.blog_layout);

        pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new BlogViewAdapter(getSupportFragmentManager()));

    }

//    protected Fragment findFragmentByPosition(int position) {
//        int pagerid = this.pager.getId();
//        //long pagerAdapterid = this.pagerAdapter.getItemId(position);
//        return getSupportFragmentManager().findFragmentByTag("android:switcher:" + position);
//    }

    @Override
    public void onItemSelect(int position, String title) {
        Intent intent;
        fragment0 = (Fragment_Blog_For_Adapter) BlogViewAdapter.getFragment(0);
        fragment1 = (Fragment_Blog_For_Adapter) BlogViewAdapter.getFragment(1);

        if(fragment0 != null && fragment1 != null){
            Toast.makeText(this, "Fragment 1 and Fragment 2 Present !!! and the selected fragment is " + title, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Fragments Null :(", Toast.LENGTH_SHORT).show();
        }

        switch (position){
            case 0:
                Toast.makeText(this, "Item Selected", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case 1:
                Toast.makeText(this, "Item Selected", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, FoodActivity.class);
                startActivity(intent);
                break;
            case 2:
                Toast.makeText(this, "Item Selected", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, BillingActivity.class);
                startActivity(intent);
                break;
            case 3:
                Toast.makeText(this, "Item Selected", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, BlogDetailActivity.class);
                startActivity(intent);
                break;
            default:
                break;

        }

    }
}