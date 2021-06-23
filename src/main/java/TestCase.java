import org.testng.annotations.Test;

public class TestCase {
  FridayDriver driver = new FridayDriver();

  @Test
  public void test() {
    firstVehicle();
    secondVehicle();
    thirdVehicle();
    fourthVehicle();
    fifthVehicle();
    sixthVehicle();
    seventhVehicle();
    eighthVehicle();
    ninthVehicle();
    driver.close();
  }

  public void firstVehicle() {
    driver.startOffering();
    setDetails();
    selectVehicle("VW", "Caddy", "Kombi", "Benzin", "44 kW / 60 PS", "CADDY");
  }

  public void secondVehicle() {
    driver.startOffering();
    setDetails();
    selectVehicle("VW", "Passat", "Coupe", "Diesel", "103 kW / 140 PS", "PASSAT COUPE / CC 2.0 TDI 4-MOTION");
  }

  public void thirdVehicle() {
    driver.startOffering();
    setDetails();
    selectVehicle("VW", "Touran", "Benzin", "75 kW / 102 PS", "TOURAN 1.6");
  }

  public void fourthVehicle() {
    driver.startOffering();
    setDetails();
    selectVehicle("AUDI", "A4", "Limousine", "Diesel", "90 kW / 122 PS", "A4 2.0 TDI");
  }

  public void fifthVehicle() {
    driver.startOffering();
    setDetails();
    selectVehicle("AUDI", "Q7", "Benzin", "206 kW / 280 PS", "Q7 3.6 FSI");
  }

  public void sixthVehicle() {
    driver.startOffering();
    setDetails();
    selectVehicle("AUDI", "R8", "419 kW / 570 PS", "R8 5.2");
  }

  public void seventhVehicle() {
    driver.startOffering();
    setDetails();
    selectVehicle("HONDA", "Accord", "Coupe", "108 kW / 147 PS", "ACCORD COUPE 2.0");
  }

  public void eighthVehicle() {
    driver.startOffering();
    setDetails();
    selectVehicle("HONDA", "Civic", "Coupe", "74 kW / 101 PS", "CIVIC 1500 COUPE");
  }

  public void ninthVehicle() {
    driver.startOffering();
    setDetails();
    selectVehicle("HONDA", "Legend", "217 kW / 295 PS", "LEGEND 3.5");
  }

  private void setDetails() {
    driver.setRadiobuttonByLabel("Das Auto wird noch zugelassen oder umgemeldet");
    driver.clickButtonByText("Weiter");

    driver.setRadiobuttonByLabel("Wird das Auto auf dich zugelassen?", "Ja");
    driver.setRadiobuttonByLabel("Das Auto ist...", "bei Kauf neu");
    driver.clickButtonByText("Weiter");
  }

  private void selectVehicle(String... params) {
    for (String param : params) {
      driver.clickListfieldByLabel(param);
    }
    driver.clickButtonByText("Weiter");
  }
}
