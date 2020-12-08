import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FaceBookHomePage {
    WebDriver driver;

    public FaceBookHomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void publishStatus(String text)
    {
        driver.findElement(By.xpath("//span[contains(text(),'on your mind')]")).click();  //Clicking on the create status textbox
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  //Implicit wait for click event

        // Entering the data on the text field.
        driver.findElement(By.xpath("//div[@contenteditable='true' and @role='textbox' and @spellcheck='true' and @tabindex='0']")).sendKeys(text);
        driver.findElement(By.xpath("//div[contains(text(),'Post') and @role='button']")).submit(); // submit the post
    }
}
