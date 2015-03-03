package com.aloknath.restraurant_app.Fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.aloknath.restraurant_app.R;

/**
 * Created by ALOKNATH on 3/3/2015.
 */
public class MusicListFragment extends ListFragment {

    public interface OnMusicSelectedListener {
        public void onMusicSelected(Uri tutUri);
    }

    private OnMusicSelectedListener listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(ArrayAdapter.createFromResource(getActivity()
        .getApplicationContext(), R.array.my_data_list, R.layout.music_list_fragment));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
            try {
                listener = (OnMusicSelectedListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString()
                        + " must implement OnTutSelectedListener");
            }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String[] genre = getResources().getStringArray(R.array.my_data_list);
        String content = genre[position];

        listener.onMusicSelected(Uri.parse(content));
        
    }
}
