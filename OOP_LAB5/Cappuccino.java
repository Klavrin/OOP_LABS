public class Cappuccino extends Coffee {
  private int mlOfMilk;

  public Cappuccino(Intensity intensity, int mlOfMilk) {
    super(intensity, "Cappuccino");
    this.mlOfMilk = mlOfMilk;
  }

  public int getMlOfMilk() {
    return mlOfMilk;
  }

  public void setMlOfMilk(int mlOfMilk) {
    this.mlOfMilk = mlOfMilk;
  }

  @Override
  public void printCoffeeDetails() {
    super.printCoffeeDetails();
    System.out.println("Milk: " + mlOfMilk + "ml");
  }

  public void makeCappuccino() {
    super.makeCoffee();
    System.out.println("Adding " + mlOfMilk + "ml of milk");
  }
}
