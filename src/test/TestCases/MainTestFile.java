package TestCases;

import MainImplementation.OtherFunctionFunctionalities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import MainDriver.DriverFile;
import org.testng.annotations.Test;

import java.io.IOException;

public class MainTestFile extends DriverFile {

    @BeforeTest
    public void Test() throws IOException {
        Epcl_MainDriver();
    }

    /*@Test(priority = 0)
    public void Test2() throws InterruptedException, IOException {
        MainLoginImplementation();
    }*/

    @Test(priority = 1)
    public void Test3() throws IOException {
        OtherFunctionFunctionalities objFunctionalities = new OtherFunctionFunctionalities(driver);
        objFunctionalities.request_MedicalClaim();
    }

    @AfterTest
    public void TearDown() {
    }

}
