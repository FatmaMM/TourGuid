package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<GovernorateItem> list;
    GovernorateAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        list.add(new GovernorateItem(R.drawable.hireia, getString(R.string.Assiut)));
        list.add(new GovernorateItem(R.drawable.hireia, getString(R.string.Aswan)));
        adapter = new GovernorateAdapter(this, list, R.color.list_item_1);
        listView = (ListView) findViewById(R.id.gover_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, InterstPlaces.class);
                startActivity(intent);
            }
        });
    }
}
