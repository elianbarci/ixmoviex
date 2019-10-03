package com.example.ixmoviex.domain.interactor.maininteractor;

import android.widget.TextView;

import com.example.ixmoviex.R;
import com.example.ixmoviex.presentation.main.JsonPlaceHolderApi;
import com.example.ixmoviex.presentation.main.model.Post;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainInteractorImpl implements MainInteractor {

    public void bringDataApi(@NotNull TextView textViewResult, @NotNull final String user, @NotNull MainCallback listener) {

        textViewResult = textViewResult.findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

        final TextView finalTextViewResult = textViewResult;
        call.enqueue(new Callback<List<Post>>() {

            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    finalTextViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "USER SIGNED " + user + "\n";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";
                    finalTextViewResult.append(content);
                    System.out.println(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                finalTextViewResult.setText("Ha habido un error al conectarse a la API: " + t.getMessage());
            }
        });

    }
}
