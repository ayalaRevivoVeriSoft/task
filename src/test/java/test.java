import co.verisoft.fw.extentreport.ExtentReport;
import co.verisoft.fw.selenium.drivers.VerisoftDriver;
import co.verisoft.fw.selenium.drivers.factory.DriverCapabilities;
import co.verisoft.fw.selenium.junit.extensions.DriverInjectionExtension;
import co.verisoft.fw.selenium.junit.extensions.SeleniumLogExtesion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import static co.verisoft.fw.utils.Asserts.assertTrue;

import co.verisoft.PageObject.homePage;
import co.verisoft.PageObject.javaPage;
import co.verisoft.FileOperationFunctions.xmlFile;
import co.verisoft.PageObject.JavaIntroductionPage;
import co.verisoft.PageObject.htmlPage;
import co.verisoft.PageObject.htmlTablePage;
import co.verisoft.PageObject.menuLeft;
import co.verisoft.FileOperationFunctions.xmlFile;

import org.openqa.selenium.support.PageFactory;


@ExtentReport
@ExtendWith({DriverInjectionExtension.class, SeleniumLogExtesion.class})
public class test {

    homePage home;

    javaPage javaP;
    xmlFile xmlF;
    JavaIntroductionPage JavaIntroductionP;
    htmlPage htmlP;
    htmlTablePage htmlTableP;

    @DriverCapabilities
    DesiredCapabilities capabilities = new DesiredCapabilities();

    {
        capabilities.setBrowserName("firefox");
    }


    @Test
    public void testF1(VerisoftDriver driver) throws InterruptedException {
        driver.get(xmlF.getStringFromXml("urlHomePage"));
        home = new homePage(driver);
        assertTrue(home.isOnPage(), "Invalid");
        driver.quit();
    }


    @Test
    public void testF2(VerisoftDriver driver) throws InterruptedException {
        driver.get(xmlF.getStringFromXml("urlHomePage"));
        home = new homePage(driver);
        home.insertTextToSearch("java");
        assertTrue(home.listOpen() && home.listContainStr("java"), "the list is open and contain java");
        driver.quit();
    }


    @Test
    public void testF3(VerisoftDriver driver) {
        driver.get(xmlF.getStringFromXml("urlHomePage"));
        home = new homePage(driver);
        home.insertTextToSearch("java");
        home.chooseOne("java tutorial");
        driver.quit();
    }


    @Test
    public void testF4(VerisoftDriver driver) {
        driver.get(xmlF.getStringFromXml("urlJavaT"));
        javaP = new javaPage(driver);
        assertTrue(javaP.mLeft.listContain(xmlF.getListFromXml("expectedTopics"), javaP.menu_list), "the menu is display");
        assertTrue(javaP.mLeft.onlyListContain(xmlF.getListFromXml("expectedJavaOutput"), javaP.list_output), "the menu is display");
        assertTrue(javaP.mLeft.onlyListContain(xmlF.getListFromXml("expectedJavaVariables"), javaP.list_variables), "the menu is display");
        driver.quit();
    }


    @Test
    public void testF5(VerisoftDriver driver) {
        driver.get(xmlF.getStringFromXml("urlJavaT"));
        javaP = new javaPage(driver);
        assertTrue(javaP.isOnPage(), "is on java tutorial");
        driver.quit();
    }


    @Test
    public void testF6(VerisoftDriver driver) {
        driver.get(xmlF.getStringFromXml("urlJavaT"));
        javaP = new javaPage(driver);
        JavaIntroductionP = new JavaIntroductionPage(driver);
        javaP.btnTop.clickBTNNext();
        assertTrue(JavaIntroductionP.isOnPage(), "is on java Introduction");
        driver.quit();
    }


    @Test
    public void testF7(VerisoftDriver driver) {
        driver.get(xmlF.getStringFromXml("urlJavaqI"));
        javaP = new javaPage(driver);
        JavaIntroductionP = new JavaIntroductionPage(driver);
        JavaIntroductionP.btnTop.clickBTNPrev();
        assertTrue(javaP.isOnPage(), "is on java tutorial");
        driver.quit();
    }

    @Test
    public void testF8(VerisoftDriver driver) throws InterruptedException {
        driver.get(xmlF.getStringFromXml("urlJavaT"));
        javaP = new javaPage(driver);
        htmlP = new htmlPage(driver);
        javaP.mTop.clickOnHTML();
        assertTrue(htmlP.isOnPage(), "is on java tutorial");
        driver.quit();
    }


    @Test
    public void testF9(VerisoftDriver driver) throws InterruptedException {
        driver.get(xmlF.getStringFromXml("urlHTMLT"));
        htmlP = new htmlPage(driver);
        htmlP.mLeft.goTo(driver, "HTML Tables");
        driver.quit();
    }


    @Test
    public void testF10(VerisoftDriver driver) {
        driver.get(xmlF.getStringFromXml("urlHTMLTable"));
        htmlTableP = new htmlTablePage(driver);
        assertTrue(htmlTableP.checkTh(xmlF.getListFromXml("expectedThTableHtml")), "Invalid th");
        driver.quit();
    }


    @Test
    public void testF11(VerisoftDriver driver) {

        driver.get(xmlF.getStringFromXml("urlHTMLTable"));
        htmlTableP = new htmlTablePage(driver);
        assertTrue(htmlTableP.checkContactCountry(xmlF.getListFromXml("alfredsFutterkiste"), htmlTableP.alfreds_futterkiste), "Invalid");
        assertTrue(htmlTableP.checkContactCountry(xmlF.getListFromXml("centroComercialMoctezuma"), htmlTableP.centro_comercial_moctezuma), "Invalid");
        driver.quit();
    }
}
