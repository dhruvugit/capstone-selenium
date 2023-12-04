package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class adminAssignToOtherPanelist {

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

        // Iterate through the collapse buttons
        for (int i = 47; i < 49; i++) {
            String buttonXpath = "//div[@data-bs-target='#collapseWidthExample" + i + "']";
            WebElement collapseButton = driver.findElement(By.xpath(buttonXpath));
            collapseButton.click();
            Thread.sleep(2000); // Adjust for the content to expand

            // Click on "Assign to Other" button
            WebElement assignButton = driver.findElement(By.xpath("//div[@data-bs-target='#staticBackdrop']"));
            assignButton.click();
            Thread.sleep(2000); // Adjust for assignment modal to appear

            // Refresh the elements after opening the modal
            assignButton = collapseButton.findElement(By.xpath("//div[@data-bs-target='#staticBackdrop']"));


            // Click on "Assign" button in the modal
            WebElement assignModalButton = driver.findElement(By.xpath("//button[@data-bs-dismiss='modal' and @class='btn btn-primary ms-auto']"));
            assignModalButton.click();
            Thread.sleep(2000); // Adjust for confirmation action

            // Close the collapse button
            collapseButton.click();
            Thread.sleep(2000); // Adjust for the content to collapse
        }

        // Close the browser
        //driver.quit();
    }
}
