package com.birdicomputers.lec05demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = findViewById(R.id.list);
        ArrayList<ListData> arrayList = new ArrayList<ListData>();
        List<String> Attractions = Arrays.asList("Magnificent Mile","Navy Pier","Art Institute");
        List<Integer> AttrPics = Arrays.asList(R.drawable.macaron, R.drawable.pier, R.drawable.artinst);
        arrayList.add(new ListData(Attractions,AttrPics));
        arrayList.add(new ListData(Attractions,AttrPics));
        arrayList.add(new ListData(Attractions,AttrPics));
        CustomAdapter customAdapter = new CustomAdapter(this, arrayList);
        list.setAdapter(customAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast t = Toast.makeText(MainActivity.this, "BBBB", Toast.LENGTH_SHORT);
                t.show();
            }
        });

    }
}









//LinkyfyCompat.addLinks(textview, Linkify.WEB_URLS);