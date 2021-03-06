package MainImplementation;

import MainDriver.DriverFile;
import MainDriver.MainConfigurations;
import ProjectPom.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class OtherFunctionFunctionalities extends DriverFile {

    Properties prop = new Properties();
    FileInputStream fs;
    int i;
    Boolean checkCustodian;
    Boolean checkSubmitRequestPanel;
    Boolean checkedMaritalStatus;
    Boolean claimTypechoose;
    Boolean checkAlertImagePermission;
    Boolean checkOfficeGalleryPhotos;
    Boolean valReturn;
    Boolean checkNofication;
    Boolean checkDashboardText;
    Boolean checkDashboard;
    String medicalRequestID;
    String medicalRequetText;
    String secretaryName;
    String secretary1 = "sadaat Ali";
    String secretary2 = "faizan";
    String secretary3 = "ahmed1";
    String secretary4 = "Inam Jameel";
    String secretary5 = "Employee 2";
    String btnDraft = "Save to Draft";
    String btnSubmit = "Submit";
    String btnApproved = "";
    String btnDeclined = "";
    String btnRework = "";

    public OtherFunctionFunctionalities(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void EPCL_MedicalRequest() {
        LtrRequestPom objLtr = new LtrRequestPom(driver);
        TouchAction act = new TouchAction(driver);
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(999999);
        DashboardPom objDashboard = new DashboardPom(driver);
        LoginPom objLogin = new LoginPom(driver);
        MedicalRequestPom objMedical = new MedicalRequestPom(driver);
        try {
            WebDriverWait wt = new WebDriverWait(driver, 20);
            TimeUnit.SECONDS.sleep(10);
            objDashboard.Medical_Icon().click();
            TimeUnit.SECONDS.sleep(20);
            objLogin.btnclick().click(); //ClaimButton click
            TimeUnit.SECONDS.sleep(10);
            claimTypechoose = objMedical.chooseClaimScreen().size() > 0;
            if (claimTypechoose == true) {
                objLogin.btnclick().click();
                TimeUnit.SECONDS.sleep(5);
            }
            checkedMaritalStatus = objMedical.chooseMaritalScreen().size() > 0;
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
            checkAlertImagePermission = objMedical.checkImagePermission().size() > 0;
            if (checkAlertImagePermission == true) {
                objMedical.ImagePermissionAllow().click();
                TimeUnit.SECONDS.sleep(10);
            }
            checkOfficeGalleryPhotos = objMedical.checkOfficePhotoClick().size() > 0;
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
            valReturn = objMedical.valuecheckboxdeclartion().size() > 0;
            TimeUnit.SECONDS.sleep(10);
            objLogin.btnclick().click();
            TimeUnit.SECONDS.sleep(10);
            //List<MobileElement> btnRequestList = driver.findElementsByXPath("//android.view.ViewGroup[@content-desc='submit']");
            objMedical.btnRequetsList().get(1).click();
            TimeUnit.SECONDS.sleep(25);
            checkSubmitRequestPanel = objMedical.checkRequestDialog().size() > 0;
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

    public void login_Doctor() {
        LoginPom objLogin = new LoginPom(driver);
        MainConfigurations objConfig = new MainConfigurations(driver);

        try {
            TimeUnit.SECONDS.sleep(5);
            objLogin.Login_Uname().setValue(objConfig.epcl_doctorUsername());
            driver.hideKeyboard();
            TimeUnit.SECONDS.sleep(5);
            objLogin.Login_Password().setValue(objConfig.epcl_doctorPassword());
            driver.hideKeyboard();
            TimeUnit.SECONDS.sleep(5);
            objLogin.btnclick().click();
            TimeUnit.SECONDS.sleep(25);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public void login_HR() {
        LoginPom objLogin = new LoginPom(driver);
        MainConfigurations objConfig = new MainConfigurations(driver);

        try {
            TimeUnit.SECONDS.sleep(5);
            objLogin.Login_Uname().setValue(objConfig.epcl_hrUsername());
            driver.hideKeyboard();
            TimeUnit.SECONDS.sleep(5);
            objLogin.Login_Password().setValue(objConfig.epcl_hrPassword());
            driver.hideKeyboard();
            TimeUnit.SECONDS.sleep(5);
            objLogin.btnclick().click();
            TimeUnit.SECONDS.sleep(25);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public void mainAll_TaskApproved() {
        GeneralApprove objSec = new GeneralApprove(driver);
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

    public void doctor_TaskApproved() {
        GeneralApprove objSec = new GeneralApprove(driver);
        MedicalRequestPom objMedical = new MedicalRequestPom(driver);
        try {
            objSec.myTask().click();
            TimeUnit.SECONDS.sleep(35);
            objSec.searchMedicalLatestApproval().click();
            TimeUnit.SECONDS.sleep(6);
            objSec.searchMedicalLatestApproval().setValue(medicalRequestID);
            TimeUnit.SECONDS.sleep(6);
            driver.pressKeyCode(AndroidKeyCode.ENTER);
            TimeUnit.SECONDS.sleep(25);
            objSec.clickMedicalRequest(medicalRequestID).click();
            TimeUnit.SECONDS.sleep(30);
            objMedical.btnRequetsList().get(0).click();
            TimeUnit.SECONDS.sleep(10);
            objMedical.requestSubmittedDialog().click();
            TimeUnit.SECONDS.sleep(90);

        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public void verify_Notification() {
        MedicalRequestPom objMed = new MedicalRequestPom(driver);
        DashboardPom objDashBoard = new DashboardPom(driver);
        try {

            checkNofication = objMed.checkRequestDialog().size() > 0;
            TimeUnit.SECONDS.sleep(10);
            if (checkNofication == true) {
                objMed.requestSubmittedDialog().click();
                TimeUnit.SECONDS.sleep(30);
            }
            checkDashboardText = objDashBoard.Check_DasboardText().size() > 0;
            if (checkDashboardText == true) {
                LogoutEpcl();
            } else {
                objMed.backArrow().click();
                TimeUnit.SECONDS.sleep(5);
                checkDashboard = objDashBoard.Check_DasboardText().size() > 0;
                if (checkDashboard == true) {
                    LogoutEpcl();
                }
            }

        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public void request_MedicalClaim() throws IOException {
        try {
            EPCL_MedicalRequest();
            LogoutEpcl();
            login_Secretsry();
            mainAll_TaskApproved();
            LogoutEpcl();
            login_Doctor();
            doctor_TaskApproved();
            verify_Notification();
            login_HR();
            mainAll_TaskApproved();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public void LTR_Request() {
        LtrRequestPom objLtr = new LtrRequestPom(driver);
        TouchAction act = new TouchAction(driver);
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(999999);
        DashboardPom objDashboard = new DashboardPom(driver);
        LoginPom objLogin = new LoginPom(driver);
        MedicalRequestPom objMedical = new MedicalRequestPom(driver);
        try {
            Date dt = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("d");
            objDashboard.LocalTransport_Icon().click();
            TimeUnit.SECONDS.sleep(25);
            objLtr.btnLTRRequest().click();
            TimeUnit.SECONDS.sleep(15);
            claimTypechoose = objLtr.chooseClaimScreen().size() > 0;
            if (claimTypechoose == true) {
                objLogin.btnclick().click();
                TimeUnit.SECONDS.sleep(5);
            }
            objLtr.textPickUp().setValue("Te");
            //TimeUnit.SECONDS.sleep(10);
            driver.hideKeyboard();
            objLtr.textDropOff().setValue("ng");
            driver.hideKeyboard();
            TimeUnit.SECONDS.sleep(10);
            objLtr.nextBtn().click();
            TimeUnit.SECONDS.sleep(15);
            objLtr.dateSelection(sdf.format(dt)).click();
            TimeUnit.SECONDS.sleep(10);
            objLtr.nextBtn().click();
            TimeUnit.SECONDS.sleep(10);
            objLtr.nextBtn().click();
            TimeUnit.SECONDS.sleep(10);
            checkCustodian = objLtr.drpCustodian().size() > 0;
            if (checkCustodian == true) {
                objLtr.custodianClick().click();
                TimeUnit.SECONDS.sleep(5);
                objLtr.custodianValue().click();
                TimeUnit.SECONDS.sleep(5);
            }
            objLtr.adminDrpClick().click();
            TimeUnit.SECONDS.sleep(5);
            objLtr.adminValue().click();
            TimeUnit.SECONDS.sleep(5);
            objLtr.txtNumber().setValue("123456");
            TimeUnit.SECONDS.sleep(5);


        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
