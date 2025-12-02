public class Coffee {
  Intensity intensity;
  String name = "Coffee";

  public Coffee(Intensity intensity, String name) {
    this.intensity = intensity;
    this.name = name;
  }

  public Intensity getIntensity() {
    return intensity;
  }

  public String getName() {
    return name;
  }
}
