package com.aloknath.restraurant_app.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.aloknath.restraurant_app.Fragments.Fragment_Blog_For_Adapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ALOKNATH on 2/25/2015.
 */
public class BlogViewAdapter extends FragmentPagerAdapter {

    private static Map<Integer, Fragment> mPageReferenceMap = new HashMap<>();

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

            case 0:
                Fragment_Blog_For_Adapter frag0 = new Fragment_Blog_For_Adapter();
                mPageReferenceMap.put(pos, frag0.newInstance("One"));
                return frag0.newInstance("One");

            case 1:
                Fragment_Blog_For_Adapter frag1 = new Fragment_Blog_For_Adapter();
                mPageReferenceMap.put(pos, frag1.newInstance("Two"));
                return frag1.newInstance("Two");

            default: return Fragment_Blog_For_Adapter.newInstance("Three");
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        mPageReferenceMap.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        mPageReferenceMap.remove(position);
    }

    public static Fragment getFragment(int key) {
        //Fragment_Blog_For_Adapter frag = new Fragment_Blog_For_Adapter();
        return mPageReferenceMap.get(key);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

//    public static String makeFragmentName( int index) {
//        return "android:switcher:" + index;
//    }

}
