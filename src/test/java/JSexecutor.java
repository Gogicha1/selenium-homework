import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSexecutor{

    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
    }

    @Test
    public void todoItemRemove(){
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html ");
        WebElement todoItem = driver.findElement(By.xpath("//*[@id=\"container\"]/ul/li[3]"));
        WebElement removeButton = driver.findElement(By.xpath("//*[@id=\"container\"]/ul/li[3]/span/i"));
        Actions actions = new Actions(driver);
        actions.moveToElement(todoItem).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", removeButton);
    }

    @Test
    public void scroll(){
        driver.get("http://webdriveruniversity.com/Scrolling/index.html ");
        WebElement entriesBox = driver.findElement(By.xpath("//*[@id=\"zone2\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView();", entriesBox);

        js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover'))", entriesBox);

//        Actions actions = new Actions(driver);
//        actions.moveToElement(entriesBox).perform();

        String entriesText = "1 Entries";
        String jsString = js.executeScript("return arguments[0].textContent", entriesBox).toString().trim();
        Assert.assertEquals(jsString, entriesText, "Not Valid!");
        System.out.println("Valid Text");

    }

    @AfterTest
    public void afterMethod(){
        driver.quit();
    }

}
