package com.aloknath.restraurant_app.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.aloknath.restraurant_app.R;

/**
 * Created by ALOKNATH on 3/3/2015.
 */
public class MusicViewerFragment extends Fragment {

    private WebView viewer;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewer = (WebView) inflater.inflate(R.layout.music_viewer_fragment_layout, container, false);
        return viewer;
    }

    public void updateUrl(String newUrl) {
        if (viewer != null) {
            viewer.loadUrl(newUrl);
        }
    }
}
