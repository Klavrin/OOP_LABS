public class Americano extends Coffee {
  int mlOfWater;

  public Americano(Intensity intensity, int mlOfWater) {
    super(intensity, "Americano");
    this.mlOfWater = mlOfWater;
  }

  public int getMlOfWater() {
    return mlOfWater;
  }

  @Override
  public void printCoffeeDetails() {
    super.printCoffeeDetails();
    System.out.println("Water: " + mlOfWater + " ml");
  }
}
