package co.verisoft.PageObject;

import co.verisoft.fw.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

/**
 * A page object representing the home page of a website.
 */
public class homePage extends BasePage {
    // Page element locators
    @FindBy(className = "learntocodeh1")
    public WebElement txt_h1;
    @FindBy(id = "search2")
    public WebElement input_search;
    @FindBy(id = "listofsearchresults")
    public WebElement div_search;

    /**
     * Constructs a new instance of the home page with the given WebDriver.
     *
     * @param driver the WebDriver to use for interacting with the page
     */
    public homePage(WebDriver driver) {
        super(driver);

    }

    /**
     * Inserts the given text into the search input field.
     *
     * @param txt the text to insert
     */
    public void insertTextToSearch(String txt) {
        input_search.sendKeys(txt);
    }

    /**
     * Returns true if the search results list is open, false otherwise.
     *
     * @return true if the search results list is open, false otherwise
     */
    public boolean listOpen() {
        return !div_search.getAttribute("style").contains("none");
    }

    /**
     * Returns true if the search results list contains the given string, false otherwise.
     *
     * @param str the string to search for in the search results list
     * @return true if the search results list contains the given string, false otherwise
     */
    public boolean listContainStr(String str) {

        List<WebElement> list_search = div_search.findElements(By.className("search_item"));

        for (WebElement e : list_search) {
            if (!(e.getText().toLowerCase()).contains(str)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Chooses the search result with the given text.
     *
     * @param txt the text of the search result to choose
     */

    public void chooseOne(String txt) {
        List<WebElement> list_search = div_search.findElements(By.className("search_item"));
        for (WebElement e : list_search) {
            if ((e.getText().toLowerCase()).equals(txt)) {
                e.click();
                break;
            }
        }
    }

    /**
     * Returns true if the page is on the home page, false otherwise.
     */
    @Override
    public boolean isOnPage() {
        return super.isOnPage(txt_h1);
    }
}
