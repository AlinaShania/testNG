package class01;

import org.testng.annotations.Test;

public class DependsOnMethod {
    @Test
    public void Login (){
        System.out.println("I am testing login");
    }

    @Test (dependsOnMethods = {"Login"})
    public void TestTheDashBoardPage (){
        System.out.println("I am testing dashboard page");
    }
}
