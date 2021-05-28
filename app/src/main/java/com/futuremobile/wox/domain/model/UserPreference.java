package com.futuremobile.wox.domain.model;

public class UserPreference {

    private int idUser;
    private String token;
    private String email;
    private String name;
    private int rol;
    private boolean logged;


    public UserPreference(int idUser,String token, String email,
                          String name, int rol, boolean logged) {
        this.idUser = idUser;
        this.token = token;
        this.email = email;
        this.name = name;
        this.rol = rol;
        this.logged = logged;
    }


    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }
}
