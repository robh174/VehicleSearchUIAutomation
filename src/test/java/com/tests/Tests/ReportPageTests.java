package com.tests.Tests;

import com.DataHelper.RegistrationDataProvider;
import com.Pages.ReportPage;
import com.tests.Base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ReportPageTests extends BaseTest {

    @Test(dataProvider = "inputRegistrationNumbers", dataProviderClass = RegistrationDataProvider.class)
    public void ensureReportPageLoadsSucessfully(String regNumber) {
        homePage.setRegistrationField(regNumber);
        ReportPage reportPage = homePage.gotoReportPage();

        assertEquals(reportPage.getPageTitle(), reportPage.PageTitle, "Page title does not match expected value - check a valid registration was entered");
    }

    @Test(dataProvider = "vehicleData", dataProviderClass = RegistrationDataProvider.class)
    public void vehicleReportPageDisplaysCorrectVehicleDetails(String regNumber, String expectedMake, String expectedModel, String expectedYear) {
        homePage.setRegistrationField(regNumber);
        ReportPage reportPage = homePage.gotoReportPage();

        // Verify expected vs. actual data
        assertEquals(reportPage.getMake(), expectedMake, "Vehicle make does not match");
        assertEquals(reportPage.getModel(), expectedModel, "Vehicle model does not match");
        assertEquals(reportPage.getYearOfManufacture(), expectedYear, "Vehicle year does not match");
    }
}
