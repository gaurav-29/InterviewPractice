package com.example.interviewpractice.CategotyShow;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CategoryModel {

    @SerializedName("data")
    @Expose
    public ArrayList<Data> data;
    @SerializedName("success")
    @Expose
    public boolean success;
    @SerializedName("status")
    @Expose
    public int status;
    public static class Data {
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("banner")
        @Expose
        public String banner;
        @SerializedName("icon")
        @Expose
        public String icon;
        @SerializedName("links")
        @Expose
        public Links links;
    }
    public static class Links {
        @SerializedName("products")
        @Expose
        public String products;
        @SerializedName("sub_categories")
        @Expose
        public String subCategories;
    }

//    @SerializedName("status")
//    public int status;
//    @SerializedName("success")
//    public boolean success;
//    @SerializedName("data")
//    public ArrayList<Data> data;
//
//    public static class Data {
//        @SerializedName("links")
//        public Links links;
//        @SerializedName("icon")
//        public String icon;
//        @SerializedName("banner")
//        public String banner;
//        @SerializedName("name")
//        public String name;
//    }
//
//    public static class Links {
//        @SerializedName("sub_categories")
//        public String sub_categories;
//        @SerializedName("products")
//        public String products;
//    }

}
