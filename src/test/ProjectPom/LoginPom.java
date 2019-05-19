package ProjectPom;

import MainDriver.DriverFile;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

public class LoginPom extends DriverFile {

    public LoginPom(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public List<MobileElement> Check_LoginUname() {
        return driver.findElementsByAndroidUIAutomator("text(\"Username\")");
    }

    public MobileElement Login_Uname() {
        return driver.findElementByAndroidUIAutomator("text(\"Username\")");
    }

    public MobileElement Login_Password() {
        return driver.findElementByAndroidUIAutomator("text(\"Password\")");
    }

    public MobileElement btnclick() {
        return driver.findElementByAccessibilityId("submit");
    }
}

