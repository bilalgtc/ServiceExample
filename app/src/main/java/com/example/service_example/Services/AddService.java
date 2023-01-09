package com.example.service_example.Services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.example.service_example.Adapters.Recycler_Adapter;
import com.example.service_example.Helper.DatabaseHelper;
import com.example.service_example.Interfaces.AddData;

public class AddService extends Service implements AddData {

    String name, email, mobile, password;
    Recycler_Adapter adapter;
    Context context;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

//        ((AddService) context).onUpdateStatus();

        final String name= intent.getStringExtra("name");
        final String email= intent.getStringExtra("email");
        final String mobile= intent.getStringExtra("mobile");
        final String password= intent.getStringExtra("password");


//       Log.d("TAG", name);

        DatabaseHelper helper = new DatabaseHelper(this);
        helper.addRecord(name, email, mobile, password);
        onUpdateStatus();
        return START_STICKY;
    }


    @Override
    public void onUpdateStatus() {

    }
}
