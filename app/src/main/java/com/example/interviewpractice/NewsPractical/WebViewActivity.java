package com.example.interviewpractice.NewsPractical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.interviewpractice.R;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;
    //TextView tvWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webView);
//        tvWebView = findViewById(R.id.tvWebView);
//        tvWebView.setText(GlobalVariableClass.webViewUrl);
        Log.d("WEBVIEW", GlobalVariableClass.webViewUrl);

        String url = GlobalVariableClass.webViewUrl;
        //webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url); // load a web page in a web view
    }
}