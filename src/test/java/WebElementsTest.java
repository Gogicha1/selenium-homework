import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;


public class WebElementsTest {

    private static WebDriver driver;

    @BeforeMethod
    public static void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public static void afterTest(){
        driver.quit();
    }

    @Test
    public void webElementsTest(){
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement button = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
        for (int i = 0; i < 3; i++){
            button.click();
            System.out.println(i + 1 + " click");
        }
        WebElement buttonElement = driver.findElement(By.cssSelector("div#elements button:nth-child(3)"));
        System.out.println(buttonElement);


        List<WebElement> elementList = driver.findElements(By.cssSelector("[class^='added']"));

        int size = elementList.size();
        System.out.println(elementList.get(size - 1));

        WebElement lastButton = driver.findElement(By.xpath("(//*[contains(@class, 'manually') and text()='Delete'])[last()]"));
        System.out.println("Last Delete Button: " + lastButton);


    }

    @Test
    public void challengingDom(){
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
        WebElement ipsum = driver.findElement(By.xpath("//td[contains(text(), 'Apeirian9')]/preceding-sibling::td[1]"));
        System.out.println(ipsum.getText());

        WebElement dolor = driver.findElement(By.xpath("//td[contains(text(), 'Apeirian9')]/following-sibling::td[1]"));
        System.out.println(dolor.getText());
    }


}
