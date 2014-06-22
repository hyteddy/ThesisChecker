package com.thesischecker.models;

/**
 * Created by Paweł on 2014-06-21.
 */
public class NewAccountModel {
    public String getInst() {
        return Inst;
    }

    public void setInst(String inst) {
        Inst = inst;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    private String email;
    private String password;
    private String Name;
    private String Surname;
    private String Title;
    private String Inst;
}
