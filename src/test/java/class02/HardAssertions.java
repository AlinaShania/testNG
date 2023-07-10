package class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.CommonMethods;

import java.time.Duration;

public class HardAssertions extends CommonMethods {

    //go to hrms
    //enter username, wrong password
    //click on login
    //verify that the error message is displayed


    @BeforeMethod (alwaysRun = true)
    public void OpenBrowserAndNavigate (){

        openBrowserAndNavigateToURL("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login", "chrome");

    }

    @AfterMethod (alwaysRun = true)
    public void quitBrowser (){
        driver.quit();
    }

    @Test (groups = "smoke")
    public void VerifyTheErrorMessage(){
        WebElement userName= driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement password=driver.findElement(By.xpath("//input[@name='txtPassword']"));
        password.sendKeys("Hum@nhrmfff123");
        WebElement loginBtn=driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginBtn.click();

       WebElement errorMsg = driver.findElement(By.id("spanMessage"));

        String actualErrorMessage = errorMsg.getText();
        String expectedErrorMessage = "Invalid credentials";

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

        boolean errorMsgIsDisplayed = errorMsg.isDisplayed();
        Assert.assertTrue(errorMsgIsDisplayed);
    }


}
