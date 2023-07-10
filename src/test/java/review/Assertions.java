package review;

import class02.SoftAssertion;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {
    @Test
    public void hardAssertions (){
        //I am getting this info from Webelement on a website
        String actualName = "Alina";
        String actualDesignation = "softwareEngineer";

        //verify that they are correct
        Assert.assertEquals(actualName,"Alina");
        System.out.println("hello I am here");
        Assert.assertEquals(actualDesignation,"softwareEngineer");
    }

    @Test
    public void softAssert (){
        String actualName = "Alina";
        String actualDesignation = "softwareEngineer";

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(actualName,"Alin");
        System.out.println("Hello I am here");
        soft.assertEquals(actualDesignation,"softwareEngineer");
        soft.assertAll();

    }
}
