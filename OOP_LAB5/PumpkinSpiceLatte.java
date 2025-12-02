public class PumpkinSpiceLatte extends Coffee {
  int mlOfMilk;

  public PumpkinSpiceLatte(Intensity intensity, int mlOfMilk) {
    super(intensity, "Pumpkin Spice Latte");
    this.mlOfMilk = mlOfMilk;
  }

  public int getMlOfMilk() {
    return mlOfMilk;
  }
}
