package com.linkple.linkplace.View.Model;

public class friendItem {
    private int imageResId;
    private String strName, strAge, strGender, strContent, strJob, strCharactor, strHobby, strWantfriend, strImageUrl, strEducation, strReligion,
    strDrink, strSmoke, strPet, strCareer, strKey;

    // name, age, gender, job, charactor, hobby, wantfriend, ImageUrl, education, religion, drink, smoke, pet, introduce, career;
    public friendItem(int f_resId, String f_name, String f_age, String f_gender, String f_content, String f_job, String f_charactor, String f_hobby,
                      String f_wantfriend, String f_ImageUrl, String f_education, String f_religion, String f_drink, String f_smoke,
                      String f_pet, String f_career, String f_key) {
        imageResId = f_resId;
        strName = f_name;
        strAge = f_age;
        strGender = f_gender;
        strContent = f_content;
        strJob = f_job;
        strCharactor = f_charactor;
        strHobby = f_hobby;
        strWantfriend = f_wantfriend;
        strImageUrl = f_ImageUrl;
        strEducation = f_education;
        strReligion = f_religion;
        strDrink = f_drink;
        strSmoke = f_smoke;
        strPet = f_pet;
        strCareer  = f_career;
        strKey = f_key;
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

    public String getStrName() {
        return strName;
    }

    public String getStrAge() {
        return strAge;
    }

    public String getStrGender() {
        return strGender;
    }

    public String getStrContent() {
        return strContent;
    }

    public String getStrJob() {
        return strJob;
    }

    public String getStrCharactor() {
        return strCharactor;
    }

    public String getStrHobby() {
        return strHobby;
    }

    public String getStrWantfriend() {
        return strWantfriend;
    }

    public String getStrImageUrl() {
        return strImageUrl;
    }

    public String getStrEducation() {
        return strEducation;
    }

    public String getStrReligion() {
        return strReligion;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public String getStrSmoke() {
        return strSmoke;
    }

    public String getStrPet() {
        return strPet;
    }

    public String getStrCareer() {
        return strCareer;
    }

    public String getStrKey() {
        return strKey;
    }
}