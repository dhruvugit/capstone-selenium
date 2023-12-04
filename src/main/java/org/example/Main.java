package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        //System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("http://sampleapp.tricentis.com/101/");
        driver.manage().window().maximize();
        WebElement automobile =
                driver.findElement(By.linkText("Automobile"));
        automobile.click();
        Thread.sleep(5000);
        driver.quit();

    }
}