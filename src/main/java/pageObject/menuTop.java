package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class menuTop {
//    "//*[@title='HTML Tutorial']"
    @FindBy(linkText=("HTML")) public List<WebElement> btn_html;
public void clickOnHTML(){
    System.out.println("sss");
    btn_html.get(0).click();
}

}
