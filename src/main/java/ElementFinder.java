import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementFinder {
  ChromeDriver driver;

  public ElementFinder(ChromeDriver driver) {
    this.driver = driver;
  }

  public boolean isCookieAlertVisible() {
    try {
      findElement(Element.CookieAlert);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public WebElement findButtonByText(String text) {
    return findElement(Element.Button, text);
  }

  public WebElement findRadiobuttonByLabel(String... label) {
    return findElement(Element.Radiobutton, label);
  }

  public WebElement findElementByLabel(String label) {
    return findElement(Element.Listfield, label);
  }

  private WebElement findElement(Element element) {
    return findElement(element, (String) null);
  }

  private WebElement findElement(Element element, String... text) {
    String xpath = getXPath(element, text);
    WebElement webElement = driver.findElementByXPath(xpath);
    return webElement;
  }

  private String getXPath(Element element, String... args) {
    switch (element) {
      case CookieAlert:
        return "//div[@class='uc-banner-content']";
      case Button:
        return "//button[contains(string(),'" + args[0] + "')] | //button[.='" + args[0] + "']";
      case Radiobutton:
        return "//div[(.|ancestor::div[preceding-sibling::div[contains(@class,'Title') and .='" + args[0] +
            "']])][contains(@class,'Radio')]/label[.='" + args[1] + "']";
      case Listfield:
        return "//div[contains(@class,'ListField')]/label[.='" + args[0] + "']";
      default:
        return null;
    }
  }

  enum Element {
    CookieAlert, Button, Radiobutton, Listfield
  }
}
