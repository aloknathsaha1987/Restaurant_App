package com.aloknath.restraurant_app.Fragments;

/**
 * Created by ALOKNATH on 2/21/2015.
 */
 import android.annotation.SuppressLint;

 import android.app.Activity;
 import android.content.Intent;
 import android.content.res.AssetFileDescriptor;
 import android.graphics.Bitmap;
 import android.graphics.BitmapFactory;
 import android.graphics.drawable.Drawable;
 import android.os.Bundle;
 import android.support.annotation.Nullable;
 import android.support.v4.app.Fragment;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.Button;
 import android.widget.ImageView;
 import android.widget.TextView;

 import com.aloknath.restraurant_app.Activities.EntertainmentActivity;
 import com.aloknath.restraurant_app.Activities.MainActivity;
 import com.aloknath.restraurant_app.R;

 import java.io.File;
 import java.io.IOException;
 import java.io.InputStream;

@SuppressLint("NewApi")
public class Fragment_Entertainment extends Fragment {

    private String title;
    TextView textView;
    View fragView;
    Button button;

    private OnItemSelectedListener1 listener;

    public interface OnItemSelectedListener1 {
        public void onItemSelect();
    }

    public static Fragment_Entertainment newInstance(String title){
        Fragment_Entertainment fragmentEntertainment = new Fragment_Entertainment();
        Bundle args = new Bundle();
        args.putString("Title", title);
        fragmentEntertainment.setArguments(args);
        return fragmentEntertainment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnItemSelectedListener1) {
            listener = (OnItemSelectedListener1) activity;
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

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle savedInstanceState) {
        fragView =  inflater.inflate(R.layout.fragment1, viewGroup, false);
        return fragView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        try
        {
            // get input stream
            InputStream ims = getActivity().getAssets().open("entertainment.jpg");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            fragView.setBackground(d);
        }catch(IOException ex)
        {
            return;
        }

        fragView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getActivity(), "Button Clicked", Toast.LENGTH_SHORT).show();
                //listener.onItemSelect();
                Intent intent = new Intent(getActivity(), EntertainmentActivity.class);
                startActivity(intent);
            }
        });
    }

}