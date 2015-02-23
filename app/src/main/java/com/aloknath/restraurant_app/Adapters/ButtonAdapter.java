package com.aloknath.restraurant_app.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.aloknath.restraurant_app.Activities.BillingActivity;
import com.aloknath.restraurant_app.Activities.EntertainmentActivity;
import com.aloknath.restraurant_app.Activities.FoodActivity;
import com.aloknath.restraurant_app.Activities.MainActivity;
import com.aloknath.restraurant_app.R;

/**
 * Created by ALOKNATH on 2/23/2015.
 */
public class ButtonAdapter extends BaseAdapter {

    public String[] filesnames = {
        "Internet",
        "Music",
        "News"
    };

    private Context mContext;
    // Gets the context so it can be used later
    public ButtonAdapter(Context c) {
        mContext = c;
    }

    // Total number of things contained within the adapter
    public int getCount() {
        return filesnames.length;
    }

    // Require for structure, not really used in my code.
    public Object getItem(int position) {
        return null;
    }

    // Require for structure, not really used in my code. Can
    // be used to get the id of an item in the adapter for
    // manual control.
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position,
                        View convertView, ViewGroup parent) {
        Button btn;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            btn = new Button(mContext);
            btn.setLayoutParams(new GridView.LayoutParams(300, 300));
            btn.setPadding(8, 8, 8, 8);
        }
        else {
            btn = (Button) convertView;
        }

        btn.setText(filesnames[position]);
        // filenames is an array of strings
        btn.setTextColor(Color.WHITE);
        btn.setBackgroundResource(R.drawable.ic_largebluebutton);
        btn.setId(position);

        // Set the onclicklistener so that pressing the button fires an event
// We will need to implement this onclicklistner.

        btn.setOnClickListener(new MyOnClickListener(position));

        return btn;
    }

    private class MyOnClickListener implements View.OnClickListener
    {
        private final int position;

        public MyOnClickListener(int position)
        {
            this.position = position;
        }

        public void onClick(View v)
        {
            // Preform a function based on the position
            Intent intent;
            String webpage;
            switch (position){
                case 0:
                    webpage = "https://www.google.com";
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webpage));
                    mContext.startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(mContext, FoodActivity.class);
                    mContext.startActivity(intent);
                    break;
                case 2:
                    webpage = "https://news.google.com";
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webpage));
                    mContext.startActivity(intent);
                    break;
                default:
                    break;
            }

        }
    }

}
