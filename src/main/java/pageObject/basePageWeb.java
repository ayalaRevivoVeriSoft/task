package pageObject;

import co.verisoft.fw.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class basePageWeb extends BasePage {
    public menuLeft mLeft;
    public menuTop mTop;
    public buttonTop btnTop;

    public basePageWeb(WebDriver driver) {
        super(driver);
        mLeft = PageFactory.initElements(driver, menuLeft.class);
        mTop = PageFactory.initElements(driver, menuTop.class);

        btnTop = PageFactory.initElements(driver, buttonTop.class);
    }

    @Override
    public boolean isOnPage() {
        return false;
    }

}
