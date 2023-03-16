package pageObject;

import co.verisoft.fw.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static co.verisoft.fw.utils.Asserts.assertEquals;
import static co.verisoft.fw.utils.Asserts.assertTrue;

import java.util.List;

public class homePage extends BasePage {
    @FindBy(className="learntocodeh1") public WebElement txt_h1;
    @FindBy(id="search2") public WebElement input_search;
    @FindBy(id="listofsearchresults") public WebElement div_search;

    public homePage(WebDriver driver) {
        super(driver);
    }
//    @FindBy(id="search_item") public ;

    public  void insertText(String txt){
        input_search.sendKeys(txt);
    }
    public boolean listOpen(){
       return !div_search.getAttribute("style").contains("none");
    }
    public boolean listContainStr(String str){

        List<WebElement> list_search=div_search.findElements(By.className("search_item"));

        for (WebElement e:list_search) {
            if(!(e.getText().toLowerCase()).contains(str)){
                return false;
            }
        }
        return true;
    }
    public void chooseOne(String txt){
        List<WebElement> list_search=div_search.findElements(By.className("search_item"));
        //txt.replace("java", "");
       //System.out.println(list_search.size());
        for (WebElement e:list_search) {

            if((e.getText().toLowerCase()).equals(txt))
            {
                e.click();
    break;
            }
        }
    }

    @Override
    public boolean isOnPage() {
      return  super.isOnPage(txt_h1);
    }
}
