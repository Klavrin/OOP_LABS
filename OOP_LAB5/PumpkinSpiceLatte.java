public class PumpkinSpiceLatte extends Coffee {
  int mlOfMilk;
  int mlOfpumpkingSpice;

  public PumpkinSpiceLatte(Intensity intensity, int mlOfMilk, int mlOfpumpkingSpice) {
    super(intensity, "Pumpkin Spice Latte");
    this.mlOfMilk = mlOfMilk;
    this.mlOfpumpkingSpice = mlOfpumpkingSpice;
  }

  public int getMlOfMilk() {
    return mlOfMilk;
  }

  @Override
  public void printCoffeeDetails() {
    super.printCoffeeDetails();
    System.out.println("Milk: " + mlOfMilk + "ml");
    System.out.println("Pumpkin Spice: " + mlOfpumpkingSpice + "ml");
  }
}
