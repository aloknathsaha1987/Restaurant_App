package com.aloknath.restraurant_app.Fragments;

import android.app.Activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
public class Fragment_Blog_For_Adapter extends Fragment {

    //https://github.com/javatechig/Twitter-Sharing-Example-Android.git

    private FragmentBlogListner mListner;

    public interface FragmentBlogListner{
        public void onItemSelect(int position, String titlePassed);
    }

    private String title;
    View view;

    public static Fragment_Blog_For_Adapter newInstance(String title){
        Fragment_Blog_For_Adapter fragment_blog_for_adapter = new Fragment_Blog_For_Adapter();
        Bundle args = new Bundle();
        args.putString("Title", title);
        fragment_blog_for_adapter.setArguments(args);
        return fragment_blog_for_adapter;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof FragmentBlogListner) {
            mListner = (FragmentBlogListner) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
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
            ImageView comment = (ImageView)view.findViewById(R.id.comments_button);
            comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListner.onItemSelect(0, title);
                }
            });

            ImageView twitter = (ImageView)view.findViewById(R.id.twitter_tweet);
            twitter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListner.onItemSelect(1, title);
                }
            });

            ImageView facebook = (ImageView)view.findViewById(R.id.facebook_like);
            facebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListner.onItemSelect(2, title);
                }
            });

            // get input stream
            InputStream ims = getActivity().getAssets().open("read_more_button.jpg");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            ImageView imageView = (ImageView)view.findViewById(R.id.read_more);
            imageView.setImageDrawable(d);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListner.onItemSelect(3, title);
                }
            });

            ims = getActivity().getAssets().open("biryani.jpg");
             d = Drawable.createFromStream(ims, null);
            imageView = (ImageView)view.findViewById(R.id.food_picture);
            imageView.setImageDrawable(d);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        }catch(IOException ex)
        {
            return;
        }

    }
}
