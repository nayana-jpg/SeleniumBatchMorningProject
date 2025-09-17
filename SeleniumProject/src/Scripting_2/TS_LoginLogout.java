package Scripting_2;

import org.openqa.selenium.WebDriver;

import static Scripting_2.ReusableMethods.*;

public class TS_LoginLogout {
    public static void main(String[] args) {
        TS_LoginLogout();
        TS_createAndDeleteUser();
    }
    public static void TS_LoginLogout() {
        WebDriver oBrowser = null;
        try {
            oBrowser = launchBrowser("firefox");
            boolean blnRes = navigateURL(oBrowser, "http://localhost/login.do");
            blnRes = loginToApplication(oBrowser, "admin", "manager");
            blnRes = logoutFromActiTime(oBrowser);
        } catch (Exception e) {
            System.out.println("Exception in 'TS_LoginLogout' test script");

        } finally {
            oBrowser.close();
            oBrowser = null;
        }
    }

    public static void TS_createAndDeleteUser() {
        WebDriver oBrowser = null;
        try {
            oBrowser = launchBrowser("Edge");
            boolean blnRes = navigateURL(oBrowser, "http://localhost/login.do");
            blnRes = loginToApplication(oBrowser, "admin", "manager");

            String create = createUser(oBrowser);
            boolean delete = deleteUser(oBrowser, "user1, test");
            blnRes = logoutFromActiTime(oBrowser);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            oBrowser.close();
            oBrowser = null;
        }
    }
}

