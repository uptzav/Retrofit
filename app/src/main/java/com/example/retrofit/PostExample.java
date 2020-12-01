package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostExample extends AppCompatActivity {

    private JasonPlaceHolderAPI jsonPlaceHolderApi;

    private TextView textViewPost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_example);

        textViewPost = findViewById(R.id.text_view_post);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JasonPlaceHolderAPI.class);

        createPost();   //POST


    }

    private  void   createPost(){

        Post post = new Post(23, "New title", "New Text");

        Call<Post> call = jsonPlaceHolderApi.createPost(post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    textViewPost.setText("Code: " + response.code());
                    return;
                }
                Post postResponse = response.body();

                String content ="";
                content += "Code: " +  response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "User ID: " + postResponse.getUserId() + "\n";
                content += "Title: " + postResponse.getTitle() + "\n";
                content += "Text: " + postResponse.getText() + "\n\n";

                textViewPost.setText(content);


            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewPost.setText(t.getMessage());
            }
        });
    }
}