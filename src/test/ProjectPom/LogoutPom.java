package ProjectPom;

import MainDriver.DriverFile;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LogoutPom extends DriverFile {
    public LogoutPom(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public MobileElement LogoutImage() {
        return driver.findElementByXPath("//android.view.ViewGroup[@index='2']");
    }

    public MobileElement btnLogout() {
        return driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Logout\"));");
    }

    public MobileElement LogoutPopupYes() {
        return driver.findElementById("android:id/button1");
    }
}
