package com.speechanalysis.selenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by plam on 25/08/16.
 */
public class LoginTest {
    private int port = 8080;
    @Test
    public void NotExistingUser(){
        WebDriver driver = new HtmlUnitDriver();
        driver.navigate().to("http://localhost:"+port);
        WebElement element = driver.findElement(By.id("username"));
        element.sendKeys("plam");

        driver.quit();
    }
}
