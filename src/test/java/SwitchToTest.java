import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SwitchToTest {
    public static WebDriver driver;

    @BeforeMethod
    public static void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void switchToTest(){
        driver.get("http://the-internet.herokuapp.com/iframe");
        WebElement iFrame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrame);
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tinymce']/p")));
        WebElement text = driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p"));
        text.clear();
        text.sendKeys("Here Goes");
        System.out.println(driver.findElement(By.xpath("//*[@id=\"tinymce\"]")).getText());
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div[2]/div/div[4]/button[2]")).click();
    }

    @Test
    public void alert(){
        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.xpath("//*[@id=\"alertButton\"]")).click();
        driver.switchTo().alert().accept();
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

}
