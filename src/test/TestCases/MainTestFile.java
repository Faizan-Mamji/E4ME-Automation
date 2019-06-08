package TestCases;

import MainImplementation.OtherFunctionFunctionalities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import MainDriver.DriverFile;
import org.testng.annotations.Test;


public class MainTestFile extends DriverFile {

    public AndroidDriver<MobileElement> mainDriver;

    @BeforeTest
    public void Test() {
        try {
            mainDriver=Epcl_MainDriver();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    @Test(priority = 1)
    public void Test2() {
        try {
            MainLoginImplementation();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    @Test(priority = 2)
    public void Test3() {
        try {
            OtherFunctionFunctionalities objFunctionalities = new OtherFunctionFunctionalities(mainDriver);
            //objFunctionalities.request_MedicalClaim();
            objFunctionalities.LTR_Request();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    @AfterTest
    public void TearDown() {
    }

}
