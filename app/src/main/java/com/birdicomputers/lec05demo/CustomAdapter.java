package com.birdicomputers.lec05demo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    ArrayList<ListData> arrayList;
    Context context;
    public CustomAdapter(Context context, ArrayList<ListData> arrayList) {
        this.arrayList=arrayList;
        this.context=context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            ListData subjectData=arrayList.get(position);
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.list_items, parent, false);
            TextView tittle = convertView.findViewById(R.id.text);
            tittle.setText(subjectData.attractionNmae.get(position));
            Drawable img = parent.getResources().getDrawable(subjectData.image.get(position));
            img.setBounds(0, 0, 80, 80);
            tittle.setCompoundDrawables(img, null, null, null);
            tittle.setCompoundDrawablePadding(80);
            return convertView;
        }
        return convertView;
        //a
    }
}
