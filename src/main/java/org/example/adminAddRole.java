package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class adminAddRole {

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
        WebElement ideaButton = driver.findElement(By.xpath("//button[contains(text(),'Role')]"));
        ideaButton.click();
        Thread.sleep(3000); // Wait for 3 seconds

        // Find the email input field and fill in the email address
        WebElement emailInput = driver.findElement(By.id("exampleInputEmail1"));
        emailInput.sendKeys("user58@gmail.com");
        Thread.sleep(2000);

        // Select the role from the dropdown
        WebElement selectElement = driver.findElement(By.xpath("//select[@class='form-select mb-4']"));
        Select select = new Select(selectElement);
        select.selectByValue("Role_Panelist"); // Change this to the desired role value
        Thread.sleep(3000);

        // Click on the "Add" button
        WebElement addButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        addButton.click();


    }
}
