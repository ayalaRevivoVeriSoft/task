package pageObject;

import co.verisoft.fw.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class menuLeft  {
    @FindBy(xpath="//*[@id='leftmenuinnerinner']/a") public List<WebElement> menu_list;
    @FindBy(xpath="//*[@id='leftmenuinnerinner']/div[1]/a") public List<WebElement> list_output;
    @FindBy(xpath="//*[@id='leftmenuinnerinner']/div[2]/a") public List<WebElement> list_variables;





    public boolean listContain(List<String> ls,List<WebElement> le) {
//        List<String> ls=new ArrayList<String>();
//        for (WebElement e:menu_list) {
//            ls.add(e.getText());
//        }
//        return  le.containsAll(ls);
        for (WebElement e:le) {
            if(!ls.contains(e.getText())){
                return false;
            }
        }

        return true;
    }
    public boolean onlylistContain(List<String> ls,List<WebElement> le) {
        List<String> leToString=new ArrayList<String>();
        for (WebElement e:le) {
            leToString.add(e.getAttribute("innerHTML"));
        }
        System.out.println(leToString);
return  leToString.equals(ls);
    }
    public boolean listOpenIsEqual(List<List<String>> lss,List<List<WebElement>> les){
        for (int i = 0; i <lss.size() ; i++) {
            if (!onlylistContain(lss.get(i),les.get(i))) {
                return false;
            }
        }

        return true;
    }

}
