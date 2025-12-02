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

  public void printCoffeeDetails() {
    System.out.println(name + ":");
    System.out.println("Coffee intensity: " + intensity);
  }

  public void makeCoffee() {
    System.out.println("Making " + name);
    System.out.println("Intensity set to " + intensity);
  }
}
