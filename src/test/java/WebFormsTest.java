import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebFormsTest {
    private static WebDriver driver;

    @BeforeMethod
    public static void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void webFormsTest(){
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

        Select name = new Select(driver.findElement(By.xpath("//*[@id=\"dropdowm-menu-1\"]")));
        name.selectByValue("c#");
        System.out.println("Option: " + name.getFirstSelectedOption().getText());


        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for(WebElement element : checkboxes){
            if(!element.isSelected()){
                element.click();
                System.out.println("checkbox is clicked!");
            }
        }

        WebElement yellowButton = driver.findElement(By.cssSelector("input[value='yellow']"));
        yellowButton.click();
        if(yellowButton.isSelected()) System.out.println("Yellow button clicked");

        WebElement orange = driver.findElement(By.cssSelector("option[value='orange']"));
        if (!orange.isEnabled()) {
            System.out.println("Orange is disabled");
        } else {
            System.out.println("Orange is enabled");
        }


    }


//    @AfterMethod
//    public static void afterTest(){
//        driver.quit();
//    }


}
