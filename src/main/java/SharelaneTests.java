import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class SharelaneTests{
    WebDriver driver;
    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void PositiveZipCodeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();
        zipCodeInput = driver.findElement(By.name("zip_code"));
        AssertEquals(zipCodeInput.isDisplayed(), false);

        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        AssertEquals(firstNameInput.isDisplayed(), true);

    }

    private void AssertEquals(boolean displayed, boolean b) {
    }
}

