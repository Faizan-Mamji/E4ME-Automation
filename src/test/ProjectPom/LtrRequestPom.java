package ProjectPom;

import MainDriver.DriverFile;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

public class LtrRequestPom extends DriverFile {

    public LtrRequestPom(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public List<MobileElement> chooseClaimScreen() {
        return driver.findElementsByAndroidUIAutomator("text(\"On Behalf\")");
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
        return driver.findElementByAndroidUIAutomator("text(\"" + selectDate + "\")");
    }

    public List<MobileElement> drpCustodian() {
        return driver.findElementsByAndroidUIAutomator("text(\"Custodian\")");
    }

    public MobileElement custodianClick() {
        return driver.findElementById("android:id/text1");
    }

    public MobileElement custodianValue() {
        return driver.findElementByXPath("//android.widget.CheckedTextView[@index='0']");
    }

    public MobileElement adminDrpClick() {
        return driver.findElementByAndroidUIAutomator("text(\"Please Select\")");
    }

    public MobileElement adminValue() {
        return driver.findElementByXPath("//android.widget.CheckedTextView[@index='3']");
    }

    public MobileElement txtNumber() {
        return driver.findElementByAndroidUIAutomator("text(\"Enter here}\")");
    }
}