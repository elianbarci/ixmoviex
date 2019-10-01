package com.example.ixmoviex.presentation.main;

import com.example.ixmoviex.presentation.main.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();

}
