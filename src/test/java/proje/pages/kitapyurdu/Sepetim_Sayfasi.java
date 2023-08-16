package proje.pages.kitapyurdu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import proje.utilities.Driver;

import java.util.List;

public class Sepetim_Sayfasi {
    public Sepetim_Sayfasi() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='cart']")
    public WebElement sepetimClick;

    @FindBy(xpath = "//a[@id='js-cart']")
    public WebElement sepeteGit;

    @FindBy(xpath = "//*[@class='ellipsis'] ")
    public List<WebElement> sepetimdekiUrunler;

    @FindBy(xpath = "(//td/a)[1]")
    public WebElement sepettekiUrun;

    @FindBy(xpath = "(//*[@class='name'])[3]")
    public WebElement aramaSonucuIlkUrun;

    @FindBy(xpath = "(//td/a)[2]")
    public WebElement sepettekiIkinciUrun;

    @FindBy(xpath = "(//input[@name='quantity'])[2]")
    public WebElement ilkUrunMiktar;

    @FindBy(xpath = "(//input[@name='quantity'])[1]")
    public WebElement ikinciUrunMiktar;

    @FindBy(xpath = "//a[@class='button']")
    public WebElement alisVeriseDevamEt;

    @FindBy(xpath = "//input[@id='select-all-cart']")
    public WebElement kontrolKutulari;

    @FindBy(xpath = "//a[@id='cart-selected-button']")
    public WebElement kutularinSeciliOldugunuDogrulama;

    @FindBy(xpath = "(//input[@class='cart-select'])[1]")
    public WebElement ikinciUrunKontrolKutusu;

    @FindBy(xpath = "//a[@id='cart-selected-button']")
    public WebElement secilenleriDahaSonraAl;

    @FindBy(xpath = "(//*[@class='fa fa-times red-icon'])[2]")
    public WebElement sepettekiIkinciUrunKaldirButton;

    @FindBy(xpath = "//*[text()='Sepetinizden çıkarılıyor!']")
    public WebElement sepetinizdenCikariliyorElement;

    @FindBy(xpath = "(//*[@class='button red'])[2]")
    public WebElement satinAl;

    @FindBy(xpath = "//*[@href='https://www.kitapyurdu.com/index.php?route=checkout/delivery&guest=1']")
    public WebElement uyeOlmadanDevamEt;
}
