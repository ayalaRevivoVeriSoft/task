package co.verisoft.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * This class represents the HTML page.
 */
public class htmlPage extends basePageWeb {
    /**
     * The header element of the page.
     */
    @FindBy(css = "#main>h1")
    public WebElement txt_h1;

    /**
     * Constructs a new htmlPage object.
     *
     * @param driver The WebDriver object to use.
     */
    public htmlPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Checks if the page is displayed.
     *
     * @return True if the page is displayed, false otherwise.
     */
    @Override
    public boolean isOnPage() {

        return super.isOnPage(txt_h1);
    }
}