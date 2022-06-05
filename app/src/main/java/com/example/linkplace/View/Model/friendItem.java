package com.example.linkplace.View.Model;

public class friendItem {
    private int imageResId;
    private String strName, strAge, strGender, strContent;

    public friendItem(int f_resId, String f_name, String f_age, String f_gender, String f_content) {
        imageResId = f_resId;
        strName = f_name;
        strAge = f_age;
        strGender = f_gender;
        strContent = f_content;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return strName;
    }

    public String getAge() {
        return strAge;
    }

    public String getGender() {
        return strGender;
    }

    public String getContent() {
        return strContent;
    }
}