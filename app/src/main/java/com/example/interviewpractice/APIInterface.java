package com.example.interviewpractice;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("categories")
    Call<CategoryModel> getCategories();

    @GET("leads/get")
    Call<Users.Data2> getUsers(@Header("Authorization") String token);
}
