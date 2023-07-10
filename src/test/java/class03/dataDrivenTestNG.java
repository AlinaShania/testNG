package class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class dataDrivenTestNG {
    @DataProvider(name = "invalidCredentials")
    public Object[][] data() {
        Object[][] loginData = {
                {"Admin", "12345", "Invalid credentials"},
                {"ABCD", "Hum@nhrm123", "Invalid credentials"},
                {"Admin", "", "Password cannot be empty"},
                {"", "Hum@nhrm123", "Username cannot be empty"}
        };
        return loginData;
    }
    public static WebDriver driver;

    @BeforeMethod( alwaysRun = true)
    public void OpenAndLaunchBrowser() {
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
                driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.close();
    }
    @Test (dataProvider = "invalidCredentials")
    public void loginWithInvalidCredentials(String user, String pass, String ExpectedMsg){

        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        username.sendKeys(user);
        WebElement pswrd = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        pswrd.sendKeys(pass);
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginBtn.click();
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String actualMsg = errorMsg.getText();

        Assert.assertEquals(actualMsg,ExpectedMsg);
    }

}

