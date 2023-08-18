import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest {
    public static WebDriver driver;

    @BeforeMethod
    public static void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void webTablesTest(){
        driver.get("http://techcanvass.com/Examples/webtable.html");

        WebElement table = driver.findElement(By.xpath("//*[@id=\"t01\"]/tbody"));

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        List<WebElement> columns = rows.get(0).findElements(By.tagName("th"));


        for(int i = 2; i <= rows.size(); i++){
            boolean isHonda = false;
            String name = "";

            for (int c = 1; c <= columns.size(); c++){
                if(driver.findElement(By.xpath("//*[@id=\"t01\"]/tbody/tr["+ i +"]/td["+ c +"]")).getText().equalsIgnoreCase("honda")){
                    name = driver.findElement(By.xpath("//*[@id=\"t01\"]/tbody/tr["+ i +"]/td["+ c +"]")).getText();
                    isHonda = true;
                }

                if(c == columns.size() && isHonda) {
                    System.out.println(name + " " + driver.findElement(By.xpath("//*[@id=\"t01\"]/tbody/tr["+ i +"]/td["+ c +"]")).getText());
                }
            }
        }

    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
