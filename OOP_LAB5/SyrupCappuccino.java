public class SyrupCappuccino extends Coffee {
  int mlOfMilk;
  SyrupType syrup;

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
}
