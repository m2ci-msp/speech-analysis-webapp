package com.speechanalysis.selenium;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by plam on 25/08/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@IntegrationTest("server.port:0")
public class LoginTest {
    @Value("${local.server.port}")
    private int port;

    @Test
    public void NotExistingUser(){
        WebDriver driver = new HtmlUnitDriver();
        driver.navigate().to("http://localhost:"+port);
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys("plam");

        driver.quit();
    }
}
