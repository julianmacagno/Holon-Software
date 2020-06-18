package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ReimpresionConsultaOrdenDeMerito {
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
  public void testReimpresionConsultaOrdenDeMerito() throws Exception {
    // Label: Test
    // ERROR: Caught exception [ERROR: Unsupported command [resizeWindow | 1454,759 | ]]
    driver.get("https://cidi.cba.gov.ar/portal-publico/");
    driver.findElement(By.cssSelector("button.btn--primario.mat-raised-button.ng-star-inserted.cdk-focused.cdk-mouse-focused")).click();
    driver.findElement(By.id("mat-input-1")).clear();
    driver.findElement(By.id("mat-input-1")).sendKeys("20-40028514-5");
    driver.findElement(By.id("mat-input-2")).clear();
    driver.findElement(By.id("mat-input-2")).sendKeys("Rivadavia850");
    driver.findElement(By.cssSelector("div.cdk-overlay-container")).click();
    driver.findElement(By.id("mat-input-1")).clear();
    driver.findElement(By.id("mat-input-1")).sendKeys("20-33387812-8");
    driver.findElement(By.id("mat-input-2")).clear();
    driver.findElement(By.id("mat-input-2")).sendKeys("Jose2666");
    driver.findElement(By.id("my-form")).submit();
    driver.findElement(By.xpath("//div[4]/app-servicio-card/mat-card/div/div/img")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
    driver.findElement(By.cssSelector("span.t-Icon.fa.fa-clipboard-user")).click();
    driver.findElement(By.linkText("Reimpresión de la LOM")).click();
    driver.findElement(By.id("P6_ID_EMPRESA")).click();
    new Select(driver.findElement(By.id("P6_ID_EMPRESA"))).selectByVisibleText("EE0311434 - I.P.E.M. N° 410");
    driver.findElement(By.id("P6_ID_EMPRESA")).click();
    driver.findElement(By.xpath("//table[@id='173586301181248679']/tbody/tr[3]/td/a/img")).click();
    driver.findElement(By.cssSelector("#P12_IMPRIMIR_CONV1TITU > span")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_2 | ]]
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
