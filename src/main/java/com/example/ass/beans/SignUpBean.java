package com.example.ass.beans;


public class SignUpBean {

    private String username;

    private String fullname;
    private String email;
    private String password;


    public SignUpBean(String username, String fullname, String email, String password, String photo, int activated,
                      String admin) {
        super();
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
    }

    public SignUpBean() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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


}