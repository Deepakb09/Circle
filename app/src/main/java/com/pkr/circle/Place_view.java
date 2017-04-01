package com.pkr.circle;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class Place_view extends AppCompatActivity {

    ImageView title_pics1;
    AppBarLayout appBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle1 = getIntent().getBundleExtra("data1");
        Bundle bundle2 = getIntent().getBundleExtra("data2");
        Log.e("place_view", bundle1.getString("location"));

//        TextView textView = (TextView) findViewById(R.id.content_textview);
//        textView.setText(b.getString("location"));
        String title = bundle1.getString("location");
        getSupportActionBar().setTitle(title);

//        title_pics1 = (ImageView) findViewById(R.id.title_pic_layout);
        int title_cover = bundle2.getInt("location_pics");
//        title_pics1.setImageResource(title_cover);
        appBar = (AppBarLayout) findViewById(R.id.app_bar);
        appBar.setBackgroundResource(title_cover);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Feature is coming soon", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
//        return super.onSupportNavigateUp();
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_place_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id==R.id.share){
            return true;
        }

        else if(id==R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void plan_trip(View view){
        Intent intent = new Intent (this, MapsActivity.class);
        startActivity(intent);
    }
}
