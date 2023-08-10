import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CommandsTest {

    @Test
    public void TestBrowser() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();
        WebElement enableButton = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
        enableButton.click();
        Thread.sleep(3500);
        WebElement input =  driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
        System.out.println("Input is enabled: " + input.isEnabled());
        WebElement enableText = driver.findElement(By.id("message"));
        System.out.println("Text is displayed: " + enableText.isDisplayed());
        System.out.println("Disable is displayed: " + enableButton.getText().equals("Disable"));
        input.sendKeys("Bootcamp");
        Thread.sleep(1000);
        input.clear();
        driver.quit();

    }

    @Test
    public void getLocation(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();
        int elementA = driver.findElement(By.id("column-a")).getLocation().getY();
        int elementB = driver.findElement(By.id("column-b")).getLocation().getY();
        boolean tF = elementA ==  elementB;
        System.out.println("ElementA = ElementB: " + tF);
        driver.quit();
    }


}
