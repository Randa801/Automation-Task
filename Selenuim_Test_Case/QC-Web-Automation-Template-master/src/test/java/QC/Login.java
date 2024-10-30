package QC;

import QC.pages.OnboardingPage;
import QC.pages.*;
import org.testng.annotations.AfterTest;

public class Login {

    final OnboardingPage onboardingPage = new OnboardingPage();
   // final Logout logoutPage = new Logout();

    @org.testng.annotations.Test(priority = 1)

    public void LoginWithMerchant() throws Exception {
        onboardingPage.setUp();
    }

    @AfterTest
    public void CloseDriver() throws InterruptedException {
      //  logoutPage.Close_driver();
    }
}
