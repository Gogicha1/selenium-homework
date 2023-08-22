import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AutoComplete extends beforeAfterMethods{


    @Test
    public void testAutoComplete(){
        driver.get("https://www.google.com/");
        WebDriverWait wait;
        wait = new WebDriverWait(driver, 3);
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Automation");

        List<WebElement> suggestions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"Alh6id\"]/div[1]/div/ul")));

        int count = suggestions.size();
        if (count > 0) {
            for (WebElement suggestion : suggestions) {
                System.out.println(suggestion.getText());
            }
            suggestions.get(count - 1).click();
        } else {
            System.out.println("No suggestions");
        }

    }

}

