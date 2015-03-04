package com.aloknath.restraurant_app.Fragments;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

import com.aloknath.restraurant_app.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ALOKNATH on 3/3/2015.
 */
public class MusicViewerFragment extends Fragment {

    private View view;
    private ImageView imgIcon;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = (View) inflater.inflate(R.layout.music_viewer_fragment_layout, container, false);
        imgIcon = (ImageView)view.findViewById(R.id.imageView4);
        InputStream ims = null;
        try {
            ims = getActivity().getAssets().open("rock2.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Drawable d = Drawable.createFromStream(ims, null);
        imgIcon.setBackground(d);

        return view;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void updateUrl(int position) {

        imgIcon = (ImageView)view.findViewById(R.id.imageView4);

        try {
            InputStream ims;
            Drawable d;

            switch (position) {

                case 0:
                    ims = getActivity().getAssets().open("rock2.jpg");
                    d = Drawable.createFromStream(ims, null);
                    imgIcon.setBackground(d);

                    break;

                case 1:
                    ims = getActivity().getAssets().open("pop2.jpg");
                    d = Drawable.createFromStream(ims, null);
                    imgIcon.setBackground(d);

                    break;

                case 2:
                    ims = getActivity().getAssets().open("alternate2.jpg");
                    d = Drawable.createFromStream(ims, null);
                    imgIcon.setBackground(d);

                    break;

                case 3:
                    ims = getActivity().getAssets().open("classical2.jpg");
                    d = Drawable.createFromStream(ims, null);
                    imgIcon.setBackground(d);


                    break;

                case 4:
                    ims = getActivity().getAssets().open("youtube.jpg");
                    d = Drawable.createFromStream(ims, null);
                    imgIcon.setBackground(d);

                    break;

                default:
                    ims = getActivity().getAssets().open("rock2.jpg");
                    d = Drawable.createFromStream(ims, null);
                    imgIcon.setBackground(d);
                    break;
            }
        }catch(IOException ex)
        {
            return ;
        }

    }
}
