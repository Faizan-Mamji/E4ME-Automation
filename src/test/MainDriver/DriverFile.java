package MainDriver;

import ProjectPom.DashboardPom;
import ProjectPom.LoginPom;
import ProjectPom.LogoutPom;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

public class DriverFile {

    public AndroidDriver<MobileElement> driver;
    private static final LogManager logg = LogManager.getLogManager();

    public AndroidDriver<MobileElement> Epcl_MainDriver() throws IOException {
        MainConfigurations objConfig = new MainConfigurations(driver);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, objConfig.device_Name());
        caps.setCapability(MobileCapabilityType.UDID, objConfig.device_ID()); //Give Device ID of your mobile phone
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, objConfig.device_Platform());
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, objConfig.device_Version());
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "300");
        caps.setCapability("appPackage", objConfig.application_Apppackage());
        caps.setCapability("appActivity", objConfig.application_AppActivity());
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("autoDismissAlerts", true);

        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
            TimeUnit.SECONDS.sleep(8);
            System.out.println("Driver Line passed");

        } catch (NullPointerException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            ex.getMessage();
        } catch (Exception ex) {
            ex.getMessage();
        }
        return driver;
    }

    public void LoginEpcl() {
        MainConfigurations objConfig=new MainConfigurations(driver);
        LoginPom objLogin = new LoginPom(driver);
        TouchAction ac = new TouchAction(driver);
        try {
            TimeUnit.SECONDS.sleep(3);
            objLogin.Login_Uname().setValue(objConfig.epcl_UserName());
            TimeUnit.SECONDS.sleep(4);
            driver.hideKeyboard();
            objLogin.Login_Password().setValue(objConfig.epcl_Password());
            driver.hideKeyboard();
            TimeUnit.SECONDS.sleep(4);
            objLogin.btnclick().click();
            TimeUnit.SECONDS.sleep(30);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public void LogoutEpcl() {
        try {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("Enter in Logout Function");
            LogoutPom objLogout = new LogoutPom(driver);
            objLogout.LogoutImage().click();
            TimeUnit.SECONDS.sleep(3);
            System.out.println("Click Logout Image");
            objLogout.btnLogout().click();
            TimeUnit.SECONDS.sleep(3);
            objLogout.LogoutPopupYes().click();
            TimeUnit.SECONDS.sleep(20);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public void MainLoginImplementation() {
        LoginPom objLogin = new LoginPom(driver);
        LogoutPom objLogout = new LogoutPom(driver);
        DashboardPom objDashboard = new DashboardPom(driver);
        try {
            TimeUnit.SECONDS.sleep(25);
            boolean CheckDashboard = objDashboard.Check_DasboardText().size() > 0;
            boolean CheckLoginScreen = objLogin.Check_LoginUname().size() > 0;

            if (CheckDashboard == true && CheckLoginScreen == false) {
                LogoutEpcl();
                LoginEpcl();
            } else if (CheckDashboard == false && CheckLoginScreen == false) {
                for (int i = 0; i < 10; i++) {
                    driver.pressKeyCode(AndroidKeyCode.BACK);
                    boolean CheckDashboardText = objDashboard.Check_DasboardText().size() > 0;
                    boolean CheckLoginUText = objLogin.Check_LoginUname().size() > 0;
                    if (CheckDashboardText == true && CheckLoginUText == false) {
                        LogoutEpcl();
                        LoginEpcl();
                        break;
                    }

                    if (CheckDashboardText == false && CheckLoginUText == true) {
                        LoginEpcl();
                        break;
                    }
                }
            } else if (CheckDashboard == false && CheckLoginScreen == true) {
                LoginEpcl();
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
