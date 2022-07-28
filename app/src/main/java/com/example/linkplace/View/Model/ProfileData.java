package com.example.linkplace.View.Model;

public class ProfileData {
    String name;
    String birth;
    String gender;
    String job;
    String charactor;
    String hobby;
    String wantfriend;
    String ImageUrl;
    String education;
    String religion;
    String drink;
    String smoke;
    String pet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCharactor() {
        return charactor;
    }

    public void setCharactor(String charactor) {
        this.charactor = charactor;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getWantfriend() {
        return wantfriend;
    }

    public void setWantfriend(String wantfriend) {
        this.wantfriend = wantfriend;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public ProfileData(){} // 생성자 메서드




    //값을 추가할때 쓰는 함수, MainActivity에서 addanimal함수에서 사용할 것임.
    public ProfileData(String name, String birth, String gender, String job, String charactor, String hobby, String wantfriend, String ImageUrl, String education,
                       String religion, String drink, String smoke, String pet){
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.job = job;
        this.charactor = charactor;
        this.hobby = hobby;
        this.wantfriend = wantfriend;
        this.ImageUrl = ImageUrl;
        this.education = education;
        this.religion = religion;
        this.drink = drink;
        this.smoke = smoke;
        this.pet = pet;
    }
}