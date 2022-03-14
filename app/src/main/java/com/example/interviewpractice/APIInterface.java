package com.example.interviewpractice;

import com.example.interviewpractice.CategotyShow.CategoryModel;
import com.example.interviewpractice.NewsPractical.NewsModel;
import com.example.interviewpractice.PaginationTest.Users;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface APIInterface {

    @GET("categories")
    Call<CategoryModel> getCategories();

    @GET("leads/get")
    Call<Users.Data2> getUsers(@Header("Authorization") String token);

//    @GET
//    Call<NewsModel> getNews(@Url String newsUrl);

    @GET("everything")
    Call<NewsModel> getNews(@Query("q") String q, @Query("from") String from,
                             @Query("sortBy") String sortBy, @Query("apiKey") String apiKey);
}
