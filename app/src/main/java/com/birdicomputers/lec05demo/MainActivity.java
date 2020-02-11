package com.birdicomputers.lec05demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer currentsong = new MediaPlayer();
    Button play, pause;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);
        ArrayList<ListData> arrayList = new ArrayList<ListData>();
        List<String> songNameList = Arrays.asList("BagPipes","Drums","Ukulele");
        List<Integer> songPicList = Arrays.asList(R.drawable.bagpipes, R.drawable.drums, R.drawable.ukulele);
        final List<Integer> songList = Arrays.asList(R.raw.bagpipes, R.raw.drums, R.raw.ukulele);
        arrayList.add(new ListData(songNameList,songPicList));
        arrayList.add(new ListData(songNameList,songPicList));
        arrayList.add(new ListData(songNameList,songPicList));
        final CustomAdapter customAdapter = new CustomAdapter(this, arrayList);
        list.setAdapter(customAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListData data=customAdapter.arrayList.get(position);
                if(data.getCurrentPlayingIndex()==position){
                    if (currentsong != null && currentsong.isPlaying()) {
                        currentsong.pause();
                        data.setPlayStatus(false);
                        customAdapter.refrechView();
                    }
                    else if(currentsong !=null && !currentsong.isPlaying()){
                        data.setPlayStatus(true);
                        customAdapter.refrechView();
                    }
                }
                else{
                    //stop current song if playing
                    if(currentsong !=null && currentsong.isPlaying()){
                        currentsong.stop();
                        customAdapter.refrechView();
                        //need to prepare if retarting the same media player object.
                    }
                    currentsong = MediaPlayer.create(MainActivity.this, songList.get(position));
                    currentsong.start();
                }
            }
        });
    }
}









//LinkyfyCompat.addLinks(textview, Linkify.WEB_URLS);