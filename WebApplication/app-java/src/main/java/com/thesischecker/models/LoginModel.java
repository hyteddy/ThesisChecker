package com.thesischecker.models;

/**
 * Created by Paweł on 2014-06-20.
 */
public class LoginModel {

    public static final String MODEL_NAME = "loginModel";

    public LoginModel(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public LoginModel() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String login;
    private String password;
}
