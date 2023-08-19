import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class beforeAfterMethods {
    public static WebDriver driver;
    public beforeAfterMethods() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @AfterTest
    public void afterMethod(){
        driver.quit();
    }


}
