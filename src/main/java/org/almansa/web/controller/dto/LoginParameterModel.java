package org.almansa.web.controller.dto;

public class LoginParameterModel {
    String loginId;
    String password;
    
    public String getLoginId() {
        return loginId;
    }
    public void setLoginId(String loginId) {
        this.loginId = loginId;         
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
