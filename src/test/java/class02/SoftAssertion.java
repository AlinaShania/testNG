package class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.CommonMethods;

import java.time.Duration;

public class SoftAssertion extends CommonMethods {

    @BeforeMethod (alwaysRun = true)
    public void OpenBrowserAndNavigate (){

        openBrowserAndNavigateToURL("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login" , "chrome");

    }

    @AfterMethod (alwaysRun = true)
    public void quitBrowser (){

        driver.quit();
    }

    @Test (groups = "regression")
    public void verifyTheWelcomeMessage(){
//        /        send username
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("Admin");
//       send password
        WebElement password = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        password.sendKeys("Hum@nhrm123");

//        click login
        WebElement loginBtn=driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginBtn.click();

        WebElement welcomeMSG = driver.findElement(By.id("welcome"));
        String welcomeText = welcomeMSG.getText();

        boolean isDisplayed = welcomeMSG.isDisplayed();
        SoftAssert soft = new SoftAssert ();
        soft.assertTrue(isDisplayed);


        //        verify the message is welcome admin
        String actualWelcomeText = welcomeMSG.getText();
        String expectedWelcomeText="Welcome Admin";
        soft.assertEquals(actualWelcomeText,expectedWelcomeText);
        //  assert all the assertions that have been made
        soft.assertAll();
    }
}

