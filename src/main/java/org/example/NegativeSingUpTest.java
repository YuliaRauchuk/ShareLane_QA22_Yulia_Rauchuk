package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class NegativeSingUpTest {
    WebDriver driver;
    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void NegativeZipCodeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();
        WebElement FirstNameInput = driver.findElement(By.name("first_name"));
        FirstNameInput.sendKeys ("Lena");
        WebElement EmailInput = driver.findElement(By.name("email"));
        EmailInput.sendKeys("LeNa@mail.com");
        WebElement ConfirmPasswordInput = driver.findElement(By.name("password2"));
        ConfirmPasswordInput.sendKeys("123654");
        WebElement registerButtonInput = driver.findElement(By.cssSelector("[value=Register]"));
        registerButtonInput.click();
        WebElement errormessage= driver.findElement(By.cssSelector("[class=error_message]"));
        Assert.assertTrue(errormessage.isDisplayed());
    }
}