package MainImplementation;

import MainDriver.DriverFile;
import MainDriver.MainConfigurations;
import ProjectPom.DashboardPom;
import ProjectPom.LoginPom;
import ProjectPom.MedicalRequestPom;
import ProjectPom.SecretaryApprove;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class OtherFunctionFunctionalities extends DriverFile {

    Properties prop = new Properties();
    FileInputStream fs;
    String medicalRequestID;
    String medicalRequetText;
    String secretaryName;
    String secretary1 = "sadaat Ali";
    String secretary2 = "faizan";
    String secretary3 = "ahmed1";
    String secretary4 = "Inam Jameel";
    String secretary5 = "Employee 2";


    public OtherFunctionFunctionalities(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void EPCL_MedicalRequest() {
        try {
            TouchAction act = new TouchAction(driver);
            Random rnd = new Random();
            int randomNumber = rnd.nextInt(999999);
            DashboardPom objDashboard = new DashboardPom(driver);
            LoginPom objLogin = new LoginPom(driver);
            MedicalRequestPom objMedical = new MedicalRequestPom(driver);
            /*fs = new FileInputStream("MainConfiguration/Configuration.properties");
            prop.load(fs);*/
            WebDriverWait wt = new WebDriverWait(driver, 20);
            TimeUnit.SECONDS.sleep(10);
            objDashboard.Medical_Icon().click();
            TimeUnit.SECONDS.sleep(20);
            objLogin.btnclick().click(); //ClaimButton click
            TimeUnit.SECONDS.sleep(10);
            Boolean claimTypechoose = objMedical.chooseClaimScreen().size() > 0;
            if (claimTypechoose == true) {
                objLogin.btnclick().click();
                TimeUnit.SECONDS.sleep(5);
            }
            Boolean checkedMaritalStatus = objMedical.chooseMaritalScreen().size() > 0;
            if (checkedMaritalStatus == true) {
                objLogin.btnclick().click();
            }
            TimeUnit.SECONDS.sleep(40);
            objMedical.elementDrp().click();
            TimeUnit.SECONDS.sleep(10);
            objMedical.valueDrp().click();
            TimeUnit.SECONDS.sleep(6);
            secretaryName = objMedical.getSecretaryValue().getText();
            System.out.println(secretaryName);
            objMedical.sectionOPD().click();
            TimeUnit.SECONDS.sleep(10);
            objMedical.clickAddReceipt().click();
            TimeUnit.SECONDS.sleep(5);
            objMedical.invoiceEditText().setValue(Integer.toString(randomNumber));
            TimeUnit.SECONDS.sleep(5);
            objMedical.claimAmountEditText().setValue("1000");
            TimeUnit.SECONDS.sleep(5);
            driver.hideKeyboard();
            objMedical.elementDrp().click();
            TimeUnit.SECONDS.sleep(10);
            objMedical.valueDrp().click();
            TimeUnit.SECONDS.sleep(15);
            act.tap(TapOptions.tapOptions().withElement(ElementOption.element(objMedical.attachmentSign()))).release().perform();
            act.tap(TapOptions.tapOptions().withElement(ElementOption.element(objMedical.attachmentSign()))).release().perform();
            TimeUnit.SECONDS.sleep(10);
            objMedical.selectImage().click();
            TimeUnit.SECONDS.sleep(10);
            Boolean checkAlertImagePermission = objMedical.checkImagePermission().size() > 0;
            if (checkAlertImagePermission == true) {
                objMedical.ImagePermissionAllow().click();
                TimeUnit.SECONDS.sleep(10);
            }
            Boolean checkOfficeGalleryPhotos = objMedical.checkOfficePhotoClick().size() > 0;
            if (checkOfficeGalleryPhotos == true) {
                objMedical.officePhotosclick().click();
                TimeUnit.SECONDS.sleep(10);
                objMedical.tapPhotoIcon().click();
                TimeUnit.SECONDS.sleep(10);
                objMedical.selectionImage().click();
                TimeUnit.SECONDS.sleep(5);
                objMedical.doneImagebtn().click();
                TimeUnit.SECONDS.sleep(20);
            } else {
                objMedical.attachedImage().click();
                TimeUnit.SECONDS.sleep(10);
            }
            objLogin.btnclick().click();
            TimeUnit.SECONDS.sleep(25);
            objMedical.checkboxdeclartion().click();
            boolean valReturn = objMedical.valuecheckboxdeclartion().size() > 0;
            TimeUnit.SECONDS.sleep(10);
            objLogin.btnclick().click();
            TimeUnit.SECONDS.sleep(10);
            //List<MobileElement> btnRequestList = driver.findElementsByXPath("//android.view.ViewGroup[@content-desc='submit']");
            objMedical.btnRequetsList().get(0).click();
            TimeUnit.SECONDS.sleep(25);
            Boolean checkSubmitRequestPanel = objMedical.checkRequestDialog().size() > 0;
            if (checkSubmitRequestPanel == true) {

                medicalRequetText = objMedical.requestMedicalText().getText();
                medicalRequestID = medicalRequetText.substring(4, 8);
                System.out.println("The request id is : " + medicalRequestID);
                TimeUnit.SECONDS.sleep(25);

            }
            objMedical.requestSubmittedDialog().click();
            TimeUnit.SECONDS.sleep(25);

        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public void login_Secretsry() {
        LoginPom objLogin = new LoginPom(driver);
        MainConfigurations objConfig = new MainConfigurations(driver);

        if (secretaryName.contains(secretary1)) {
            try {
                TimeUnit.SECONDS.sleep(5);
                objLogin.Login_Uname().setValue(objConfig.epcl_secretary1Username());
                driver.hideKeyboard();
                TimeUnit.SECONDS.sleep(5);
                objLogin.Login_Password().setValue(objConfig.epcl_secretary1Password());
                driver.hideKeyboard();
                TimeUnit.SECONDS.sleep(5);
                objLogin.btnclick().click();
                TimeUnit.SECONDS.sleep(25);
            } catch (Exception ex) {
                ex.getMessage();
            }
        } else if (secretaryName.contains(secretary2)) {
            try {
                TimeUnit.SECONDS.sleep(5);
                objLogin.Login_Uname().setValue(objConfig.epcl_secretary2Username());
                driver.hideKeyboard();
                TimeUnit.SECONDS.sleep(5);
                objLogin.Login_Password().setValue(objConfig.epcl_secretary2Password());
                driver.hideKeyboard();
                TimeUnit.SECONDS.sleep(5);
                objLogin.btnclick().click();
                TimeUnit.SECONDS.sleep(25);
            } catch (Exception ex) {
                ex.getMessage();
            }
        } else if (secretaryName.contains(secretary3)) {
            try {
                TimeUnit.SECONDS.sleep(5);
                objLogin.Login_Uname().setValue(objConfig.epcl_secretary3Username());
                driver.hideKeyboard();
                TimeUnit.SECONDS.sleep(5);
                objLogin.Login_Password().setValue(objConfig.epcl_secretary3Password());
                driver.hideKeyboard();
                TimeUnit.SECONDS.sleep(5);
                objLogin.btnclick().click();
                TimeUnit.SECONDS.sleep(25);
            } catch (Exception ex) {
                ex.getMessage();
            }
        } else if (secretaryName.contains(secretary4)) {
            try {
                TimeUnit.SECONDS.sleep(5);
                objLogin.Login_Uname().setValue(objConfig.epcl_secretary4Username());
                driver.hideKeyboard();
                TimeUnit.SECONDS.sleep(5);
                objLogin.Login_Password().setValue(objConfig.epcl_secretary4Password());
                driver.hideKeyboard();
                TimeUnit.SECONDS.sleep(5);
                objLogin.btnclick().click();
                TimeUnit.SECONDS.sleep(25);
            } catch (Exception ex) {
                ex.getMessage();
            }
        } else if (secretaryName.contains(secretary5)) {
            try {
                TimeUnit.SECONDS.sleep(5);
                objLogin.Login_Uname().setValue(objConfig.epcl_secretary5Username());
                driver.hideKeyboard();
                TimeUnit.SECONDS.sleep(5);
                objLogin.Login_Password().setValue(objConfig.epcl_secretary5Password());
                driver.hideKeyboard();
                TimeUnit.SECONDS.sleep(5);
                objLogin.btnclick().click();
                TimeUnit.SECONDS.sleep(25);
            } catch (Exception ex) {
                ex.getMessage();
            }
        }
    }

    public void secretary_TaskApproved() {
        SecretaryApprove objSec = new SecretaryApprove(driver);
        MedicalRequestPom objMedical = new MedicalRequestPom(driver);
        try {
            objSec.myTask().click();
            TimeUnit.SECONDS.sleep(25);
            objSec.searchMedicalLatestApproval().setValue(medicalRequestID);
            TimeUnit.SECONDS.sleep(2);
            driver.pressKeyCode(AndroidKeyCode.ENTER);
            TimeUnit.SECONDS.sleep(20);
            objSec.clickMedicalRequest(medicalRequestID).click();
            TimeUnit.SECONDS.sleep(20);
            objMedical.btnRequetsList().get(0).click();
            TimeUnit.SECONDS.sleep(10);
            objMedical.requestSubmittedDialog().click();
            TimeUnit.SECONDS.sleep(25);
        } catch (Exception ex) {
            ex.getMessage();
        }

    }

    public void request_MedicalClaim() throws IOException {
        try {
            EPCL_MedicalRequest();
            LogoutEpcl();
            login_Secretsry();
            secretary_TaskApproved();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
