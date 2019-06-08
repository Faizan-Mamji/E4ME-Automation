package ProjectPom;

import MainDriver.DriverFile;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

public class DashboardPom extends DriverFile {

    public DashboardPom(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public List<MobileElement> Check_DasboardText() {
        return driver.findElementsByAndroidUIAutomator("text(\"My Tasks\")");
    }

    public MobileElement Medical_Icon() {
        return driver.findElementByAndroidUIAutomator("text(\"Medical\")");
    }

    public MobileElement LocalTransport_Icon() {
        return driver.findElementByAndroidUIAutomator("text(\"Transport\")");
    }





}
