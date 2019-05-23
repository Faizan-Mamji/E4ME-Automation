package TestCases;

import MainImplementation.OtherFunctionFunctionalities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import MainDriver.DriverFile;
import org.testng.annotations.Test;


public class MainTestFile extends DriverFile {

    @BeforeTest
    public void Test() {
        try {
            Epcl_MainDriver();
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
            OtherFunctionFunctionalities objFunctionalities = new OtherFunctionFunctionalities(driver);
            objFunctionalities.request_MedicalClaim();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    @AfterTest
    public void TearDown() {
    }

}
