package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class adminPanelJudgeReminder {

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


        // Click on the "Panelist" button
        WebElement panelistButton = driver.findElement(By.xpath("//button[text()='Panelist']"));
        panelistButton.click();
        Thread.sleep(3000); // Adjust as needed for panelist list to appear

        WebElement sendReminderButton = driver.findElement(By.xpath("//button[text()='Send Reminder']"));
        sendReminderButton.click();
        Thread.sleep(3000);

        WebElement judgeButton = driver.findElement(By.xpath("//button[text()='Judge']"));
        judgeButton.click();
        Thread.sleep(3000);


        WebElement sendReminderButton2 = driver.findElement(By.xpath("//button[text()='Send Reminder']"));
        sendReminderButton2.click();
        Thread.sleep(3000);


    }
}
