package com.aloknath.restraurant_app.Activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.aloknath.restraurant_app.Fragments.MusicListFragment;
import com.aloknath.restraurant_app.Fragments.MusicViewerFragment;
import com.aloknath.restraurant_app.R;

/**
 * Created by ALOKNATH on 3/3/2015.
 */
public class MusicListActivity extends Activity implements MusicListFragment.OnMusicSelectedListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.music_list_fragment);
    }

    @Override
    public void onMusicSelected(Uri tutUrl) {
        MusicViewerFragment viewer = (MusicViewerFragment) getFragmentManager()
                .findFragmentById(R.id.musicview_fragment);

        if (viewer == null || !viewer.isInLayout()) {
            Intent showContent = new Intent(getApplicationContext(),
                    MusicViewerActivity.class);
            showContent.setData(Uri.parse(String.valueOf(tutUrl)));
            startActivity(showContent);
        } else {
            viewer.updateUrl(String.valueOf(tutUrl));
        }
    }
}
