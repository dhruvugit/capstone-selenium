package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class adminAssignIdeas {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize(); // Maximize the browser window



        // Navigate to the URL
        driver.get("http://localhost:3000");


        WebElement getStartedButton = driver.findElement(By.cssSelector("button.text-white.col-5"));
        getStartedButton.click();

        Thread.sleep(5000);

        // Entering details into the login page
        WebElement usernameField = driver.findElement(By.cssSelector("input[placeholder='Username']"));
        WebElement passwordField = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        WebElement signInButton = driver.findElement(By.xpath("//button[text()='Sign In']"));

        // Replace these values with your desired username and password
        String username = "admin";
        String password = "root";

        // Fill in the username and password fields
        usernameField.sendKeys(username);
        Thread.sleep(1000);
        passwordField.sendKeys(password);
        Thread.sleep(1000);

        // Submit the login form
        signInButton.click();
        Thread.sleep(3000);

        // Click the "Idea" button
        WebElement ideaButton = driver.findElement(By.xpath("//button[contains(text(),'Idea')]"));
        ideaButton.click();
        Thread.sleep(3000); // Wait for 3 seconds

        // Click the "Auto Assign Ideas" button
        WebElement autoAssignButton = driver.findElement(By.xpath("//button[contains(text(),'Auto Assign Ideas')]"));
        autoAssignButton.click();
        Thread.sleep(3000); // Wait for 3 seconds

        // Close the browser
//        driver.quit();
    }
}
