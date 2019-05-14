package ProjectPom;

import MainDriver.DriverFile;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;

public class MedicalRequestPom extends DriverFile {

    public MedicalRequestPom(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public List<MobileElement> chooseClaimScreen() {
        return driver.findElementsByAndroidUIAutomator("text(\"On behalf\")");
    }

    public List<MobileElement> chooseMaritalScreen() {
        return driver.findElementsByAndroidUIAutomator("text(\"Family\")");
    }

    public List<MobileElement> checkImagePermission() {
        return driver.findElementsById("com.android.packageinstaller:id/dialog_container");
    }

    public MobileElement ImagePermissionAllow() {
        return driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
    }

    public MobileElement elementDrp() {
        return driver.findElementByAndroidUIAutomator("text(\"Please Select\")");
    }

    public MobileElement valueDrp() {
        return driver.findElementByXPath("//android.widget.CheckedTextView[@index='1']");
    }

    public MobileElement sectionOPD() {
        return driver.findElementByAndroidUIAutomator("text(\"Consultation\")");
    }

    public MobileElement clickAddReceipt() {
        return driver.findElementByAndroidUIAutomator("text(\"Add Receipt\")");
    }

    public MobileElement invoiceEditText() {
        return driver.findElementByXPath("//android.widget.EditText[@index='4']");
    }

    public MobileElement claimAmountEditText() {
        return driver.findElementByXPath("//android.widget.EditText[@index='5']");
    }

    public MobileElement attachmentSign() {
        return driver.findElementByAccessibilityId("addAttachmentBtn");
    }

    public MobileElement selectImage() {
        return driver.findElementByAndroidUIAutomator("text(\"Select Image\")");
    }

    public MobileElement attachedImage() {
        return driver.findElementById("com.android.documentsui:id/icon_mime");
    }

    public MobileElement officePhotosclick() {
        return driver.findElementByAndroidUIAutomator("text(\"Photos\")");
    }

    public List<MobileElement> checkOfficePhotoClick() {
        return driver.findElementsByAndroidUIAutomator("text(\"Photos\")");
    }

    public MobileElement tapPhotoIcon() {
        return driver.findElementByAndroidUIAutomator("text(\"Photos\")");
    }

    public MobileElement selectionImage() {
        return driver.findElementByXPath("//android.view.ViewGroup[@index='1']");
    }

    public MobileElement doneImagebtn() {
        return driver.findElementByAndroidUIAutomator("text(\"Done\")");
    }

    public MobileElement requestSubmittedDialog() {
        return driver.findElementById("android:id/button1");
    }


    public MobileElement checkboxdeclartion() {
        return driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).scrollIntoView("
                        + "new UiSelector().description(\"checkBoxButton\"))");
    }

    public List<MobileElement> valuecheckboxdeclartion() {
        return driver.findElementsByAccessibilityId("checkBoxButton");
    }

    public MobileElement getSecretaryValue() {
        return driver.findElementById("android:id/text1");
    }

    public List<MobileElement> btnRequetsList() {
        return driver.findElementsByXPath("//android.view.ViewGroup[@content-desc='submit']");
    }

    public List<MobileElement> checkRequestDialog() {
        return driver.findElementsById("android:id/parentPanel");
    }

    public MobileElement requestMedicalText() {
        return driver.findElementById("android:id/message");
    }
}
