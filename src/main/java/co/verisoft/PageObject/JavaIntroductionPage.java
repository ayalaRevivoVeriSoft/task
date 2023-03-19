package co.verisoft.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * This class represents the Java Introduction page on a website that extends the basePageWeb class.
 * <p>
 * It contains a WebElement for the page's header.
 */
public class JavaIntroductionPage extends basePageWeb {

    /**
     * Web element for the h1 header on the page.
     */
    @FindBy(css = "#main>h1")
    public WebElement txt_h1;

    /**
     * Constructor for the JavaIntroductionPage class.
     *
     * @param driver The WebDriver object used to interact with the web page.
     */
    public JavaIntroductionPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Overrides the isOnPage() method in the basePageWeb class to check if the h1 header is present on the page.
     *
     * @return True if the h1 header is present on the page, false otherwise.
     */
    @Override
    public boolean isOnPage() {
        return super.isOnPage(txt_h1);
    }
}