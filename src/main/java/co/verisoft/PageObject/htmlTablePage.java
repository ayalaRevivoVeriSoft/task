package co.verisoft.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

/**
 * This class represents a web page with an HTML table on it. It extends the basePageWeb class.
 * <p>
 * It contains WebElements for the table headers and cells.
 */
public class htmlTablePage extends basePageWeb {
    /**
     * The header element of the page.
     */

    @FindBy(css = "#main>h1")
    public WebElement txt_h1;
    /**
     * List of WebElements representing the table headers.
     */
    @FindBy(css = "table#customers>tbody>th")
    public List<WebElement> list_th;

    /**
     * List of WebElements representing the cells for the first row of data.
     */
    @FindBy(css = "table#customers>tbody>tr:nth-child(2)>td:nth-child(2) + td")
    public List<WebElement> alfreds_futterkiste;

    /**
     * List of WebElements representing the cells for the second row of data.
     */
    @FindBy(css = "table#customers>tbody>tr:nth-child(3)>td:nth-child(2) + td")
    public List<WebElement> centro_comercial_moctezuma;

    /**
     * Constructor for the htmlTablePage class.
     *
     * @param driver The WebDriver object used to interact with the web page.
     */
    public htmlTablePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Overrides the isOnPage() method in the basePageWeb class to always return false, as there is no clear
     * indicator of the page being loaded in this case.
     *
     * @return Always false.
     */
    @Override
    public boolean isOnPage() {
        return super.isOnPage(txt_h1);
    }

    /**
     * Checks if the table headers match the given list of strings.
     *
     * @param ls The list of strings to compare the table headers to.
     * @return True if all table headers match a string in the given list, false otherwise.
     */
    public boolean checkTh(List<String> ls) {
        for (WebElement e : list_th) {
            if (!ls.contains(e.getText())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the contact country values in the given list of WebElements match the given list of strings.
     *
     * @param ls The list of strings to compare the contact country values to.
     * @param lw The list of WebElements representing the contact country values.
     * @return True if all contact country values match a string in the given list, false otherwise.
     */
    public boolean checkContactCountry(List<String> ls, List<WebElement> lw) {
        for (WebElement e : lw) {
            if (!ls.contains(e.getText())) {
                return false;
            }
        }
        return true;
    }
}
