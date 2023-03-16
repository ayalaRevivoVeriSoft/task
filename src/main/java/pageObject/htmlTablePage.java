package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class htmlTablePage extends basePageWeb {
    @FindBy(xpath="//*[@id='customers']/tbody/tr[1]/th") public List<WebElement> list_th;
    @FindBy(xpath="//*[@id='customers']/tbody/tr[2]/td[position()>=2 and position()<4]") public List<WebElement> alfreds_futterkiste;
    @FindBy(xpath="//*[@id='customers']/tbody/tr[3]/td[position()>=2 and position()<4]") public List<WebElement> centro_comercial_moctezuma	;

    public htmlTablePage(WebDriver driver) {
        super(driver);
    }

    public boolean checkTh(List<String> ls){

        for (WebElement e:list_th) {
            if(!ls.contains(e.getText())){
                return false;
            }
        }
        return  true;
    }
    public boolean checkContactCountry(List<String> ls, List<WebElement> lw){
        for (WebElement e:lw) {
            if(!ls.contains(e.getText())){
                return false;
            }
        }
        return true;
    }

}
