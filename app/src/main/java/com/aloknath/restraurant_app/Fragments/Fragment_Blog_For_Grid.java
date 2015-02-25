package com.aloknath.restraurant_app.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aloknath.restraurant_app.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ALOKNATH on 2/25/2015.
 */
public class Fragment_Blog_For_Grid extends Fragment{

    private String title;
    View view;

    public static Fragment_Blog_For_Grid newInstance(String title){
        Fragment_Blog_For_Grid fragment_blog_for_grid = new Fragment_Blog_For_Grid();
        Bundle args = new Bundle();
        args.putString("Title", title);
        fragment_blog_for_grid.setArguments(args);
        return fragment_blog_for_grid;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("Title");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.blog_fragment_layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        try
        {
            // get input stream
            InputStream ims = getActivity().getAssets().open("read_more.jpg");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            ImageView imageView = (ImageView)view.findViewById(R.id.read_more);
            imageView.setImageDrawable(d);

        }catch(IOException ex)
        {
            return;
        }
    }
}
