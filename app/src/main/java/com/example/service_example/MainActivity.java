package com.example.service_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.service_example.Helper.DatabaseHelper;
import com.example.service_example.Interfaces.AddData;
import com.example.service_example.Services.AddService;

public class MainActivity extends AppCompatActivity implements AddData {

    EditText name_ed,email_ed,password_ed,phone_ed;
    Button btn_submit;
    String name,email,mobile,password;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_ed=findViewById(R.id.editText2);
        email_ed=findViewById(R.id.editText3);
        phone_ed=findViewById(R.id.editText4);
        password_ed=findViewById(R.id.editText5);
        btn_submit = findViewById(R.id.submit_btn);


        helper = new DatabaseHelper(this);

        btn_submit.setOnClickListener(v -> {

            name=name_ed.getText().toString();
            email=email_ed.getText().toString();
            mobile=phone_ed.getText().toString();
            password=password_ed.getText().toString();

            if (name.isEmpty() && email.isEmpty() && mobile.isEmpty() && password.isEmpty()){
                Toast.makeText(getApplicationContext(), "Fields might be empty", Toast.LENGTH_SHORT).show();
            }else {

                Intent intent=new Intent(getApplicationContext(), AddService.class);
                intent.putExtra("name",name);
                intent.putExtra("email",email);
                intent.putExtra("mobile",mobile);
                intent.putExtra("password",password);
                onUpdateStatus();

                startService(intent);


                startActivity(new Intent(getApplicationContext(),DashBoard.class));

//                boolean i=helper.addRecord(name, email, mobile, password);
//                if (i){
//                    name_ed.setText(" ");
//                    email_ed.setText(" ");
//                    phone_ed.setText(" ");
//                    password_ed.setText(" ");
//
//
//                    Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_SHORT).show();
//
//
//                    startActivity(new Intent(getApplicationContext(),DashBoard.class));
//                    finish();
//
//                }else {
//                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
//                }
            }


        });


    }


    @Override
    public void onUpdateStatus() {

    }
}