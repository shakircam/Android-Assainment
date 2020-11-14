package com.example.assinmentthree;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {

    private static MySharedPreferences mySharedPreferences;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    private MySharedPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences(Config.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    public static MySharedPreferences getPreferences(Context context) {
        if (mySharedPreferences == null) mySharedPreferences = new MySharedPreferences(context);
        return mySharedPreferences;
    }

    public void setUserName(String user_name){
        editor.putString(Config.USER_NAME, user_name);
        editor.apply();
    }

    public String getUserName(){

        return sharedPreferences.getString(Config.USER_NAME, "User Name isn't listed");
    }

    public void setName(String name){
        editor.putString(Config.NAME, name);
        editor.apply();
    }

    public String getName(){

        return sharedPreferences.getString(Config.NAME, "Name isn't listed");
    }

    public void setPhoneNumber(String phone_number){
        editor.putString(Config.PHONE_NUMBER, phone_number);
        editor.apply();
    }
    public String getPhoneNumber(){

        return sharedPreferences.getString(Config.PHONE_NUMBER, "Phone Number isn't listed");
    }

    public void setEmailNumber(String email){
        editor.putString(Config.EMAIL, email);
        editor.apply();
    }

    public String getEmailNumber(){

        return sharedPreferences.getString(Config.EMAIL, "Email Number isn't listed");
    }

    public void setPassword(String password){
        editor.putString(Config.PASSWORD, password);
        editor.apply();
    }
    public String getPassword(){

        return sharedPreferences.getString(Config.PASSWORD, "Password isn't listed");
    }

    public void setRePassword(String re_password){
        editor.putString(Config.PASSWORD, re_password);
        editor.apply();
    }
    public String getRePassword(){

        return sharedPreferences.getString(Config.RE_PASSWORD, "Re Password isn't listed");
    }

    public void setUrl(String url_link){
        editor.putString(Config.URL_LINK, url_link);
        editor.apply();
    }
    public String getUrl(){

        return sharedPreferences.getString(Config.URL_LINK, "Url isn't listed");
    }
}
