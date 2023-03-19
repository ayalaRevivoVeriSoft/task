package co.verisoft.PageObject;

import co.verisoft.fw.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the left menu on a web page that extends the BasePage class.
 * <p>
 * It contains methods to interact with the menu items.
 */
public class menuLeft extends BasePage {

    /**
     * Constructor for the menuLeft class.
     *
     * @param driver The WebDriver object used to interact with the web page.
     */
    public menuLeft(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks on the link with the specified text in the left menu.
     *
     * @param stringToGOTo The text of the link to click on.
     */
    public void goTo(WebDriver driver, String stringToGOTo) {
        WebElement element = driver.findElements(By.linkText(stringToGOTo)).get(0);
        element.click();
    }

    /**
     * Checks if the list of strings contains the text of all the elements in the list of WebElements.
     *
     * @param lsToChack  The list of strings to check for the presence of.
     * @param leFromeWeb The list of WebElements to check against.
     * @return True if all the text in the list of WebElements is present in the list of strings, false otherwise.
     */
    public boolean listContain(List<String> lsToChack, List<WebElement> leFromeWeb) {
        System.out.println(lsToChack);
        for (WebElement element : leFromeWeb) {
            if (!lsToChack.contains(element.getText())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the list of strings contains only the text of the elements in the list of WebElements.
     *
     * @param lsToChack  The list of strings to check for the presence of.
     * @param leFromeWeb The list of WebElements to check against.
     * @return True if the text in the list of WebElements is equal to the list of strings, false otherwise.
     */
    public boolean onlyListContain(List<String> lsToChack, List<WebElement> leFromeWeb) {
        List<String> leToString = new ArrayList<String>();
        for (WebElement element : leFromeWeb) {
            leToString.add(element.getAttribute("innerHTML"));
        }
        return leToString.equals(lsToChack);
    }

    /**
     * This method is not used for the menuLeft class and always returns false.
     *
     * @return Always returns false.
     */
    @Override
    public boolean isOnPage() {
        return false;
    }
}
