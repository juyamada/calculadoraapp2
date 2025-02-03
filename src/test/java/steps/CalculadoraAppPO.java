package steps;

import io.appium.java_client.remote.options.BaseOptions;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.TelaCalculadora;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import java.util.Map;

public class CalculadoraAppPO {

  private URL getUrl() {
    try {
      return new URL("https://juliana_yamada:9d3a3a77-93f2-45c6-be26-2b40255251a9@ondemand.us-west-1.saucelabs.com:443/wd/hub");
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @BeforeEach
  public void setUp() {
    UiAutomator2Options options = new UiAutomator2Options()
      .amend("platformName", "Android")
      .amend("appium:platformVersion", "9.0")
      .amend("appium:deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator")
      .amend("appium:deviceOrientation", "portrait")
      .amend("appium:app", "storage:filename=mda-2.2.0-25.apk")
      .amend("appium:appPackage", "com.saucelabs.mydemoapp.android")
      .amend("appium:appActivity", "com.saucelabs.mydemoapp.android.view.activities.SplashActivity")
      .amend("appium:automationName", "UiAutomator2")
      .amend("browserName", "")
      .amend("appium:ensureWebviewsHavePages", true)
      .amend("appium:nativeWebScreenshot", true)
      .amend("appium:newCommandTimeout", 3600)
      .amend("appium:connectHardwareKeyboard", true);

    driver = new AndroidDriver(this.getUrl(), options);
    telaCalculadora = new TelaCalculadora(driver);

  }

    private AndroidDriver driver;
    private TelaCalculadora telaCalculadora;
    
   
    @Dado("que eu somo dois valores {string} e {string}")
    public void que_eu_somo_dois_valores_e(String numx , String numy){
        telaCalculadora.digitarNumeroX(numx);
        telaCalculadora.digitarSoma();
        telaCalculadora.digitarNumeroY(numy);
        
    }

    @Quando("eu clicar em igual") 
    public void eu_clicar_em_igual() {
        telaCalculadora.digitarIgual();   
    }

            
    @Entao("o {string} deve ser exibido corretamente")
    public void o_deve_ser_exibido_corretamente(String valorEsperado){
    
        assertEquals(valorEsperado, telaCalculadora.obterResultado());
    }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }
}

      