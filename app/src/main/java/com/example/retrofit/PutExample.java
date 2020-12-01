package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PutExample extends AppCompatActivity {


    private JasonPlaceHolderAPI jsonPlaceHolderApi;

    private TextView textViewPut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_example);

        textViewPut = findViewById(R.id.text_view_put);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JasonPlaceHolderAPI.class);

        updatePost(); //PUT


    }


    private void  updatePost(){
        Post post = new Post(12, null, "New Text");
        Call<Post> call = jsonPlaceHolderApi.putPost(5,post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    textViewPut.setText("Code: " + response.code());
                    return;
                }
                Post postResponse = response.body();

                String content ="";
                content += "Code: " +  response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "User ID: " + postResponse.getUserId() + "\n";
                content += "Title: " + postResponse.getTitle() + "\n";
                content += "Text: " + postResponse.getText() + "\n\n";

                textViewPut.setText(content);


            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewPut.setText(t.getMessage());
            }
        });

    }

    }




