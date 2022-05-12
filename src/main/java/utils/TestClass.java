package utils;

import org.testng.annotations.Test;

public class TestClass extends ParentClass{

   LoginPage loPage = new LoginPage();

    @Test
    public void test1() {
        openPage("https://opencart.abstracta.us/index.php?route=account/login");
        loPage.beLogin("zeydin.toprak@hotmail.com", "412412");
    }
}
