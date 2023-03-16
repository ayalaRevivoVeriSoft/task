package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaIntroductionPage extends basePageWeb {


    @FindBy(xpath="//*[@id='main']/h1") public WebElement txt_h1;

    public JavaIntroductionPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isOnPage() {
        return super.isOnPage(txt_h1);
    }


}
