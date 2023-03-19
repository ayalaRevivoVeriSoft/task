package co.verisoft.PageObject;

import co.verisoft.fw.pages.BasePage;
import org.openqa.selenium.WebDriver;


/**
 * This abstract class represents a base web page. It extends the BasePage class
 * and provides access to the left and top menus, as well as the top buttons section.
 * Subclasses can override the isOnPage method to check if they are on the expected page.
 */
public abstract class basePageWeb extends BasePage {

    /**
     * The menuLeft object represents the left-hand menu of the webpage.
     */
    public menuLeft mLeft;

    /**
     * The menuTop object represents the top menu of the webpage.
     */
    public menuTop mTop;

    /**
     * The buttonTop object represents the top buttons section of the webpage.
     */
    public buttonTop btnTop;

    /**
     * Initializes the left and top menus, as well as the top buttons section,
     * by using the PageFactory class to create new instances of the menuLeft,
     * menuTop, and buttonTop classes.
     *
     * @param driver the WebDriver object used to interact with the browser
     */
    public basePageWeb(WebDriver driver) {
        super(driver);
        mLeft = new menuLeft(driver);
        mTop = new menuTop(driver);
        btnTop = new buttonTop(driver);
    }

    /**
     * Subclasses should override this method to check if they are on the expected page.
     *
     * @return true if the subclass is on the expected page, false otherwise
     */
    @Override
    public abstract boolean isOnPage();

}
