package com.aloknath.restraurant_app.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.aloknath.restraurant_app.Fragments.MusicViewerFragment;
import com.aloknath.restraurant_app.R;

/**
 * Created by ALOKNATH on 3/3/2015.
 */
public class MusicViewerActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.music_viewer_fragment);

        Intent launchingIntent = getIntent();
        String content = launchingIntent.getData().toString();

        MusicViewerFragment viewer = (MusicViewerFragment) getFragmentManager()
                .findFragmentById(R.id.musicview_fragment);

        viewer.updateUrl(content);
    }
}
