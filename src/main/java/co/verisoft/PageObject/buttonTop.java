package co.verisoft.PageObject;

import co.verisoft.fw.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * This class represents the top buttons section of a webpage.
 * It provides methods to click on the Next and Previous buttons.
 */
public class buttonTop extends BasePage {

    /**
     * A list of WebElements representing the "Next" buttons.
     * Each element in the list can be clicked to navigate to the next page.
     */
    @FindBy(linkText = "Next ❯")
    public List<WebElement> btn_next;

    /**
     * A list of WebElements representing the "Previous" buttons.
     * Each element in the list can be clicked to navigate to the previous page.
     */

    @FindBy(css = "a[class='w3-left w3-btn']")
    public List<WebElement> btn_prev;

    public buttonTop(WebDriver driver) {
        super(driver);
    }
    /**
     * Clicks the first "Next" button in the list to navigate to the next page.
     */
    public void clickBTNNext() {
        btn_next.get(0).click();
    }

    /**
     * Clicks the first "Previous" button in the list to navigate to the previous page.
     */
    public void clickBTNPrev() {

        btn_prev.get(0).click();
    }

    @Override
    public boolean isOnPage() {
        return false;
    }
}


