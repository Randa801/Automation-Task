package QA.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

    public class Login {

        private AndroidDriver driver;

        @BeforeClass
        public void setUp() throws MalformedURLException {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0"); // replace with your emulator/device version
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
            caps.setCapability(MobileCapabilityType.APP, "/path/to/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        }


        @AfterClass
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }

