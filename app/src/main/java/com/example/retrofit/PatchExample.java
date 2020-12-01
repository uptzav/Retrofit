package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PatchExample extends AppCompatActivity {

    private JasonPlaceHolderAPI jsonPlaceHolderApi;

    private TextView textViewPatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patch_example);

        textViewPatch = findViewById(R.id.text_view_patch);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JasonPlaceHolderAPI.class);

        updatePatchPost();  //PATCH
    }


    private void  updatePatchPost(){
        Post post = new Post(12, null, "New Text");
        Call<Post> call = jsonPlaceHolderApi.patchPost(5,post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    textViewPatch.setText("Code: " + response.code());
                    return;
                }
                Post postResponse = response.body();

                String content ="";
                content += "Code: " +  response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "User ID: " + postResponse.getUserId() + "\n";
                content += "Title: " + postResponse.getTitle() + "\n";
                content += "Text: " + postResponse.getText() + "\n\n";

                textViewPatch.setText(content);


            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewPatch.setText(t.getMessage());
            }
        });

    }

}