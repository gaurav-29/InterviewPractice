package com.example.interviewpractice.NewsPractical;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsModel {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("totalResults")
    @Expose
    public int totalResults;
    @SerializedName("articles")
    @Expose
    public ArrayList<Article> articles;

    @Override
    public String toString() {
        return "NewsModel{" +
                "status='" + status + '\'' +
                ", totalResults=" + totalResults +
                ", articles=" + articles +
                '}';
    }

    public static class Article {
        @SerializedName("source")
        @Expose
        public Source source;
        @SerializedName("author")
        @Expose
        public String author;
        @SerializedName("title")
        @Expose
        public String title;
        @SerializedName("description")
        @Expose
        public String description;
        @SerializedName("url")
        @Expose
        public String url;
        @SerializedName("urlToImage")
        @Expose
        public String urlToImage;
        @SerializedName("publishedAt")
        @Expose
        public String publishedAt;
        @SerializedName("content")
        @Expose
        public String content;

        @Override
        public String toString() {
            return "Article{" +
                    "source=" + source +
                    ", author='" + author + '\'' +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", url='" + url + '\'' +
                    ", urlToImage='" + urlToImage + '\'' +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }
    }
    public static class Source {
        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("name")
        @Expose
        public String name;

        @Override
        public String toString() {
            return "Source{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
