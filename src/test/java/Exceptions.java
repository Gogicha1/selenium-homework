import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exceptions{
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
    }

    @Test
    public void exceptions() {
        driver.get("https://demoqa.com/alerts ");
        WebElement button = driver.findElement(By.id("timerAlertButton"));
        button.click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, 4);
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();

        } catch (TimeoutException e) {
            System.out.println("Timeout!");

        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        }
        catch (NoAlertPresentException e){
            System.out.println("No alert");
        }

        try {
            driver.navigate().refresh();
            button.click();
        }
        catch (StaleElementReferenceException e){
            System.out.println(e.getMessage());
        }
    }

}
