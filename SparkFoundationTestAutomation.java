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

        System.out.println("$$ Page 1 : Home Page");
        System.out.println("Test Case 1: Check the logo exists");
        WebElement logo = driver.findElement(By.className("navbar-brand"));
        if (logo.isDisplayed()) {
            System.out.println("Logo exists");
        } else {
            System.out.println("Logo does not exist!\n");
        }

        System.out.println("Test Case 2 : Title Verification");
        if (driver.getTitle() != null) {
            System.out.println("Title Verification Successful: " + driver.getTitle());
        } else {
            System.out.println("Title Verification Failed!\n");
        }
        System.out.println("Test Case 3 : Verify Navigation Menu Items");
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

        System.out.println("Test Case 4 : Verify Images on Home Page");
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

        System.out.println("$$ Page 2 : About Us Page > Advisors and Patrons Page");
        System.out.println("Test Case 5 : Advisors and Patrons colour check in About");
        // Click on the "About Us" dropdown menu
        WebElement aboutUs = driver.findElement(By.xpath("//a[text()='About Us']"));
        aboutUs.click();

        // Click on the "Vision, Mission and Values" link
        WebElement AdvisorsAndPatrons = driver.findElement(By.xpath("//a[text()='Advisors and Patrons']"));
        AdvisorsAndPatrons.click();

        // Locate the "About Us" element
        WebElement aboutUsElement = driver.findElement(By.cssSelector(".w3l-blog-list > h4"));

        // Retrieve the CSS value for the color property
        String colorValue = aboutUsElement.getCssValue("color");
        // Check if the color value is "rgba(27, 180, 185, 1)"
        if (colorValue.equals("rgba(27, 180, 185, 1)")) {
            System.out.println("The color of 'About Us' is correct");
        } else {
            System.out.println("The color of 'About Us' is incorrect");
        }

        System.out.println("Test Case 6 : Verify @Facebook is present");
        // Find the "About Us" link and click it
        driver.findElement(By.xpath("//a[text()='About Us']")).click();
        WebElement News = driver.findElement(By.xpath("//a[text()='News']"));
        News.click();

// Find the element with the text "@Facebook"
        WebElement facebookElement = driver.findElement(By.xpath("//span[contains(text(), '@Facebook')]"));

// Check if the element is displayed
        if (facebookElement.isDisplayed()) {
            System.out.println("@Facebook is present on the page.");
        } else {
            System.out.println("@Facebook is not present on the page.");
        }
        System.out.println("$$ Page 3 : Policies and Code Page > Policies Page");
        System.out.println("Test Case 7 : Verify The section contains the correct policy text");
        driver.findElement(By.xpath("//*[@id=\"link-effect-3\"]/ul/li[2]/a")).click();
        WebElement Policies = driver.findElement(By.xpath("//a[text()='Policies']"));
        Policies.click();
        // Find the Conflict of Interest Policy section
        WebElement section = driver.findElement(By.xpath("//h4[contains(text(), 'Conflict of Interest Policy')]/ancestor::div[@class='media-body']"));
        // Verify that the section contains the correct policy text
        // Assert.assertTrue(section.getText().contains("All Board members and staff of TSF are required to disclose any or potential conflict of interest"));
        if (section.getText().contains("All Board members and staff of TSF are required to disclose any or potential conflict of interest")) {
            System.out.println("The section contains the correct policy text");
        } else {
            System.out.println("The section contains invalid policy text");
        }
        System.out.println("$$ Page 4 : Programs Page > Workshops Page");
        System.out.println("Test Case 8 : Verify the program list contains five programs ");
        driver.findElement(By.xpath("//*[@id=\"link-effect-3\"]/ul/li[3]/a")).click();
        WebElement Workshops = driver.findElement(By.xpath("//a[text()='Workshops']"));
        Workshops.click();
        WebElement programList = driver.findElement(By.className("w3l-blog-list"));
        List<WebElement> programs = programList.findElements(By.tagName("li"));
        if (programs.size() == 5) {
            System.out.println("The program list contains five programs");
        } else {
            System.out.println("Tthe program list contains invalid number of programs");
        }
        System.out.println("$$ Page 5 : Contact Us Page ");
        driver.findElement(By.xpath("//*[@id=\"link-effect-3\"]/ul/li[6]/a")).click();
        System.out.println("Test Case 9 : Verify the address ");
        String expectedAddress = "THE HANGAR, NUS ENTERPRISE\n21 HENG MUI KENG TERRACE, SINGAPORE, 119613";
        String actualAddress = driver.findElement(By.cssSelector(".agile_contact_grid_right:nth-child(2) p")).getText();
        if (actualAddress.equals(expectedAddress)) {
            System.out.println("The Address is correct");
        } else {
            System.out.println("The Address is Incorrect");
        }
        System.out.println("Test Case 10 : Verify the address ");
        boolean isMapsDisplayed = driver.findElement(By.cssSelector("div.map-agileits iframe")).isDisplayed();
        if (isMapsDisplayed) {
            System.out.println("Google Map is Displayed");
        } else {
            System.out.println("Google Map is not displayed");
        }
        driver.quit();
    }
}
