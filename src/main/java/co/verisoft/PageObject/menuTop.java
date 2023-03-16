package co.verisoft.PageObject;

import co.verisoft.fw.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


/**

 This class represents the top menu on a web page that extends the BasePage class.

 It contains a WebElement for the HTML button and methods to interact with it.
 */
public class menuTop extends BasePage {

    /**
     WebElement for the HTML button.
     */
    @FindBy(linkText = ("HTML"))
    public WebElement btn_html;

    /**
     Constructor for the menuTop class.
     @param driver The WebDriver object used to interact with the web page.
     */
    public menuTop(WebDriver driver) {
        super(driver);
    }

    /**
     Clicks on the HTML button.
     */
    public void clickOnHTML() {
        btn_html.click();
    }

    /**
     Checks if the HTML button is displayed on the web page.
     @return True if the HTML button is displayed, false otherwise.
     */
    @Override
    public boolean isOnPage() {
        return super.isOnPage(btn_html);
    }
}


