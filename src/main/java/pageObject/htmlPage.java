package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class htmlPage extends basePageWeb {
    @FindBy(xpath="//*[@id='main']/h1") public WebElement txt_h1;

    public void goTo(String s){
       WebElement element= driver.findElements(By.linkText(s)).get(0);
       element.click();
    }
    public htmlPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOnPage() {
    return     super.isOnPage(txt_h1);
    }
}
