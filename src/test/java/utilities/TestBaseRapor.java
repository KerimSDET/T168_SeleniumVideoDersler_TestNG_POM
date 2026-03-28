package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TestBaseRapor {


    protected static ExtentReports extentReports; //extent report'a ilk atamayi yapar
    protected static ExtentTest extentTest; // test pass veya failed gibi bilgileri kaydeder. Ayrica ekran resmi icin de kullaniriz
    protected static ExtentSparkReporter extentSparkReporter; // Html raporu duzenler

    // Test işlemine başlamadan hemen önce (test methodundan önce değil, tüm test işleminden önce)
    @BeforeSuite(alwaysRun = true) // alwaysRun : her zaman çalıştır.
    public void setUpTest() {

        System.out.println(">>> BeforeSuite CALISTI");

        // BU SATIRI EKLE: Türkçe karakterli dosya yolu hatasını engeller
        java.util.Locale.setDefault(java.util.Locale.ENGLISH);

        extentReports = new ExtentReports(); // Raporlamayi baslatir
        //rapor oluştuktan sonra raporunuz nereye eklensin istiyorsanız buraya yazıyorsunuz.
        String date = new SimpleDateFormat("_yyyyMMdd_hhmmss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/test-output/Rapor"+date+".html";
        //oluşturmak istediğimiz raporu (html formatında) başlatıyoruz,

        new File(System.getProperty("user.dir") + "/test-output").mkdirs();
        // filePath ile dosya yolunu belirliyoruz.
        // date class'i ile raporumuza tarih etiketi ekliyoruz
        extentSparkReporter = new ExtentSparkReporter(filePath);
        extentReports.attachReporter(extentSparkReporter);

        // İstediğiniz bilgileri buraya ekeyebiliyorsunuz.
        extentReports.setSystemInfo("Enviroment","live");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser")); // chrome, firefox
        extentReports.setSystemInfo("Automation Engineer", "Kerim TIRPAN");
        extentSparkReporter.config().setDocumentTitle("TestNG Test");
        extentSparkReporter.config().setReportName("Html Reports");
    }


    // Her test methodundan sonra eğer assertion failed olursa, ekran görüntüsü alıp rapora ekliyor
    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws IOException {
        System.out.println("RAPOR BITTI");


        if (result.getStatus() == ITestResult.FAILURE) { // eğer testin sonucu başarısızsa
            String resimYolu = ReusableMethods.raporaResimEkle(result.getName());
            extentTest.fail(result.getName());
            extentTest.fail("Hata screenshot ile",
                    MediaEntityBuilder.createScreenCaptureFromPath("./" + resimYolu).build());//extentTest.addScreenCaptureFromPath(resimYolu);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) { // eğer test çalıştırılmadan geçilmezse
            extentTest.skip("Test Case is skipped: " + result.getName()); // Ignore olanlar
        }
        try {
            Driver.quitDriver();
        } catch (Exception e) {
            System.out.println("Driver kapatılırken hata: " + e.getMessage());
        }

    }


    // Raporlandırmayı sonlandırmak icin
    @AfterSuite(alwaysRun = true)
    public void tearDownTest() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}