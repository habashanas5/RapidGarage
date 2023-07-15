package com.example.study;

public class HelperClass {
    String firstName, email, userID, Password, lastName, myChoice, phone;
    String note;
    float Rate;

    public HelperClass(String ID, String FirstName, String LastName, String password, String email, String phone, String myChoice) {
        this.userID = ID;
        this.firstName = FirstName;
        this.lastName = LastName;
        this.Password = password;
        this.email = email;
        this.phone = phone;
        this.myChoice = myChoice;
    }

    public HelperClass(String ID , String note) {
        this.userID = ID;
        this.note = note;
    }

    public HelperClass(String ID , Float rate) {
        this.userID = ID;
        this.Rate = rate;
    }

    public HelperClass() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return Password;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMyChoice() {
        return myChoice;
    }

    public String getPhone() {
        return phone;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMyChoice(String myChoice) {
        this.myChoice = myChoice;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public float getRate() {
        return Rate;
    }

    public void setRate(float rate) {
        Rate = rate;
    }
}

