package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class JuntaSecundaria {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    baseUrl = "https://www.blazedemo.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testJuntaSecundaria() throws Exception {
    // Label: Test
    // ERROR: Caught exception [ERROR: Unsupported command [resizeWindow | 1454,727 | ]]
    driver.get(baseUrl + "chrome://newtab/");
    driver.get("https://cidi.cba.gov.ar/portal-publico/");
    driver.findElement(By.cssSelector("mat-toolbar.wrapp-nav-top.mat-toolbar.mat-toolbar-single-row")).click();
    driver.findElement(By.cssSelector("mat-toolbar.wrapp-nav-top.mat-toolbar.mat-toolbar-single-row")).click();
    driver.findElement(By.cssSelector("div.ingreso")).click();
    driver.findElement(By.cssSelector("span.mat-button-wrapper")).click();
    driver.findElement(By.id("mat-input-2")).clear();
    driver.findElement(By.id("mat-input-2")).sendKeys("20-40028514-5");
    driver.findElement(By.id("mat-input-3")).clear();
    driver.findElement(By.id("mat-input-3")).sendKeys("Rivadavia850");
    driver.findElement(By.cssSelector("div.cdk-overlay-container")).click();
    driver.findElement(By.cssSelector("button.btn--primario.btn--glow.mat-raised-button.cdk-focused.cdk-mouse-focused")).click();
    driver.findElement(By.cssSelector("div.mat-form-field-infix")).click();
    driver.findElement(By.id("mat-input-0")).clear();
    driver.findElement(By.id("mat-input-0")).sendKeys("junta");
    driver.findElement(By.id("mat-input-0")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("//app-servicio-card[3]/mat-card/div/p")).click();
    driver.findElement(By.cssSelector("button.btn--primario.boton-ingresar.mat-flat-button.mat-button-base.cdk-focused.cdk-mouse-focused")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
    driver.findElement(By.xpath("//div[@id='R254529506458309364']/div[2]/div[2]/ul/li[2]/div/a/div")).click();
    driver.findElement(By.cssSelector("center")).click();
    driver.findElement(By.id("P15_DEPARTAMENTO")).click();
    new Select(driver.findElement(By.id("P15_DEPARTAMENTO"))).selectByVisibleText("CAPITAL");
    driver.findElement(By.id("P15_DEPARTAMENTO")).click();
    driver.findElement(By.id("P15_LOCALIDAD")).click();
    new Select(driver.findElement(By.id("P15_LOCALIDAD"))).selectByVisibleText("CORDOBA");
    driver.findElement(By.id("P15_LOCALIDAD")).click();
    driver.findElement(By.cssSelector("#P15_OBTENER_VACANTES > span")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
