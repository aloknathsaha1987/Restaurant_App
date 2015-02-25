package com.aloknath.restraurant_app.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.aloknath.restraurant_app.Fragments.Fragment_Blog_For_Grid;
import com.aloknath.restraurant_app.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ALOKNATH on 2/25/2015.
 */
public class BlogViewAdapter extends FragmentPagerAdapter {


    public BlogViewAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int pos) {
        switch(pos) {

            case 0: return Fragment_Blog_For_Grid.newInstance("One");

            case 1: return Fragment_Blog_For_Grid.newInstance("Two");

            default: return Fragment_Blog_For_Grid.newInstance("Three");
        }
    }

}
