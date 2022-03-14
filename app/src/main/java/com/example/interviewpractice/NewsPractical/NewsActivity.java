package com.example.interviewpractice.NewsPractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.interviewpractice.APIClient;
import com.example.interviewpractice.APIInterface;
import com.example.interviewpractice.CategotyShow.CategoryAdapter;
import com.example.interviewpractice.CategotyShow.CategoryModel;
import com.example.interviewpractice.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {

    RecyclerView rvNews;
    APIInterface apiInterface;
    ProgressDialog dialog;
    NewsActivity mContext = NewsActivity.this;
    ArrayList<NewsModel.Article> newsList = new ArrayList<>();
    NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        rvNews = findViewById(R.id.rvNews);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        dialog = new ProgressDialog(mContext);
        dialog.setMessage("Loading...");
        dialog.setCancelable(false);
        getCategoryList();
    }

    private void getCategoryList() {
        dialog.show();
//        String newsUrl = "https://newsapi.org/v2/everything?q=tesla&from=2022-02-28&sortBy=publishedAt&apiKey=" +
//                "dc3c19ab68444bca815e555d99b3a57c";
        String q = "tesla";  String from = "2022-02-28";  String sortBy = "publishedAt";
        String apiKey = "dc3c19ab68444bca815e555d99b3a57c";

        if (isInternetAvailable()) {
            Call<NewsModel> call = apiInterface.getNews(q, from, sortBy, apiKey);
            call.enqueue(new Callback<NewsModel>() {
                @Override
                public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            Log.d("RESPONSE", response.body().toString());
                            dialog.dismiss();
                            int totalResults = response.body().totalResults;
                            newsList = response.body().articles;
//                            for(int i=0;i<newsList.size();i++) {
//                                Log.d("TITLE", newsList.get(i).title);
//                            }

                            adapter = new NewsAdapter(newsList, mContext, totalResults);
                            rvNews.setLayoutManager(new GridLayoutManager(mContext, 1));
                            rvNews.setAdapter(adapter);
                        }
                    } else {
                        dialog.dismiss();
                        Toast.makeText(mContext, response.message(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<NewsModel> call, Throwable t) {
                    dialog.dismiss();
                    Log.d("ERROR", t.getMessage());
                    Toast.makeText(mContext, "Something went wrong", Toast.LENGTH_LONG).show();
                }
            });
        } else {
            dialog.dismiss();
            Toast.makeText(mContext, "Internet is not connected", Toast.LENGTH_LONG).show();
        }
    }

    private boolean isInternetAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            return true;
        } else {
            return false;
        }
    }
}