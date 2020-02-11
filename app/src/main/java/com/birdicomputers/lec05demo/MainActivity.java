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
                ListData Listdata=customAdapter.arrayList.get(position);
                if(Listdata.getCurrentPlayingIndex()==position){
                    if (currentsong != null && currentsong.isPlaying()) {
                        currentsong.pause();
                        Listdata.setPlayStatus(false);
                        customAdapter.refreshView();
                    }
                    else if(currentsong !=null && !currentsong.isPlaying()){
                        Listdata.setPlayStatus(true);
                        customAdapter.refreshView();
                    }
                }
                else{
                    //stop current song if playing
                    if(currentsong !=null && currentsong.isPlaying()){
                        currentsong.stop();
                        customAdapter.refreshView();
                        //need to prepare if restarting the same media player object.
                    }
                    currentsong = MediaPlayer.create(MainActivity.this, songList.get(position));
                    currentsong.start();
                    Listdata.setCurrentPlayingIndex(position);
                    Listdata.setPlayStatus(true);
                    customAdapter.refreshView();
                }
            }
        });
    }
}









//LinkyfyCompat.addLinks(textview, Linkify.WEB_URLS);