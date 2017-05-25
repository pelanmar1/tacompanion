package com.example.tacompanion.tacompanion.model;

/**
 * Created by Pedro Lanzagorta M on 11/30/2016.
 */
public class User {

    private static User currentUser=null;
    private String name;
    private String username;
    private String password;
    private String picturePath="";

    private User(){
    }
    private User(String name, String username, String password,String picturePath){
        this.name= name;
        this.username=username;
        this.password=password;
        this.picturePath=picturePath;
    }
    public static User getInstance(String name, String username, String password,String picturePath){
        if(currentUser==null)
            currentUser= new User(name,username,password,picturePath);
        return currentUser;
    }
    public static User getInstance(){
        return currentUser;
    }


    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        User.currentUser = currentUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
}
