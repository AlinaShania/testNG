package review;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

public class AbracadabraListener implements ITestListener {

   @Override
   public void onTestStart(ITestResult result) {
       System.out.println("I am test success"+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("test failed"+result.getName());
    }
}
