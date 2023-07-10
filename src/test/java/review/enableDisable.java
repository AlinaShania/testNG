package review;

import org.testng.annotations.Test;

public class enableDisable {
    @Test (enabled = false)
    public void hello(){
        System.out.println("hello");
    }

    @Test
    public void functA (){
        System.out.println(5/1);
    }
    @Test (dependsOnMethods = "functA")
    public void functB (){
        System.out.println("I am dependent on A");
    }
}
