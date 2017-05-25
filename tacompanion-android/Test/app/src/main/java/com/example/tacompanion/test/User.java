package com.example.tacompanion.test;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pedro Lanzagorta M on 11/26/2016.
 */
public class User {

    @SerializedName("mail")
    private String email;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("password")
    private String password;

    public User(String mail,String firstName,String lastName,String password){
        this.email= mail;
        this.firstName=firstName;
        this.lastName=lastName;
        this.password=password;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
