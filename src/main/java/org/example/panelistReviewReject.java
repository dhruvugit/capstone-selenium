package org.example;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class panelistReviewReject {

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
        String username = "panelist2";
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
        WebElement reviewButton = driver.findElement(By.xpath("//a[contains(@class, 'btn') and contains(text(), 'Review')]"));
        reviewButton.click();
        Thread.sleep(3000); // Wait for 3 seconds



        WebElement firstApproveButton = driver.findElement(By.xpath("//button[@data-bs-target='#reject']"));
        firstApproveButton.click();
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        // Explicit wait for the "Approve" button within the modal
        WebElement approveButtonInModal = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-bs-dismiss='modal' and text()='Reject']")));
        approveButtonInModal.click();
        Thread.sleep(5000);


        // Close the browser
        driver.quit();
    }
}
