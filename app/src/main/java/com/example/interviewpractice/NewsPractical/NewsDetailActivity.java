package com.example.interviewpractice.NewsPractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.interviewpractice.R;

public class NewsDetailActivity extends AppCompatActivity {

    NewsDetailActivity context = NewsDetailActivity.this;
    ImageView ivImage;
    TextView tvAuthor,tvTitle,tvDescription;
    Button btnArticle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        ivImage = findViewById(R.id.ivImage);
        tvAuthor = findViewById(R.id.tvAuthor);
        tvTitle = findViewById(R.id.tvTitle);
        tvDescription = findViewById(R.id.tvDescription);
        btnArticle = findViewById(R.id.btnArticle);

        String image = getIntent().getStringExtra("image");
        String author = getIntent().getStringExtra("author");
        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        GlobalVariableClass.webViewUrl = getIntent().getStringExtra("url");

        Glide.with(context).load(image).centerCrop().placeholder(R.drawable.img_placeholder).into(ivImage);
        tvAuthor.setText("By : " + author);
        tvTitle.setText(title);
        tvDescription.setText(description);

        btnArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, WebViewActivity.class);
                startActivity(i);
            }
        });
    }
}