package com.birdicomputers.lec05demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
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
        CustomAdapter customAdapter = new CustomAdapter(this, arrayList);
        list.setAdapter(customAdapter);
        Toast.makeText(getApplicationContext(),String.valueOf(list.getCount()),Toast.LENGTH_SHORT).show();
    }
}








//LinkyfyCompat.addLinks(textview, Linkify.WEB_URLS);