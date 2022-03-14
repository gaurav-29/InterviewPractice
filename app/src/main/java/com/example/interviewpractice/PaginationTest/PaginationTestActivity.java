package com.example.interviewpractice.PaginationTest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.interviewpractice.APIClient;
import com.example.interviewpractice.APIInterface;
import com.example.interviewpractice.R;
import com.example.interviewpractice.databinding.ActivityPaginationTestBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaginationTestActivity extends AppCompatActivity {

    ActivityPaginationTestBinding mBinding;
    PaginationTestActivity mContext = PaginationTestActivity.this;
    int s=1,  limit=10;
    APIInterface apiInterface;
    UsersAdapter adapter;
    ArrayList<Users.Data2> userList = new ArrayList<>();
    NestedScrollView nestedSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagination_test);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        nestedSV = findViewById(R.id.nestedSV);

        getUserDetails();
//        nestedSV.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
//                    s++;
//                    getUserDetails(s, limit);
//                }
//            }
//        });
//        mBinding.nestedSV.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
//                    page++;
//                    getUserDetails(s, page);
//                }
//            }
//        });
    }
    public void getUserDetails(){
//        if (s > page) {
//            Toast.makeText(this, "That's all the data..", Toast.LENGTH_SHORT).show();
//            return;
//        }
        String token = "3ad39140-6478-4910-9628-91553246f6ae";
        Call<Users.Data2> call = apiInterface.getUsers(token);
        call.enqueue(new Callback<Users.Data2>() {
            @Override
            public void onResponse(Call<Users.Data2> call, Response<Users.Data2> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        Log.d("RESPONSE", response.body().toString());
                        Users.Data2 model = response.body();
                        adapter = new UsersAdapter(userList, mContext);
                        mBinding.rvUserdata.setLayoutManager(new GridLayoutManager(mContext, 1));
                        mBinding.rvUserdata.setAdapter(adapter);
                    }
                } else {
                    Toast.makeText(mContext, response.message(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Users.Data2> call, Throwable t) {
                Log.d("ERROR", t.getMessage());
                Toast.makeText(mContext, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        });
    }
}