import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class CrossBrowser {
    private WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception {
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else {
            throw new Exception("Browser is not correct");
        }

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

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}

