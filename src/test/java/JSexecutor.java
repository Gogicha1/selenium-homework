import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSexecutor extends beforeAfterMethods{

    @Test
    public void todoItemRemove(){
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html ");
        WebElement todoItem = driver.findElement(By.xpath("//*[@id=\"container\"]/ul/li[3]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(todoItem).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].remove()", todoItem);
    }

    @Test
    public void scroll(){
        driver.get("http://webdriveruniversity.com/Scrolling/index.html ");
        WebElement entriesBox = driver.findElement(By.xpath("//*[@id=\"zone2-entries\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView();", entriesBox);

        Actions actions = new Actions(driver);
        actions.moveToElement(entriesBox).perform();

        String entriesText = "1 Entries";
        String jsString = js.executeScript("return arguments[0].textContent", entriesBox).toString();
        Assert.assertEquals(jsString, entriesText, "Not Valid!");
        System.out.println("Valid Text");

    }

}
