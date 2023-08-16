package proje.pages.kitapyurdu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import proje.utilities.Driver;

public class Teslimat_Sayfasi {
    public Teslimat_Sayfasi() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@src='https://img.kitapyurdu.com/v1/getImage/fn:11708205/wh:b9ab2f0d4']")
    public WebElement guvenliAlisverisLogo;
}
