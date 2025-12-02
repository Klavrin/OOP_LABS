public class PumpkinSpiceLatte extends Coffee {
  int mlOfMilk;
  int mlOfPumpkingSpice;

  public PumpkinSpiceLatte(Intensity intensity, int mlOfMilk, int mlOfPumpkingSpice) {
    super(intensity, "Pumpkin Spice Latte");
    this.mlOfMilk = mlOfMilk;
    this.mlOfPumpkingSpice = mlOfPumpkingSpice;
  }

  public int getMlOfMilk() {
    return mlOfMilk;
  }

  public int getMlOfPumpkingSpice() {
    return mlOfPumpkingSpice;
  }

  @Override
  public void printCoffeeDetails() {
    super.printCoffeeDetails();
    System.out.println("Milk: " + mlOfMilk + "ml");
    System.out.println("Pumpkin spice: " + mlOfPumpkingSpice + "ml");
  }
}
