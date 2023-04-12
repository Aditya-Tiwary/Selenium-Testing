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

public class SparkFoundationTestAutomation {
    
    public static void main(String[] args) {
         // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aditya_Tiwary\\Downloads\\driver\\chromedriver.exe");


        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://thesparksfoundation.sg");

        // Wait for the page to load
      Duration timeout = Duration.ofSeconds(10);
WebDriverWait wait = new WebDriverWait(driver, timeout);

        wait.until(ExpectedConditions.titleContains("The Sparks Foundation"));

        // Check the logo exists
        WebElement logo = driver.findElement(By.className("navbar-brand"));
        if (logo.isDisplayed()) {
            System.out.println("Logo exists");
        }

        // Check the navigation bar appears
        WebElement navBar = driver.findElement(By.id("navbar"));
        if (navBar.isDisplayed()) {
            System.out.println("Navigation bar appears");
        }

        // Check the name on about us page is correct
        driver.findElement(By.linkText("About Us")).click();
        WebElement aboutUs = driver.findElement(By.tagName("h4"));
        if (aboutUs.getText().equals("About Us")) {
            System.out.println("Name on About Us page is correct");
        }

        // Check other elements on different pages
        // ...

        // Close the browser
        driver.quit();
    }
}
