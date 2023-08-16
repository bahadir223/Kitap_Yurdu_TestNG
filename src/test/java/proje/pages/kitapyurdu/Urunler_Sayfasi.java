package proje.pages.kitapyurdu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import proje.utilities.Driver;

public class Urunler_Sayfasi {
    public Urunler_Sayfasi() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class='add-to-cart'])[2]")
    public WebElement birinciUrunSepeteEkle;

    @FindBy(xpath = "(//a[@class='add-to-cart'])[3]")
    public WebElement ikinciUrunSepeteEkle;

}
