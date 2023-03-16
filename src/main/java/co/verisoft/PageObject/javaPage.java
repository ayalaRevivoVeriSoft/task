package co.verisoft.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**

 This class represents a Java page on a website that extends the basePageWeb class.

 It contains WebElements for the page's header, left menu, and output and variables lists.
 */
public class javaPage extends basePageWeb {

    /**
     Web element for the h1 header on the page.
     */
     @FindBy(xpath = "//[@id='main']/h1")
     public WebElement txt_h1;

     /**
     List of WebElements for the items in the left menu.
     */
     @FindBy(xpath = "//[@id='leftmenuinnerinner']/a")
     public List<WebElement> menu_list;

     /**
     List of WebElements for the output items on the page.
     */
     @FindBy(xpath = "//[@id='leftmenuinnerinner']/div[1]/a")
     public List<WebElement> list_output;

     /**
     List of WebElements for the variables items on the page.
      */
     @FindBy(xpath = "//[@id='leftmenuinnerinner']/div[2]/a")
     public List<WebElement> list_variables;

     /**
     Constructor for the javaPage class.
     @param driver The WebDriver object used to interact with the web page.
     */
    public javaPage(WebDriver driver) {
        super(driver);
    }

    /**
     Overrides the isOnPage() method in the basePageWeb class to check if the h1 header is present on the page.
     @return True if the h1 header is present on the page, false otherwise.
     */
    @Override
    public boolean isOnPage() {
        return super.isOnPage(txt_h1);
    }

}