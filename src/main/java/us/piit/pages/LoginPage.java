package us.piit.pages;

import us.piit.base.CommonAPI;

public class LoginPage extends CommonAPI {
    String userNameField = "#jfj";
    String passwordField = "";
    String loginBtn = "";
    String errorMessage = "";

    //reusable methods

    public void enterUsername(String username){
        type(userNameField,username);
    }
    public void enterPassword() {
        type(passwordField, "");
    }
    public void clickOnLoginBtn(){
        type(loginBtn,"");
    }
    public void getErrorMessage(){
        type(errorMessage,"");
    }



}
