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
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;


import com.aloknath.restraurant_app.Adapters.ExpandableBaseAdapter;
import com.aloknath.restraurant_app.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ALOKNATH on 3/3/2015.
 */
public class MusicViewerFragment extends Fragment {

    private View view;
    private ImageView imgIcon;
    ExpandableBaseAdapter listAdapter;
    ExpandableListView expListView;
    List<Albums> albums = new ArrayList<>();

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = (View) inflater.inflate(R.layout.music_viewer_fragment_layout, container, false);

        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.expandable_listView);

        // preparing list data

        albums = prepareListData(0);

        listAdapter = new ExpandableBaseAdapter(getActivity(), albums);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        listViewListner();


        InputStream ims = null;
        try {
            ims = getActivity().getAssets().open("rock2.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Drawable d = Drawable.createFromStream(ims, null);
        view.setBackground(d);

        return view;
    }

    private void listViewListner() {
        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                 return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                Toast.makeText(
                        getActivity().getApplicationContext(),
                        albums.get(groupPosition).getTitle()
                                + " : "
                                + albums.get(groupPosition).getSongs().get(childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    public class Albums{
        private String band;
        private String title;
        private Drawable draw;
        private List<String> songs;

        public String getBand() {
            return band;
        }

        public void setBand(String band) {
            this.band = band;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Drawable getDraw() {
            return draw;
        }

        public void setDraw(Drawable draw) {
            this.draw = draw;
        }

        public List<String> getSongs() {
            return songs;
        }

        public void setSongs(List<String> songs) {
            this.songs = songs;
        }
    }


    private List<Albums> prepareListData(int index) {

        Albums album = new Albums();
        List<String> songs = new ArrayList<>();
        InputStream ims;
        Drawable d = null;


        switch (index){

            case 0:

                try {
                    ims = getActivity().getAssets().open("metallica.jpg");
                    d = Drawable.createFromStream(ims, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                songs.add("Battery");
                songs.add("Master of Puppets");
                songs.add("The Thing that Should not Be");
                songs.add("Disposable Heros");

                album.setBand("Metallica");
                album.setTitle("Master of Puppets");
                album.setDraw(d);
                album.setSongs(songs);

                albums.add(album);

                album = new Albums();
                songs = new ArrayList<>();
                try {
                    ims = getActivity().getAssets().open("IronMaiden.jpg");
                    d = Drawable.createFromStream(ims, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                songs.add("Invaders");
                songs.add("Children of The Damned");
                songs.add("The Prisoner");
                songs.add("The Number of the Beast");

                album.setBand("Iron Maiden");
                album.setTitle("The Number of The Beast");
                album.setDraw(d);
                album.setSongs(songs);

                albums.add(album);

                break;

            case 1:

                try {
                    ims = getActivity().getAssets().open("Jimi_Hendrix_Rock.jpg");
                    d = Drawable.createFromStream(ims, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                songs.add("Fire");
                songs.add("Izabella");
                songs.add("Red House");
                songs.add("Hear My Train a Comin'");

                album.setBand("Jimi Hendrix");
                album.setTitle("Wookstock");
                album.setDraw(d);
                album.setSongs(songs);

                albums.add(album);

                break;

            default:
                break;

        }

        return albums;

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void updateUrl(int position) {

        try {
            InputStream ims;
            Drawable d;

            switch (position) {

                case 0:
                    albums.clear();
                    ims = getActivity().getAssets().open("rock2.jpg");
                    d = Drawable.createFromStream(ims, null);

                    albums = prepareListData(0);

                    listAdapter = new ExpandableBaseAdapter(getActivity(), albums);

                    // setting list adapter
                    expListView.setAdapter(listAdapter);

                    view.setBackground(d);

                    break;

                case 1:
                    albums.clear();
                    albums = prepareListData(1);

                    listAdapter = new ExpandableBaseAdapter(getActivity(), albums);

                    // setting list adapter
                    expListView.setAdapter(listAdapter);

                    ims = getActivity().getAssets().open("pop2.jpg");
                    d = Drawable.createFromStream(ims, null);
                    view.setBackground(d);

                    break;

                case 2:
                    ims = getActivity().getAssets().open("alternate2.jpg");
                    d = Drawable.createFromStream(ims, null);
                    view.setBackground(d);
                    break;

                case 3:
                    ims = getActivity().getAssets().open("classical2.jpg");
                    d = Drawable.createFromStream(ims, null);
                    view.setBackground(d);
                    break;

                case 4:
                    ims = getActivity().getAssets().open("youtube.jpg");
                    d = Drawable.createFromStream(ims, null);
                    view.setBackground(d);
                    break;

                default:
                    ims = getActivity().getAssets().open("rock2.jpg");
                    d = Drawable.createFromStream(ims, null);
                    view.setBackground(d);
                    break;
            }
        }catch(IOException ex)
        {
            return ;
        }

    }
}
