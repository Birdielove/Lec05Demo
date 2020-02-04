package com.birdicomputers.lec05demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] attraction = {"Art Institute of chicago","Magnificent Mile", "Willis Tower", "Navy Pier", "Water Tower"};
        ListView lv = findViewById(R.id.lv);
        List<String> Attractions = Arrays.asList("Magnificent Mile","Navy Pier","Art Institute");
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.activity_list_item, Attractions));
    }

}
