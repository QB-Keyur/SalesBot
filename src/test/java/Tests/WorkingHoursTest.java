package Tests;

import Utils.BasePage;
import org.testng.annotations.Test;

public class WorkingHoursTest extends BasePage {

    @Test
    public void goToWorkingHoursPage(){
        common.logPrint("TEST START :: Navigate to Working Hours page");
        loginWithAdminUser();
        workingHoursPage.goToWorkingHoursPage();
        common.logPrint("TEST PASS :: Working Hours page loaded successfully");
    }

    @Test
    public void verifyElementsOnWorkingHoursPage(){
        common.logPrint("TEST START :: Verify UI elements on Working Hours page");
        loginWithAdminUser();
        workingHoursPage.verifyElementsOnWorkingHoursPage();
        common.logPrint("TEST PASS :: All Working Hours page elements verified");
    }

    @Test
    public void verifyMondayToFridayDefault(){
        common.logPrint("TEST START :: Verify default Working status for Monday to Friday");
        loginWithAdminUser();
        workingHoursPage.verifyMondayToFridayDefault();
        common.logPrint("TEST PASS :: Default Working status verified for weekdays");
    }

    @Test
    public void verifyChangingTime(){
        common.logPrint("TEST START :: Verify changing and saving Working Hours timings");
        loginWithAdminUser();
        workingHoursPage.verifyChangingTime();
        common.logPrint("TEST PASS :: Working Hours timings updated and validated successfully");
    }

    @Test
    public void verifyHolidayHasNoTimings(){
        common.logPrint("TEST START :: Verify Holiday days do not have Start/End timings");
        loginWithAdminUser();
        workingHoursPage.verifyHolidayHasNoTimings();
        common.logPrint("TEST PASS :: Holiday days validated with no Start/End timings");
    }

    @Test
    public void verifyChangingHolidayToWorking(){
        common.logPrint("TEST START :: Verify changing Holiday to Working and adding timings");
        loginWithAdminUser();
        workingHoursPage.verifyChangingHolidayToWorking();
        common.logPrint("TEST PASS :: Holiday successfully converted to Working with timings");
    }





}


