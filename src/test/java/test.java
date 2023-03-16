import co.verisoft.fw.extentreport.ExtentReport;
import co.verisoft.fw.selenium.drivers.VerisoftDriver;
import co.verisoft.fw.selenium.drivers.factory.DriverCapabilities;
import co.verisoft.fw.selenium.junit.extensions.DriverInjectionExtension;
import co.verisoft.fw.selenium.junit.extensions.SeleniumLogExtesion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import static co.verisoft.fw.utils.Asserts.assertTrue;


import org.openqa.selenium.support.PageFactory;
import pageObject.homePage;
import pageObject.menuLeft;
import pageObject.javaPage;
import pageObject.xmlFile;
import pageObject.JavaIntroductionPage;
import pageObject.htmlPage;
import pageObject.htmlTablePage;


@ExtentReport
@ExtendWith({DriverInjectionExtension.class, SeleniumLogExtesion.class})
public class test {
    @DriverCapabilities
    DesiredCapabilities capabilities = new DesiredCapabilities();
    {
        capabilities.setBrowserName("firefox");
    }

    homePage home;
    menuLeft menuL;
    javaPage javaP;
    xmlFile xmlF;
    JavaIntroductionPage JavaIntroductionP;
    htmlPage htmlP;
    htmlTablePage htmlTableP;

    @Test
    public void testF1(VerisoftDriver driver) throws InterruptedException {
        xmlF = PageFactory.initElements(driver, xmlFile.class);

        driver.get(xmlF.getData("urlHomePage"));
        home = PageFactory.initElements(driver, homePage.class);

        assertTrue(home.isOnPage(), "Invalid");
        Thread.sleep(3000);
    }

    @Test
    public void testF2(VerisoftDriver driver) throws InterruptedException {
        xmlF = PageFactory.initElements(driver, xmlFile.class);

        driver.get(xmlF.getData("urlHomePage"));
        home = PageFactory.initElements(driver, homePage.class);

        home.insertText("java");
        assertTrue(home.listOpen() && home.listContainStr("java"), "the list is open and contain java");
    }

    @Test
    public void testF3(VerisoftDriver driver) {
        xmlF = PageFactory.initElements(driver, xmlFile.class);

        driver.get(xmlF.getData("urlHomePage"));
        home = PageFactory.initElements(driver, homePage.class);

        home.insertText("java");
        home.chooseOne("java tutorial");
    }

    @Test
    public void testF4(VerisoftDriver driver) {
        xmlF = PageFactory.initElements(driver, xmlFile.class);

        driver.get(xmlF.getData("urlJavaT"));
        menuL = PageFactory.initElements(driver, menuLeft.class);

       assertTrue(menuL.listContain(xmlF.getListFromXml("expectedTopics"),menuL.menu_list), "the menu is display");
        assertTrue(menuL.onlylistContain(xmlF.getListFromXml("expectedJavaOutput"),menuL.list_output), "the menu is display");
        assertTrue(menuL.onlylistContain(xmlF.getListFromXml("expectedJavaVariables"),menuL.list_variables), "the menu is display");


    }

    @Test
    public void testF5(VerisoftDriver driver) {
        xmlF = PageFactory.initElements(driver, xmlFile.class);

        driver.get(xmlF.getData("urlJavaT"));
        javaP = PageFactory.initElements(driver, javaPage.class);

        assertTrue(javaP.isOnPage(), "is on java tutorial");
    }

    @Test
    public void testF6(VerisoftDriver driver) {
        xmlF = PageFactory.initElements(driver, xmlFile.class);

        driver.get(xmlF.getData("urlJavaT"));
        javaP = PageFactory.initElements(driver, javaPage.class);
        JavaIntroductionP = PageFactory.initElements(driver, JavaIntroductionPage.class);


        javaP.btnTop.clickBTNNext();
        assertTrue(JavaIntroductionP.isOnPage(), "is on java Introduction");

    }

    @Test
    public void testF7(VerisoftDriver driver) {
        xmlF = PageFactory.initElements(driver, xmlFile.class);
        driver.get(xmlF.getData("urlJavaqI"));
        javaP = PageFactory.initElements(driver, javaPage.class);
        JavaIntroductionP = PageFactory.initElements(driver, JavaIntroductionPage.class);
        JavaIntroductionP.btnTop.clickBTNPrev();
        assertTrue(javaP.isOnPage(), "is on java tutorial");

    }

    @Test
    public void testF8(VerisoftDriver driver) throws InterruptedException {
        xmlF = PageFactory.initElements(driver, xmlFile.class);
        driver.get(xmlF.getData("urlJavaT"));
        javaP = PageFactory.initElements(driver, javaPage.class);
        htmlP = PageFactory.initElements(driver, htmlPage.class);

        javaP.mTop.clickOnHTML();
        System.out.println(htmlP.isOnPage());
        assertTrue(htmlP.isOnPage(), "is on java tutorial");
        Thread.sleep(3000);
    }

    @Test
    public void testF9(VerisoftDriver driver) throws InterruptedException {
        xmlF = PageFactory.initElements(driver, xmlFile.class);
        driver.get(xmlF.getData("urlHTMLT"));
        htmlP = PageFactory.initElements(driver, htmlPage.class);

        htmlP.goTo("HTML Tables");
        Thread.sleep(3000);
    }

    @Test
    public void testF10(VerisoftDriver driver) {
        xmlF = PageFactory.initElements(driver, xmlFile.class);
        driver.get(xmlF.getData("urlHTMLTable"));
        htmlTableP = PageFactory.initElements(driver, htmlTablePage.class);

        assertTrue(htmlTableP.checkTh(xmlF.getListFromXml("expectedThTableHtml")), "Invalid th");
    }

    @Test
    public void testF11(VerisoftDriver driver) {
        xmlF = PageFactory.initElements(driver, xmlFile.class);

        driver.get(xmlF.getData("urlHTMLTable"));
        htmlTableP = PageFactory.initElements(driver, htmlTablePage.class);

        assertTrue(htmlTableP.checkContactCountry(xmlF.getListFromXml("alfredsFutterkiste"), htmlTableP.alfreds_futterkiste), "Invalid");
        assertTrue(htmlTableP.checkContactCountry(xmlF.getListFromXml("centroComercialMoctezuma"), htmlTableP.centro_comercial_moctezuma), "Invalid");
    }
}