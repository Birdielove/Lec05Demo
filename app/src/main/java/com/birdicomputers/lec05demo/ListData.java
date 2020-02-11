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
    List<String> songName;
    List<Integer> songPicList;
    int currentPlayingIndex;
    boolean playStatus;

    public ListData(List<String> songName, List<Integer> image) {
        this.songName = songName;
        this.songPicList = image;
        this.currentPlayingIndex = -1;
        this.playStatus = false;
    }
    public int getCurrentPlayingIndex() {
        return currentPlayingIndex;
    }

    public void setCurrentPlayingIndex(int currentPlayingIndex) {
        this.currentPlayingIndex = currentPlayingIndex;
    }

    public boolean isPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(boolean playStatus) {
        this.playStatus = playStatus;
    }


}
