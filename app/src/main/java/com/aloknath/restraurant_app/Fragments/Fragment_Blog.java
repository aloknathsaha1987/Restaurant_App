package com.aloknath.restraurant_app.Fragments;

/**
 * Created by ALOKNATH on 2/21/2015.
 */
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aloknath.restraurant_app.Activities.BlogActivity;
import com.aloknath.restraurant_app.R;

import java.io.IOException;
import java.io.InputStream;

@SuppressLint("NewApi")
public class Fragment_Blog extends Fragment {
    private String title;
    TextView textView;
    View view;

    public static Fragment_Blog newInstance(String title){
        Fragment_Blog fragmentBlog = new Fragment_Blog();
        Bundle args = new Bundle();
        args.putString("Title", title);
        fragmentBlog.setArguments(args);
        return fragmentBlog;
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

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment4, viewGroup, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        try
        {
            // get input stream
            InputStream ims = getActivity().getAssets().open("blog.jpg");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
           view.setBackground(d);
        }catch(IOException ex)
        {
            return;
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BlogActivity.class);
                startActivity(intent);
            }
        });
    }


}