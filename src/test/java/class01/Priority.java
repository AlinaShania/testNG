package class01;

import org.testng.annotations.Test;

public class Priority {
    @Test (priority = 2, groups = "smoke")
    public void ATest (){
        System.out.println("I am A test");
    }
    @Test (priority = 3 )
    public void BTest (){
        System.out.println("I am B test");
    }
    @Test (priority = 1)
    public void CTest (){
        System.out.println("I am C test");
    }
    @Test
    public void DTest (){
        System.out.println("I am D test");
    }
}
