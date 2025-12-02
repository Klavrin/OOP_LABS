public class PumpkinSpiceLatte extends Coffee {
  private int mlOfMilk;
  private int mlOfPumpkingSpice;

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

  public void setMlOfMilk(int mlOfMilk) {
    this.mlOfMilk = mlOfMilk;
  }

  public void setMlOfPumpkingSpice(int mlOfPumpkingSpice) {
    this.mlOfPumpkingSpice = mlOfPumpkingSpice;
  }

  @Override
  public void printCoffeeDetails() {
    super.printCoffeeDetails();
    System.out.println("Milk: " + mlOfMilk + "ml");
    System.out.println("Pumpkin spice: " + mlOfPumpkingSpice + "ml");
  }

  public void makePumpkinSpiceLatte() {
    super.makeCoffee();
    System.out.println("Adding " + mlOfMilk + "mls of milk");
    System.out.println("Adding " + mlOfPumpkingSpice + "mls of pumpkin spice");
  }
}
