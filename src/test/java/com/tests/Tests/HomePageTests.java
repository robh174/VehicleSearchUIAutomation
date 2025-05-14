package com.tests.Tests;
import com.tests.Base.BaseTest;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @Test
    public void homePageLoadsCorrectly(){
        // page navigation completed via base test
        assertTrue(homePage.isPageDisplayed());
        assertEquals(homePage.getPageTitle(), homePage.PageTitle, "Page title does not match expected value") ;

    }
}
