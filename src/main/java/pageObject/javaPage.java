package pageObject;

import co.verisoft.fw.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static co.verisoft.fw.utils.Asserts.assertTrue;

public class javaPage extends basePageWeb {
    @FindBy(xpath="//*[@id='main']/h1") public WebElement txt_h1;

    public javaPage(WebDriver driver) {
        super(driver);

    }



    @Override
    public boolean isOnPage() {
        return super.isOnPage(txt_h1);
    }




}
