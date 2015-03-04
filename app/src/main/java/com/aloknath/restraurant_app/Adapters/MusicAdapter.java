package com.aloknath.restraurant_app.Adapters;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aloknath.restraurant_app.Objects.RowItem;
import com.aloknath.restraurant_app.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by ALOKNATH on 3/3/2015.
 */
public class MusicAdapter extends BaseAdapter {

    private Context context;
    private List<RowItem> rowItemList;

    public MusicAdapter(Context context, List<RowItem> rowItemList){
        this.context = context;
        this.rowItemList = rowItemList;
    }

    @Override
    public int getCount() {
        return rowItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItemList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return rowItemList.indexOf(getItem(position));
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if(view == null){
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.music_genre_adapter_layout, null);
        }

        RowItem item = rowItemList.get(position);

        ImageView imagebar = (ImageView) view.findViewById(R.id.imageView2);
        ImageView imgIcon = (ImageView) view.findViewById(R.id.imageView3);
        TextView txtTitle = (TextView) view.findViewById(R.id.editText);
        txtTitle.setText(item.getTitle());
        TextView albums = (TextView) view.findViewById(R.id.editText2);
        albums.setText(item.getAlbums());

        try {
            InputStream ims;
            Drawable d;
            switch (position) {

                case 0:
                    ims = context.getAssets().open("rock1.jpg");
                    d = Drawable.createFromStream(ims, null);
                    imgIcon.setBackground(d);
//                    txtTitle.setText("ROCK MUSIC");
//                    albums.setText("4 Albums");
                    break;

                case 1:
                    ims = context.getAssets().open("pop1.jpg");
                    d = Drawable.createFromStream(ims, null);
                    imgIcon.setBackground(d);
//                    txtTitle.setText("POP MUSIC");
//                    albums.setText("3 Albums");
                    break;

                case 2:
                    ims = context.getAssets().open("alternate1.jpg");
                    d = Drawable.createFromStream(ims, null);
                    imgIcon.setBackground(d);
//                    txtTitle.setText("ALTERNATE MUSIC");
//                    albums.setText("3 Albums");
                    break;

                case 3:
                    ims = context.getAssets().open("classical1.jpg");
                    d = Drawable.createFromStream(ims, null);
                    imgIcon.setBackground(d);
//                    txtTitle.setText("CLASSICAL MUSIC");
//                    albums.setText("6 Albums");

                    break;

                case 4:
                    ims = context.getAssets().open("youtube.jpg");
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
            return null;
        }

        return view;
    }
}
