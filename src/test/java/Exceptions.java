import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Exceptions extends beforeAfterMethods{

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
