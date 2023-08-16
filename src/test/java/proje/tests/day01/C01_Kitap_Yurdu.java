package proje.tests.day01;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import proje.pages.kitapyurdu.Anasayfa;
import proje.pages.kitapyurdu.Sepetim_Sayfasi;
import proje.pages.kitapyurdu.Teslimat_Sayfasi;
import proje.pages.kitapyurdu.Urunler_Sayfasi;
import proje.utilities.ConfigReader;
import proje.utilities.Driver;
import proje.utilities.ExtentReport;
import proje.utilities.ReusableMethods;

import java.util.List;


public class C01_Kitap_Yurdu extends ExtentReport {

    Anasayfa anasayfa = new Anasayfa();
    Urunler_Sayfasi urunlerSayfasi = new Urunler_Sayfasi();
    Sepetim_Sayfasi sepetimSayfasi = new Sepetim_Sayfasi();
    Teslimat_Sayfasi teslimatSayfasi = new Teslimat_Sayfasi();

    @Test
    public void test01() {
        extentTest = extentReports.createTest("Extend Test", "Test Raporu");
        // https://www.kitapyurdu.com/ adresine gidiniz.
        Driver.getDriver().get(ConfigReader.getProperty("kitapYurduUrl"));
        extentTest.info("Kitapyurdu sitesine gidildi.");
        // Arama motorunda "Java" kelimesini aratınız.
        anasayfa.aramaKutusu.sendKeys(ConfigReader.getProperty("aranacakKelime"), Keys.ENTER);
        extentTest.info("Arama motorunda Java kelimesi aratildi.");
        // Listedeki birinci ve ikinci ürünü sepete ekleyiniz.
        urunlerSayfasi.birinciUrunSepeteEkle.click();
        ReusableMethods.bekle(2);
        urunlerSayfasi.ikinciUrunSepeteEkle.click();
        ReusableMethods.bekle(2);
        extentTest.info("Listedeki birinci ve ikinci ürünü sepete eklendi.");
        //ikinci urun sepete  eklendiğini dogrula
        sepetimSayfasi.sepetimClick.click();
        Assert.assertTrue(sepetimSayfasi.sepettekiUrun.isDisplayed());
        extentTest.info("ikinci urunun sepete eklendiği dogrulandi.");
        // birinci urunun sepete  eklendiğini urun listesi ile dogrula
        //Assert.assertTrue(kitapYurduPages.sepettekiIkinciUrun.isDisplayed());
        List<WebElement> urunList = sepetimSayfasi.sepetimdekiUrunler;
      /*
        for (int i = 0; i < urunList.size() ; i++) {
            System.out.println(urunList.get(0).getText());
        }
       */
        urunList.forEach(t -> System.out.println(t.getText()));
        Assert.assertEquals(sepetimSayfasi.aramaSonucuIlkUrun.getText(), urunList.get(1).getText());
        extentTest.info("Birinci urunun sepete eklendiği urun listesi ile dogrulandi.");
        //  İlk ürünün miktarını 2, ikinci ürünün miktarını 3 olarak değiştiriniz.
        sepetimSayfasi.sepeteGit.click();
        sepetimSayfasi.ilkUrunMiktar.clear();
        sepetimSayfasi.ilkUrunMiktar.sendKeys("2");
        extentTest.info("İlk ürünün miktarı 2 olarak değiştirildi.");
        ReusableMethods.bekle(1);
        sepetimSayfasi.ikinciUrunMiktar.clear();
        sepetimSayfasi.ikinciUrunMiktar.sendKeys("3");
        extentTest.info("Ikinci ürünün miktarı 3 olarak değiştirildi.");
        //"Alisverişe devam et" fonksiyonunun görünür olmadığını doğrulayınız.
        Assert.assertTrue(sepetimSayfasi.alisVeriseDevamEt.isDisplayed());
        extentTest.info("Alisverişe devam et fonksiyonunun görünür oldugu doğrulandı...");
        // Ürünlere ait kontrol kutularını seçili hale getiriniz.
        sepetimSayfasi.kontrolKutulari.click();
        extentTest.info("Ürünlere ait kontrol kutuları seçili hale getirildi.");
        // Kontrol kutularının seçili olduğunu doğrulayınız.
        Assert.assertTrue(sepetimSayfasi.kutularinSeciliOldugunuDogrulama.isEnabled());
        extentTest.info("Kontrol kutularının seçili olduğu doğrulandı.");
        // İkinci ürüne ait kontrol kutusunun seçimini kaldırınız.
        sepetimSayfasi.ikinciUrunKontrolKutusu.click();
        extentTest.info("İkinci ürüne ait kontrol kutusunun seçimi kaldırıldı.");
        // İkinci ürüne ait kontrol kutusunun seçimini kaldırınız.
        // ZATEN BU SECIMI KALDIRDIK...
        //"Seçilenleri Daha Sonra Al" fonksiyonunun aktif olduğunu doğrulayınız.
        ReusableMethods.bekle(2);
        Assert.assertTrue(sepetimSayfasi.secilenleriDahaSonraAl.isEnabled());
        extentTest.info("Seçilenleri Daha Sonra Al fonksiyonunun aktif olduğu doğrulandı.");
        //Ikinci ürünü sepetten kaldır
        sepetimSayfasi.sepettekiIkinciUrunKaldirButton.click();
        extentTest.info("Ikinci ürün sepetten kaldırıldı.");
        //Sepetinizden çıkarılıyor! yazisinin görünürlüğünü doğrula
        Assert.assertEquals(sepetimSayfasi.sepetinizdenCikariliyorElement.getText(), "Sepetinizden çıkarılıyor!");
        extentTest.info("Sepetinizden çıkarılıyor! yazisinin görünürlüğü doğrulandı.");
        //Satın al butonuna tıkla
        sepetimSayfasi.satinAl.click();
        extentTest.info("Satın al butonuna tıklandı");
        ReusableMethods.bekle(2);
        //Uye olmadan devam et butonuna tıkla
        sepetimSayfasi.uyeOlmadanDevamEt.click();
        extentTest.info("Uye olmadan devam et butonuna tıklandı");
        ReusableMethods.bekle(2);
        //Güvenli Alışveriş logosunun görünürlüğünü doğrula.
        Assert.assertTrue(teslimatSayfasi.guvenliAlisverisLogo.isDisplayed());
        extentTest.info("Güvenli Alışveriş logosunun görünürlüğü doğrulandı.");
        extentTest.pass("Test sonlandırıldı.");

    }
}
