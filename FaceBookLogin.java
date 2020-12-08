import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FaceBookLogin {

    WebDriver driver;

    public FaceBookLogin(WebDriver driver)
    {
        this.driver=driver;
    }

    public void enterEmailID(String email)
    {
        WebElement element=driver.findElement(By.id("email"));
        element.sendKeys(email);
    }

    public void enterPassword(String Passsword)
    {
        WebElement element=driver.findElement(By.id("pass"));
        element.sendKeys((Passsword));
    }

    public void login()
    {
        WebElement element=driver.findElement((By.id("u_0_b")));
        element.click();
    }
}
