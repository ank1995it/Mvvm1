package com.example.mvvm;

public class SingletonModel {
    String email;
    SingletonModel(String email)
    {
        this.email=email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
