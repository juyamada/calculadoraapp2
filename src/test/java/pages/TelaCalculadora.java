package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class TelaCalculadora {
    // construtor
    final AppiumDriver driver;

    public TelaCalculadora(AppiumDriver driver){
      this.driver = driver;
      PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // mapeamento de elementos
      
      //não mapeei o número pois o @AndroidFindBy não permite concatenar o elemento mais o num
      //@AndroidFindBy (id = "com.google.android.calculator:id/digit_" + num) 
      //MobileElement numero;
      
      @AndroidFindBy (id = "com.google.android.calculator:id/op_add")
      WebElement botaoSoma;

      @AndroidFindBy (id = "com.google.android.calculator:id/eq")
      WebElement botaoIgual;

      @AndroidFindBy (id = "com.google.android.calculator:id/result_final")
      WebElement resultado;

      // ações dos elementos

      public void digitarNumeroX(String numx) {
        
        driver.findElement(By.id("com.google.android.calculator:id/digit_" + numx)).click();
      }

      public void digitarNumeroY(String numy) {
        
        driver.findElement(By.id("com.google.android.calculator:id/digit_" + numy)).click();
      }
      
      public void digitarSoma(){
        botaoSoma.click();
      }

      public void digitarIgual(){
        botaoIgual.click();
      }

      public String obterResultado(){
        return resultado.getText();
      }
      
}
