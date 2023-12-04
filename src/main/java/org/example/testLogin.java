package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class testLogin {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriver driver = new EdgeDriver();
        driver.get("http://localhost:3000");

        // Click the "Get Started" button
        WebElement getStartedButton = driver.findElement(By.cssSelector("button.text-white.col-5"));
        getStartedButton.click();

        Thread.sleep(5000);

        // Entering details into the login page
        WebElement usernameField = driver.findElement(By.cssSelector("input[placeholder='Username']"));
        WebElement passwordField = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        WebElement signInButton = driver.findElement(By.xpath("//button[text()='Sign In']"));

        // Replace these values with your desired username and password
        String username = "user1";
        String password = "root";

        // Fill in the username and password fields
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        // Submit the login form
        signInButton.click();

        Thread.sleep(5000);

//        driver.quit();
    }
}
