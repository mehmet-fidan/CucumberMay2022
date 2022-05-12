package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParentClass {

  public static WebDriver driver;
  public static WebDriverWait wait ;

    public void openPage (String url){
     driver = Driver.getDriver();
     wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      driver.get(url);
  }

  public void sendKeysTo (By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
  }

  public void clickTo(By locator){
      wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
  }


}
