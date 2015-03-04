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

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = (View) inflater.inflate(R.layout.music_viewer_fragment_layout, container, false);

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
//                    txtTitle.setText("ROCK MUSIC");
//                    albums.setText("4 Albums");
                    break;

                case 1:
                    ims = getActivity().getAssets().open("pop2.jpg");
                    d = Drawable.createFromStream(ims, null);
                    imgIcon.setBackground(d);
//                    txtTitle.setText("POP MUSIC");
//                    albums.setText("3 Albums");
                    break;

                case 2:
                    ims = getActivity().getAssets().open("alternate2.jpg");
                    d = Drawable.createFromStream(ims, null);
                    imgIcon.setBackground(d);
//                    txtTitle.setText("ALTERNATE MUSIC");
//                    albums.setText("3 Albums");
                    break;

                case 3:
                    ims = getActivity().getAssets().open("classical2.jpg");
                    d = Drawable.createFromStream(ims, null);
                    imgIcon.setBackground(d);
//                    txtTitle.setText("CLASSICAL MUSIC");
//                    albums.setText("6 Albums");

                    break;

                case 4:
                    ims = getActivity().getAssets().open("youtube.jpg");
                    d = Drawable.createFromStream(ims, null);
                    imgIcon.setBackground(d);
//                    txtTitle.setText("YOUTUBE SEARCH");
//                    albums.setText("");
                    break;

                default:
                    break;
            }
        }catch(IOException ex)
        {
            return ;
        }

    }
}