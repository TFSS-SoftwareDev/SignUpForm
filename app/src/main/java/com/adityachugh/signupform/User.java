package com.adityachugh.signupform;

import java.io.Serializable;

/**
 * Created by AdityaChugh on 15-01-17.
 */
public class User implements Serializable {
    private String mUsername;
    private String mPassword;

    public String getUsername() {
        return mUsername;
    }

    User(String username, String password) {
        mUsername = username;
        mPassword = password;

    }
}
