package com.aloknath.restraurant_app.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aloknath.restraurant_app.Fragments.MusicViewerFragment;
import com.aloknath.restraurant_app.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ALOKNATH on 3/4/2015.
 */

public class ExpandableBaseAdapter extends BaseExpandableListAdapter{

    private Context context;
    private Map<String, List<String>> listDataChild = new HashMap<>();
    private List<String> listDataHeader;
    private List<MusicViewerFragment.Albums> albums;

    public ExpandableBaseAdapter(Context context, List<MusicViewerFragment.Albums> albums) {
        this.context = context;
        this.albums = albums;
    }


    @Override
    public int getGroupCount() {
        return albums.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return albums.get(groupPosition).getSongs().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return albums.get(groupPosition).getBand();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {

        return albums.get(groupPosition).getSongs().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }


    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup viewGroup) {

        MusicViewerFragment.Albums album = albums.get(groupPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group_header, null);
        }

        ImageView image = (ImageView)convertView.findViewById(R.id.albumImage);
        image.setImageDrawable(album.getDraw());
        TextView textView = (TextView)convertView.findViewById(R.id.bandName);
        textView.setText(album.getBand());

        textView = (TextView)convertView.findViewById(R.id.albumTitle);
        textView.setText(album.getTitle());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group_children, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.ListChildren);

        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
