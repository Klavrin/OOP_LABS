public class Cappuccino extends Coffee {
  int mlOfMilk;

  public Cappuccino(Intensity intensity, int mlOfMilk) {
    super(intensity, "Cappuccino");
    this.mlOfMilk = mlOfMilk;
  }

  public int getMlOfMilk() {
    return mlOfMilk;
  }
}
