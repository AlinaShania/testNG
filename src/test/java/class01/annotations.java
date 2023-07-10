package class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class annotations {

    @Test
    public void AFirstTestCase(){
        System.out.println("hello I am the first test case");
    }
    @Test
    public void BSecondTestCase(){
        System.out.println("I am the second test case");
    }

    @Test
    public void CThirdTestCase (){
        System.out.println("I am the third test case");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method");
    }

    @AfterMethod
    public void afterMethod (){
        System.out.println("I am after method");
    }

}
