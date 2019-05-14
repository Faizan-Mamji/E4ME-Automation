package ProjectPom;

import MainDriver.DriverFile;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SecretaryApprove extends DriverFile {
    public AndroidDriver<MobileElement> driver;

    public SecretaryApprove(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public MobileElement myTask() {
        return driver.findElementByAndroidUIAutomator("text(\"Latest Approvals\")");
    }

    public MobileElement searchMedicalLatestApproval() {
        return driver.findElementByAndroidUIAutomator("text(\"Search\")");
    }

    public MobileElement clickMedicalRequest(String RequestID) {
        return driver.findElementByAndroidUIAutomator("text(\"ID: "+RequestID+"\")");
    }
}
