package co.verisoft.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**

 This class represents a web page with an HTML table on it. It extends the basePageWeb class.

 It contains WebElements for the table headers and cells.
 */
public class htmlTablePage extends basePageWeb {

    /**
     List of WebElements representing the table headers.
     */
     @FindBy(xpath = "//*[@id='customers']/tbody/tr[1]/th")
     public List<WebElement> list_th;

     /**
     List of WebElements representing the cells for the first row of data.
      */
     @FindBy(xpath = "//*[@id='customers']/tbody/tr[2]/td[position()>=2 and position()<4]")
     public List<WebElement> alfreds_futterkiste;

     /**
     List of WebElements representing the cells for the second row of data.
      */
     @FindBy(xpath = "//*[@id='customers']/tbody/tr[3]/td[position()>=2 and position()<4]")
     public List<WebElement> centro_comercial_moctezuma;

     /**
     Constructor for the htmlTablePage class.
     @param driver The WebDriver object used to interact with the web page.
     */
    public htmlTablePage(WebDriver driver) {
        super(driver);
    }

    /**
     Overrides the isOnPage() method in the basePageWeb class to always return false, as there is no clear
     indicator of the page being loaded in this case.
     @return Always false.
     */
    @Override
    public boolean isOnPage() {
        return false;
    }

    /**
     Checks if the table headers match the given list of strings.
     @param ls The list of strings to compare the table headers to.
     @return True if all table headers match a string in the given list, false otherwise.
     */
    public boolean checkTh(List<String> ls) {
        System.out.println("ss");
        for (WebElement e : list_th) {
            System.out.println(e.getText());
            if (!ls.contains(e.getText())) {
                return false;
            }
        }
        return true;
    }

    /**
     Checks if the contact country values in the given list of WebElements match the given list of strings.
     @param ls The list of strings to compare the contact country values to.
     @param lw The list of WebElements representing the contact country values.
     @return True if all contact country values match a string in the given list, false otherwise.
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
