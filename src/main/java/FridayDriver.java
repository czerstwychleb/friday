import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FridayDriver {
  ChromeDriver driver;
  ElementFinder finder;

  public FridayDriver() {
    driver = initDriver();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    finder = new ElementFinder(driver);
  }

  private ChromeDriver initDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    options.addArguments("incognito");
    options.addArguments("--disable-notifications");
    options.addArguments("disable-infobars");
    Map prefs = new HashMap();
    prefs.put("profile.default_content_settings.popups", 0);
    options.setExperimentalOption("prefs", prefs);
    options.setExperimentalOption("w3c", false);
    return new ChromeDriver(options);
  }

  public void startOffering() {
    driver.get("https://hello.friday.de");
    handleCookies();
  }

  private void handleCookies() {
    if (finder.isCookieAlertVisible()) {
      acceptCookies();
    }
  }

  private void acceptCookies() {
    clickButtonByText("Akzeptieren");
  }

  public void setRadiobuttonByLabel(String label) {
    setRadiobuttonByLabel(null, label);
  }

  public void setRadiobuttonByLabel(String title, String label) {
    WebElement radio = finder.findRadiobuttonByLabel(title, label);
    radio.click();
  }

  public void clickButtonByText(String text) {
    WebElement button = finder.findButtonByText(text);
    button.click();
  }

  public void clickListfieldByLabel(String label) {
    WebElement listField = finder.findElementByLabel(label);
    listField.click();
  }

  public void close() {
    driver.close();
  }
}
