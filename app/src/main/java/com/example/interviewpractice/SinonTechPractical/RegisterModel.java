package com.example.interviewpractice.SinonTechPractical;

import com.google.gson.annotations.SerializedName;

public class RegisterModel {
    @SerializedName("message")
    public String message;
    @SerializedName("data")
    public Data data;
    @SerializedName("status")
    public String status;
    @SerializedName("code")
    public String code;

    // Parameters which we have to pass in POST for api call.
    @SerializedName("otp")
    public String otp;
    @SerializedName("social_id")
    public String social_id;
    @SerializedName("register_type")
    public String register_type;
    @SerializedName("term_condition")
    public String term_condition;
    @SerializedName("device_type")
    public String device_type;
    @SerializedName("device_token")
    public String device_token;
    @SerializedName("password")
    public String password;
    @SerializedName("email")
    public String email;
    @SerializedName("mobile_no")
    public String mobile_no;
    @SerializedName("phonecode")
    public String phonecode;
    @SerializedName("name")
    public String name;
    @SerializedName("category_type")
    public String category_type;
    @SerializedName("language")
    public String language;

    public static class Data {
        @SerializedName("authtoken")
        public String authtoken;
        @SerializedName("device_token")
        public String device_token;
        @SerializedName("device_type")
        public String device_type;
        @SerializedName("currendeviceid")
        public String currendeviceid;
        @SerializedName("home_visit_main_amt")
        public String home_visit_main_amt;
        @SerializedName("online_visit_main_amt")
        public String online_visit_main_amt;
        @SerializedName("is_update_fees")
        public String is_update_fees;
        @SerializedName("city_name")
        public String city_name;
        @SerializedName("state_name")
        public String state_name;
        @SerializedName("country_name")
        public String country_name;
        @SerializedName("updated_at")
        public String updated_at;
        @SerializedName("created_at")
        public String created_at;
        @SerializedName("account_no")
        public String account_no;
        @SerializedName("account_name")
        public String account_name;
        @SerializedName("quickblox_name")
        public String quickblox_name;
        @SerializedName("social_id")
        public String social_id;
        @SerializedName("is_verifyotp")
        public String is_verifyotp;
        @SerializedName("is_notification")
        public String is_notification;
        @SerializedName("is_fill_profile")
        public String is_fill_profile;
        @SerializedName("status_by_admin")
        public String status_by_admin;
        @SerializedName("address_proof")
        public String address_proof;
        @SerializedName("profile")
        public String profile;
        @SerializedName("description")
        public String description;
        @SerializedName("longitude")
        public String longitude;
        @SerializedName("latitude")
        public String latitude;
        @SerializedName("country")
        public String country;
        @SerializedName("state")
        public String state;
        @SerializedName("city")
        public String city;
        @SerializedName("pincode")
        public String pincode;
        @SerializedName("address")
        public String address;
        @SerializedName("password")
        public String password;
        @SerializedName("org_password")
        public String org_password;
        @SerializedName("country_code")
        public String country_code;
        @SerializedName("gender")
        public String gender;
        @SerializedName("dob")
        public String dob;
        @SerializedName("contact_no")
        public String contact_no;
        @SerializedName("email")
        public String email;
        @SerializedName("name")
        public String name;
        @SerializedName("category")
        public String category;
        @SerializedName("register_type")
        public String register_type;
        @SerializedName("id")
        public String id;
    }

}
