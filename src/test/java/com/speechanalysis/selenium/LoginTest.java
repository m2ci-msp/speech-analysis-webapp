package com.speechanalysis.selenium;

import org.junit.runner.RunWith;


import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


import static org.junit.Assert.assertEquals;


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
    public void LoginNotExistingUser(){
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:"+port);
        driver.findElement(By.id("username")).sendKeys("roger");
        driver.findElement(By.id("login")).click();
        assertEquals("Your username and/or password is invalid.", driver.findElement(By.id("invaliderror")).getText());
        driver.quit();
    }

    @Test
    public void CreateUser() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:"+port);
        //login page
        driver.findElement(By.id("linksignin")).click();
        //registration page
        driver.findElement(By.id("username")).sendKeys("gooduser");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("passwordconfirm")).sendKeys("password");
        driver.findElement(By.id("submit")).click();
        //index page
        assertEquals("Hello gooduser!", driver.findElement(By.tagName("h1")).getText());
        driver.quit();
    }

    @Test
    public void LoginExistingUser(){
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:"+port);
        driver.findElement(By.id("username")).sendKeys("gooduser");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("login")).click();
        assertEquals("Hello gooduser!", driver.findElement(By.tagName("h1")).getText());
        driver.quit();
    }

    @Test
    public void CreateUserWithoutUsername(){
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:"+port+"/registration");
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("submit")).click();
        assertEquals("This field is required.", driver.findElement(By.tagName("li")).getText());
        driver.quit();
    }

    @Test
    public void CreateUserWithBadSizeUsername() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:"+port+"/registration");
        driver.findElement(By.id("username")).sendKeys("a");
        driver.findElement(By.id("submit")).click();
        assertEquals("Please use between 6 and 32 characters.", driver.findElement(By.tagName("li")).getText());
        driver.quit();
    }
}
