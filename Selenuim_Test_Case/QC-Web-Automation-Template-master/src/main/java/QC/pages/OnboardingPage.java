package QC.pages;

import QC.GlobalProperties;
import QC.utilities.selenium.DriverFactory;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class OnboardingPage {

    private DriverFactory driver;

    String propFileName = "config.properties";

    @Test
    public void setUp() {
        driver = new DriverFactory();

        try {
            InputStream input = new FileInputStream("./src/main/resources/" + propFileName);
            GlobalProperties.global_propertoes.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }

    }

}
