package com.example.interviewpractice.SinonTechPractical;

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
import com.example.interviewpractice.CategotyShow.CategoryAdapter;
import com.example.interviewpractice.CategotyShow.CategoryModel;
import com.example.interviewpractice.R;
import com.example.interviewpractice.databinding.ActivityRegisterBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    RegisterActivity mContext = RegisterActivity.this;
    ActivityRegisterBinding binding;
    ProgressDialog dialog;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(mContext, R.layout.activity_register);

        dialog = new ProgressDialog(mContext);
        dialog.setMessage("Loading...");
        dialog.setCancelable(false);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        signUp();
    }
    private void signUp() {
        dialog.show();

        Map<String, String> params = new HashMap<>();
        params.put("language","1");
        params.put("category_type","8");
        params.put("name","abc");
        params.put("phonecode","+91");
        params.put("mobile_no","9898461470");  // Change mobile number before each run.
        params.put("email","abc11@gmail.com"); // Change email before each run.
        params.put("password","123456");
        params.put("device_token","F0990162B3A4C8CDC7DA629BD854E5C67C1E2006FE34A44E8FF028B2928C1113");
        params.put("device_type","I");
        params.put("term_condition","1");
        params.put("register_type","NORMAL");
        params.put("social_id","001624.19097085012a4a19a663a54fd1a2288f.1213");
        params.put("otp","1234");

        if (isInternetAvailable()) {
            Call<RegisterModel> call = apiInterface.registerUser(params);
            call.enqueue(new Callback<RegisterModel>() {
                @Override
                public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            Log.d("RESPONSE", response.body().toString());
                            dialog.dismiss();
                            RegisterModel model = response.body();
                            Toast.makeText(mContext, model.message,Toast.LENGTH_LONG).show();
                        }
                    } else {
                        dialog.dismiss();
                        Toast.makeText(mContext, response.message(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<RegisterModel> call, Throwable t) {
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