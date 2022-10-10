package com.example.firebasetextimagedatafetchingtorecyclerview;

public class FirebaseResponseModel {

    String name,password,contact_no,imgLinks,age;

    public FirebaseResponseModel() {
    }

    public FirebaseResponseModel(String name, String password, String contact_no, String imgLinks, String age) {
        this.name = name;
        this.password = password;
        this.contact_no = contact_no;
        this.imgLinks = imgLinks;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getImgLinks() {
        return imgLinks;
    }

    public void setImgLinks(String imgLinks) {
        this.imgLinks = imgLinks;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
