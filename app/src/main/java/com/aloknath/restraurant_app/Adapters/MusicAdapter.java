package com.aloknath.restraurant_app.Adapters;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ALOKNATH on 3/3/2015.
 */
public class MusicAdapter extends BaseAdapter {

    private Context context;
    private List<RowItem> rowItemList;
    private static final Map<String, ListObject> listValues = new HashMap<>();
    private ListObject listObject;

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
                    if(listValues.get("rock") == null) {
                        ims = context.getAssets().open("rock1.jpg");
                        d = Drawable.createFromStream(ims, null);
                        imgIcon.setBackground(d);
                        listObject = new ListObject();
                        listObject.setDraw(d);
                        listValues.put("rock", listObject);
                    }else{
                        listObject = listValues.get("rock");
                        imgIcon.setBackground(listObject.getDraw());
                    }

                    break;

                case 1:
                    if(listValues.get("pop") == null) {
                        ims = context.getAssets().open("pop1.jpg");
                        d = Drawable.createFromStream(ims, null);
                        imgIcon.setBackground(d);
                        imagebar.setBackgroundColor(Color.parseColor("#FFFF0094"));

                        listObject = new ListObject();
                        listObject.setDraw(d);
                        listObject.setBarColor(Color.parseColor("#FFFF0094"));
                        listValues.put("pop", listObject);

                    }else{
                        listObject = listValues.get("pop");
                        imgIcon.setBackground(listObject.getDraw());
                        imagebar.setBackgroundColor(listObject.getBarColor());

                    }

                    break;

                case 2:
                    if(listValues.get("alternate") == null) {
                        ims = context.getAssets().open("alternate1.jpg");
                        d = Drawable.createFromStream(ims, null);
                        imgIcon.setBackground(d);
                        imagebar.setBackgroundColor(Color.parseColor("#FF00B43B"));

                        listObject = new ListObject();
                        listObject.setDraw(d);
                        listObject.setBarColor(Color.parseColor("#FF00B43B"));
                        listValues.put("alternate", listObject);
                    }else{
                        listObject = listValues.get("alternate");
                        imgIcon.setBackground(listObject.getDraw());
                        imagebar.setBackgroundColor(listObject.getBarColor());
                    }

                    break;

                case 3:
                    if(listValues.get("classical") == null) {
                        ims = context.getAssets().open("classical1.jpg");
                        d = Drawable.createFromStream(ims, null);
                        imgIcon.setBackground(d);
                        imagebar.setBackgroundColor(Color.parseColor("#FFFF1F04"));

                        listObject = new ListObject();
                        listObject.setDraw(d);
                        listObject.setBarColor(Color.parseColor("#FFFF1F04"));

                        listValues.put("classical", listObject);
                    }else{
                        listObject = listValues.get("classical");
                        imgIcon.setBackground(listObject.getDraw());
                        imagebar.setBackgroundColor(listObject.getBarColor());
                    }

                    break;

                case 4:
                    if(listValues.get("youtube") == null) {
                        ims = context.getAssets().open("youtube.jpg");
                        d = Drawable.createFromStream(ims, null);
                        imgIcon.setBackground(d);
                        imagebar.setBackgroundColor(Color.parseColor("#FFF8FF00"));

                        listObject = new ListObject();
                        listObject.setDraw(d);
                        listObject.setBarColor(Color.parseColor("#FFF8FF00"));

                        listValues.put("youtube", listObject);
                    }else{
                        listObject = listValues.get("youtube");
                        imgIcon.setBackground(listObject.getDraw());
                        imagebar.setBackgroundColor(listObject.getBarColor());

                    }

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

    private class ListObject{
        private Drawable draw;
        private int barColor;

        public Drawable getDraw() {
            return draw;
        }

        public void setDraw(Drawable draw) {
            this.draw = draw;
        }

        public int getBarColor() {
            return barColor;
        }

        public void setBarColor(int barColor) {
            this.barColor = barColor;
        }


    }
}
