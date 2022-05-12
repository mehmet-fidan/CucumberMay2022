package utils;

import org.openqa.selenium.By;

public class LoginPage  extends ParentClass{



    public static  String url = "https://opencart.abstracta.us/index.php?route=account/login";

    By username = By.id("input-email");
    By password =By.id("input-password");
    By loginButton = By.cssSelector("input[value='Login']");

    public void beLogin(String user, String pass){

        openPage(url);
        sendKeysTo(username,user);
        sendKeysTo(password,pass);
        clickTo(loginButton);

    }

}
