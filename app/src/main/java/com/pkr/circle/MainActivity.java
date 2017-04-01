package com.pkr.circle;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button my_trips_button;
    LinearLayout recommended;
    MyDBHandler db;

    public String[] topTile = {};
    public String[] topTile1 = {};
    public String[] topTile2 = {};

    public ArrayList<String> topTileTemp = new ArrayList<String>();
    int[] topTile_cover = {R.drawable.nandi, R.drawable.default_cover, R.drawable.nandi, R.drawable.nandi, R.drawable.nandi};
    int[] topTile_cover1 = {R.drawable.default_cover, R.drawable.default_cover, R.drawable.nandi, R.drawable.default_cover, R.drawable.default_cover};
    int[] topTile_cover2 = {R.drawable.default_cover, R.drawable.nandi, R.drawable.nandi, R.drawable.nandi, R.drawable.default_cover};

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;

    RecyclerView recyclerView1;
    RecyclerView.LayoutManager layoutManager1;
    RecyclerViewAdapter recyclerViewAdapter1;

    RecyclerView recyclerView2;
    RecyclerView.LayoutManager layoutManager2;
    RecyclerViewAdapter recyclerViewAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_trips_button = (Button) findViewById(R.id.my_trips_button);
        my_trips_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyTrips.class);
                startActivity(intent);
            }
        });
        recommended = (LinearLayout) findViewById(R.id.recommended);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(this, topTile, topTile_cover);
        recyclerView.setAdapter(recyclerViewAdapter);
//        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(layoutManager);

        recyclerView1 = (RecyclerView) findViewById(R.id.recycler_view1);
        layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerViewAdapter1 = new RecyclerViewAdapter(this, topTile1, topTile_cover1);
        recyclerView1.setAdapter(recyclerViewAdapter1);

        recyclerView2 = (RecyclerView) findViewById(R.id.recycler_view2);
        layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerViewAdapter2 = new RecyclerViewAdapter(this, topTile2, topTile_cover2);
        recyclerView2.setAdapter(recyclerViewAdapter2);




        db = new MyDBHandler(getApplicationContext());

        db.open();

        //database starts
        //String state,String place,String spot, int rating, String reviews, String description,String activity,String latitude,String longitude)
        db.insertData("ARUNACHAL PRADESH","TAWANG","Sela Pass",4,"GOOD","BLAH BLAH BLAH BLAH BLAH BLAH BLAH","HIKING","20","40");
        db.insertData("ARUNACHAL PRADESH","LASHA","Tawang monastery",4,"GOOD","BLAH BLAH BLAH BLAH BLAH BLAH BLAH","RELIGIOUS","20","40");
        db.insertData("ARUNACHAL PRADESH","UMANGA","Tawang monastery",4,"GOOD","BLAH BLAH BLAH BLAH BLAH BLAH BLAH","RELIGIOUS","20","40");

        Cursor c = db.queryName();
        //Toast.makeText(MainActivity.this, "state : " + c.getCount(), Toast.LENGTH_SHORT).show();
        if(c.moveToFirst()){
            while(c.moveToNext()) {

                // String[] topTile = c.getString(1);
                   topTileTemp.add(c.getString(2));
            }

        } else
            Toast.makeText(MainActivity.this, "No Value", Toast.LENGTH_SHORT).show();

        for (int i =0; i<topTileTemp.size();i++){
            Toast.makeText(MainActivity.this, "state : " + topTileTemp.get(i), Toast.LENGTH_SHORT).show();

        }

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.budget, menu);
//        return true;
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        return super.onOptionsItemSelected(item);
//    }
//    public void click(View view){
//        Intent intent  = new Intent(this, Place_view.class);
//        startActivity(intent);
//    }



}


