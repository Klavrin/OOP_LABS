public class SyrupCappuccino extends Coffee {
  private int mlOfMilk;
  private SyrupType syrup;

  public SyrupCappuccino(Intensity intensity, int mlOfMilk, SyrupType syrup) {
    super(intensity, "Syrup Cappuccino");
    this.mlOfMilk = mlOfMilk;
    this.syrup = syrup;
  }

  public int getMlOfMilk() {
    return mlOfMilk;
  }

  public SyrupType getSyrup() {
    return syrup;
  }

  public void setMlOfMilk(int mlOfMilk) {
    this.mlOfMilk = mlOfMilk;
  }

  public void setSyrup(SyrupType syrup) {
    this.syrup = syrup;
  }

  @Override
  public void printCoffeeDetails() {
    super.printCoffeeDetails();
    System.out.println("Milk: " + mlOfMilk + "ml");
    System.out.println("Syrup type: " + syrup);
  }

  public void makeSyrupCappuccino() {
    super.makeCoffee();
    System.out.println("Adding " + mlOfMilk + "mls of milk");
    System.out.println("Adding  " + syrup + "mls of syrup");
  }
}
