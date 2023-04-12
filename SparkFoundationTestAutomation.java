/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aditya_Tiwary
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SparkFoundationTestAutomation {
    
    public static void main(String[] args) {
         // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aditya_Tiwary\\Downloads\\driver\\chromedriver.exe");


        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://www.thesparksfoundationsingapore.org/");

        // Wait for the page to load
       Duration timeout = Duration.ofSeconds(10);
       WebDriverWait wait = new WebDriverWait(driver, timeout);

        wait.until(ExpectedConditions.titleContains("The Sparks Foundation"));
       System.out.println("Page 1: Home Page");
        //Test 1 Check the logo exists
        System.out.println("Test Case 1:");
        WebElement logo = driver.findElement(By.className("navbar-brand"));
        if (logo.isDisplayed()) {
            System.out.println("Logo exists");
        }
        else {
        System.out.println("Logo does not exist!\n");
        }
        
        //Test 2: Title Verification
        System.out.println("Test Case 2:");
        if (driver.getTitle() != null) {
        System.out.println("Title Verification Successful: " + driver.getTitle());
        } else {
        System.out.println("Title Verification Failed!\n");
        }
        
        // Test Case 3: Verify Navigation Menu Items
        System.out.println("Test Case 3:");
       List<WebElement> navigationMenuItems = driver.findElements(By.cssSelector(".navbar-nav > li"));
       if (navigationMenuItems.size() == 6) {
       System.out.println("Navigation menu items count is correct");
       List<String> expectedMenuItems = Arrays.asList("About Us", "Policies and Code", "Programs", "LINKS", "Join Us", "Contact Us");
       List<String> actualMenuItems = new ArrayList<>();
       for (WebElement menuItem : navigationMenuItems) {
        actualMenuItems.add(menuItem.getText().trim());
       }
       if (actualMenuItems.equals(expectedMenuItems)) {
        System.out.println("Navigation menu items are correct");
        } else {
        System.out.println("Navigation menu items are incorrect");
        }
      } else {
      System.out.println("Navigation menu items count is incorrect");
      }
      // Test Case 4: Verify Images on Home Page
      List<WebElement> images = driver.findElements(By.tagName("img"));
      
      if (images.size() == 1) {
      System.out.println("Image count is correct");
      for (WebElement image : images) {
        if (image.getAttribute("src").isEmpty()) {
            System.out.println("Image source is empty");
        } else {
            System.out.println("Image source is not empty");
        }
        }
       } else {
       System.out.println("Image count is incorrect");
       }
        // Close the browser
        driver.quit();
    }
}
