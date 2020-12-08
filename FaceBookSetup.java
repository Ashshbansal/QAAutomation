import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FaceBookSetup {

    String  DriverKey="webdriver.chrome.driver";
    String DriverPath="C:\\Users\\ashis\\Downloads\\chromedriver_win32\\chromedriver.exe"; //Mention the Chrome driver path
    WebDriver driver;
    FaceBookLogin objectFaceBookLogin;  //Object for FacebookLogin class
    FaceBookHomePage objectFaceBookHomePage;  // Object for FaceBookHomepage class
    String Username="Ashishrocks.bansal@gmail.com";
    String Password="iloveTennis@12";
    String status_text="Hello World";
    @BeforeTest
    public void setup(){
        System.setProperty(DriverKey,DriverPath);

        // The below code is to select the block button when the pop up appears on Chrome to send Notifications
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        //Intialising the Web Driver
         driver=new ChromeDriver(options);
         driver.get("https://www.facebook.com/");

         //implicit timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    // Login to Facebook
    @Test (priority = 1)
    public void loginToFacebook(){
        objectFaceBookLogin=new FaceBookLogin(driver);
        objectFaceBookLogin.enterEmailID(Username);
        objectFaceBookLogin.enterPassword(Password);
        objectFaceBookLogin.login();

        // if login is successfull then below expression would raise any exception, but if it is not it will raise NosuchElementException and test case will fail.
        driver.findElement(By.xpath("//div[@role='button' and @aria-label='Account']"));
    }
    // Post Status
    @Test(dependsOnMethods = { "loginToFacebook" })
    public void postStatus(){
        objectFaceBookHomePage=new FaceBookHomePage(driver);
        objectFaceBookHomePage.publishStatus(status_text);
    }
}
