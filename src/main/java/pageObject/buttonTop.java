package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class buttonTop {
@FindBy(linkText="Next ❯") public List<WebElement> btn_next;
    @FindBy(xpath="//*[@id='main']/div[2]/a[1]") public List<WebElement> btn_prev;
public void clickBTNNext(){
    btn_next.get(0).click();
}
    public void clickBTNPrev(){
        System.out.println(btn_prev);
        btn_prev.get(0).click();
    }
}
