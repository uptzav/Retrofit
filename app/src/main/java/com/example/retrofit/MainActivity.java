package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private JasonPlaceHolderAPI jsonPlaceHolderApi;

    private TextView textViewResult;
private Button btnPost;
    private Button btnPut;
    private Button btnPatch;
    private Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPost = (Button)findViewById(R.id.Postbtn);
        btnPut = (Button)findViewById(R.id.Putbtn);
        btnPatch = (Button)findViewById(R.id.Patchbtn);
        btnDelete = (Button)findViewById(R.id.Deletebtn);










        btnPost.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent i = new Intent(getApplicationContext(), PostExample.class);

                startActivity(i);
            }
        });

        btnPut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent i = new Intent(getApplicationContext(), PutExample.class);

                startActivity(i);
            }
        });

        btnPatch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent i = new Intent(getApplicationContext(), PatchExample.class);

                startActivity(i);
            }
        });


        btnDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent i = new Intent(getApplicationContext(), DeleteExample.class);

                startActivity(i);
            }
        });
    }










}
