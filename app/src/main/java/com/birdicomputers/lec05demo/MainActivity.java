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

    MediaPlayer music, drums;
    Button play, pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.list);
        ArrayList<ListData> arrayList = new ArrayList<ListData>();
        List<String> songNameList = Arrays.asList("BagPipes","Drums","Ukulele");
        List<Integer> songPicList = Arrays.asList(R.drawable.bagpipes, R.drawable.drums, R.drawable.ukulele);
        arrayList.add(new ListData(songNameList,songPicList));
        arrayList.add(new ListData(songNameList,songPicList));
        arrayList.add(new ListData(songNameList,songPicList));
        CustomAdapter customAdapter = new CustomAdapter(this, arrayList);
        list.setAdapter(customAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast t = Toast.makeText(MainActivity.this, "Works", Toast.LENGTH_SHORT);
                t.show();
            }
        });

    }
}









//LinkyfyCompat.addLinks(textview, Linkify.WEB_URLS);