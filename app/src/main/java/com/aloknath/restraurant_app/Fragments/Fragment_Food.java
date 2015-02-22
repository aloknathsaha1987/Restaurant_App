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

import com.aloknath.restraurant_app.Activities.FoodActivity;
import com.aloknath.restraurant_app.R;

import java.io.IOException;
import java.io.InputStream;

@SuppressLint("NewApi")
public class Fragment_Food extends Fragment {
    private String title;
    TextView textView;
    View view;

    public static Fragment_Food newInstance(String title){
        Fragment_Food fragmentFood = new Fragment_Food();
        Bundle args = new Bundle();
        args.putString("Title", title);
        fragmentFood.setArguments(args);
        return fragmentFood;
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
        view =  inflater.inflate(R.layout.fragment2, viewGroup, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        try
        {
            // get input stream
            InputStream ims = getActivity().getAssets().open("food.jpg");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);

            view.setBackground(d);
            //myImage.setImageDrawable(d);

        }catch(IOException ex)
        {
            return;
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FoodActivity.class);
                startActivity(intent);
            }
        });
    }
}