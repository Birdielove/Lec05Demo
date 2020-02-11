package com.birdicomputers.lec05demo;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ListData  {
    List<String> attractionNmae;
    List<Integer> image;


    public ListData(List<String> attractionNmae, List<Integer> image) {
        this.attractionNmae = attractionNmae;
        this.image = image;
    }

}
