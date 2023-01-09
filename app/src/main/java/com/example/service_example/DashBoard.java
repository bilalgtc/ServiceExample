package com.example.service_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.service_example.Adapters.Recycler_Adapter;
import com.example.service_example.Helper.DatabaseHelper;
import com.example.service_example.Model.Recycle_model;

import java.util.ArrayList;

public class DashBoard extends AppCompatActivity implements AddData  {

    RecyclerView recyclerView;
    ArrayList<Recycle_model> details = new ArrayList<>();
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        recyclerView=findViewById(R.id.recycler_view);
        imageView = findViewById(R.id.imageView2);
        onUpdateStatus();


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        startActivity(new Intent(getApplicationContext(),MainActivity.class));
//        finish();
//    }

    @Override
    public void onUpdateStatus() {
        Cursor cursor = new DatabaseHelper(this).getData();
        if (cursor!=null && cursor.getCount()>0){
            if (cursor.moveToFirst()){
                do {
                    Recycle_model model = new Recycle_model(cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getString(4) );
                    details.add(model);
                }while (cursor.moveToNext());
            }
        }

        Recycler_Adapter adapter = new Recycler_Adapter(this, details);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}