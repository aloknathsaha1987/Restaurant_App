package com.aloknath.restraurant_app.Fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.aloknath.restraurant_app.Adapters.MusicAdapter;
import com.aloknath.restraurant_app.Objects.RowItem;
import com.aloknath.restraurant_app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ALOKNATH on 3/3/2015.
 */
public class MusicListFragment extends ListFragment{

    MusicAdapter adapter;
    private List<RowItem> rowItems;
    private String[] menutitles;
    private String[] menualbums;

    private OnMusicSelectedListener listener;

    public interface OnMusicSelectedListener {
        public void onMusicSelected(int position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.music_list_fragment, null, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        menutitles = getResources().getStringArray(R.array.titles);
        menualbums = getResources().getStringArray(R.array.albums);

        rowItems = new ArrayList<>();

        for (int i = 0; i < menutitles.length; i++) {
            RowItem items = new RowItem(menutitles[i],menualbums[i]);

            rowItems.add(items);
        }

        adapter = new MusicAdapter(getActivity(), rowItems);
        setListAdapter(adapter);
//        getListView().setOnItemClickListener(this);

    }

//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//    }
//
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setListAdapter(ArrayAdapter.createFromResource(getActivity()
//        .getApplicationContext(), R.array.my_data_list, R.layout.music_list_fragment));
//    }

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
//
//        String[] genre = getResources().getStringArray(R.array.my_data_list);
//        String content = genre[position];

        listener.onMusicSelected(position);
        
    }
}
