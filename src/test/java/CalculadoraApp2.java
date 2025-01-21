// This sample code supports Appium Java client >=9
// https://github.com/appium/java-client
import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

public class CalculadoraApp2 {

  private AndroidDriver driver;

  @BeforeEach
  public void setUp() {
    var options = new BaseOptions()
      .amend("platformName", "Android")
      .amend("appium:platformVersion", "9.0")
      .amend("appium:deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator")
      .amend("appium:deviceOrientation", "portrait")
      .amend("appium:app", "storage:filename=Calculator_8.6.1 (625857114)_APKPure.apk")
      .amend("appium:appPackage", "com.google.android.calculator")
      .amend("appium:appActivity", "com.android.calculator2.Calculator")
      .amend("browserName", "")
      .amend("appium:ensureWebviewsHavePages", true)
      .amend("appium:nativeWebScreenshot", true)
      //.amend("sauce:options", Map.ofEntries(Map.entry("name", "Appium Desktop Session -- Jan 21, 2025 3:10 PM")))
      .amend("appium:newCommandTimeout", 3600)
      .amend("appium:connectHardwareKeyboard", true);

      driver = new AndroidDriver(this.getUrl(), options);
  }

    private URL getUrl() {
      try {
        return new URL("https://juliana_yamada:9d3a3a77-93f2-45c6-be26-2b40255251a9@ondemand.us-west-1.saucelabs.com:443/wd/hub");
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
      return null;
    }

  @Test
  public void testeSomar() {
    var num3 = driver.findElement(AppiumBy.accessibilityId("3"));
    num3.click();
    var num2 = driver.findElement(AppiumBy.accessibilityId("2"));
    num2.click();
    var somar = driver.findElement(AppiumBy.accessibilityId("plus"));
    somar.click();
    var num1 = driver.findElement(AppiumBy.accessibilityId("1"));
    num1.click();
    var num5 = driver.findElement(AppiumBy.accessibilityId("5"));
    num5.click();
    var igual = driver.findElement(AppiumBy.accessibilityId("equals"));
    igual.click();
    var resultado = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final"));
    assertEquals("47", resultado.getText());
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }
}
