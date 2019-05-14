package MainDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.omg.CORBA.StringHolder;

import java.io.FileInputStream;
import java.util.Properties;

public class MainConfigurations extends DriverFile {

    public AndroidDriver<MobileElement> driver;
    FileInputStream fs;
    String getDeviceID;
    String getDeviceName;
    String getVersion;
    String getPlatform;
    String getPackage;
    String getActivity;
    String getUserName;
    String getPassword;
    String getsecretary1;
    String getsecPassword1;
    String getsecretary2;
    String getsecPassword2;
    String getsecretary3;
    String getsecPassword3;
    String getsecretary4;
    String getsecPassword4;
    String getsecretary5;
    String getsecPassword5;

    Properties prop = new Properties();

    public MainConfigurations(AndroidDriver<MobileElement> driver) {
        try {
            this.driver = driver;
            fs = new FileInputStream("MainConfiguration/Configuration.properties");
            prop.load(fs);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public String device_ID() {
        try {
            getDeviceID = prop.getProperty("DeviceID");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return getDeviceID;
    }

    public String device_Name() {
        try {
            getDeviceName = prop.getProperty("NameDevice");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return getDeviceName;
    }

    public String device_Version() {
        try {
            getVersion = prop.getProperty("AndroidVersion");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return getVersion;
    }

    public String device_Platform() {
        try {
            getPlatform = prop.getProperty("PlatformName");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return getPlatform;
    }

    public String application_Apppackage() {
        try {
            getPackage = prop.getProperty("AppPackage");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return getPackage;
    }

    public String application_AppActivity() {
        try {
            getActivity = prop.getProperty("AppActivity");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return getActivity;
    }

    public String epcl_UserName() {
        try {
            getUserName = prop.getProperty("UserLoginEmail");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return getUserName;
    }

    public String epcl_Password() {
        try {
            getPassword = prop.getProperty("UserLoginPassword");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return getPassword;
    }

    public String epcl_secretary1Username() {
        try {
            getsecretary1 = prop.getProperty("Secretary1");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return getsecretary1;
    }

    public String epcl_secretary1Password() {
        try {
            getsecPassword1 = prop.getProperty("Secretarypass1");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return getsecPassword1;
    }

    public String epcl_secretary2Username() {
        try {
            getsecretary2 = prop.getProperty("Secretary2");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return getsecretary2;
    }

    public String epcl_secretary2Password() {
        try {
            getsecPassword2 = prop.getProperty("Secretarypass2");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return getsecPassword2;
    }

    public String epcl_secretary3Username() {
        try {
            getsecretary3 = prop.getProperty("Secretary3");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return getsecretary3;
    }

    public String epcl_secretary3Password() {
        try {
            getsecPassword3 = prop.getProperty("Secretarypass3");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return getsecPassword3;
    }

    public String epcl_secretary4Username() {
        try {
            getsecretary4 = prop.getProperty("Secretary4");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return getsecretary4;
    }

    public String epcl_secretary4Password() {
        try {
            getsecPassword4 = prop.getProperty("Secretarypass4");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return getsecPassword4;
    }

    public String epcl_secretary5Username() {
        try {
            getsecretary5 = prop.getProperty("Secretary5");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return getsecretary5;
    }

    public String epcl_secretary5Password() {
        try {
            getsecPassword5 = prop.getProperty("Secretarypass5");
        } catch (Exception ex) {
            ex.getMessage();
        }
        return getsecPassword5;
    }

}
