package com.linkple.linkplace.View.Model;

public class LinkData {
    double lat;
    double lon;
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
    String uid;
    String introduce;
    String career;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public LinkData(){} // 생성자 메서드





    //값을 추가할때 쓰는 함수, MainActivity에서 addanimal함수에서 사용할 것임.
    public LinkData(double lat, double lon, String name, String birth, String gender, String job, String charactor, String hobby, String wantfriend, String ImageUrl, String education,
                       String religion, String drink, String smoke, String pet, String uid, String introduce, String career){
        this.lat = lat;
        this.lon = lon;
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
        this.uid = uid;
        this.introduce = introduce;
        this.career = career;
    }
}