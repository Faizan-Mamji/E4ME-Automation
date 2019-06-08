package ProjectPom;

import MainDriver.DriverFile;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LtrRequestPom extends DriverFile {

    public LtrRequestPom(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public MobileElement btnLTRRequest() {
        return driver.findElementByAndroidUIAutomator("text(\"New Request\")");
    }

    public MobileElement textPickUp() {
        return driver.findElementByAndroidUIAutomator("text(\"Choose Pickup\")");
    }

    public MobileElement textDropOff() {
        return driver.findElementByAndroidUIAutomator("text(\"Choose Drop Off\")");
    }

    public MobileElement nextBtn() {
        return driver.findElementByAndroidUIAutomator("text(\"Next\")");
    }

    public MobileElement dateSelection(String selectDate) {
        return driver.findElementByAndroidUIAutomator("(\"" + selectDate + "\")");
    }
}
