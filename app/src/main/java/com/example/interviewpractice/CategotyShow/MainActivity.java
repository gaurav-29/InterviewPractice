package com.example.interviewpractice.CategotyShow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.interviewpractice.APIClient;
import com.example.interviewpractice.APIInterface;
import com.example.interviewpractice.R;
import com.example.interviewpractice.databinding.ActivityMainBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    MainActivity mContext = MainActivity.this;
    ActivityMainBinding mBinding;
    ProgressDialog dialog;
    APIInterface apiInterface;
    CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(mContext, R.layout.activity_main);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        dialog = new ProgressDialog(mContext);
        dialog.setMessage("Loading...");
        dialog.setCancelable(false);
        getCategoryList();
    }

    private void getCategoryList() {
        dialog.show();
        if (isInternetAvailable()) {
            Call<CategoryModel> call = apiInterface.getCategories();
            call.enqueue(new Callback<CategoryModel>() {
                @Override
                public void onResponse(Call<CategoryModel> call, Response<CategoryModel> response) {
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            Log.d("RESPONSE", response.body().toString());
                            dialog.dismiss();
                            CategoryModel model = response.body();
                            int status = model.status;
                            boolean success = model.success;
                            ArrayList<CategoryModel.Data> dataList = model.data;

                            Log.d("DATALIST", dataList.toString());

                            adapter = new CategoryAdapter(dataList, mContext);
                            mBinding.rvCategory.setLayoutManager(new GridLayoutManager(mContext, 2));
                            mBinding.rvCategory.setAdapter(adapter);
                        }
                    } else {
                        dialog.dismiss();
                        Toast.makeText(mContext, response.message(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<CategoryModel> call, Throwable t) {
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