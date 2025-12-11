class GasStation implements Refuelable {
  private int carsServed = 0;

  @Override
  public void refuel(String carId) {
    System.out.println("Gas car " + carId + " refueled.");
    carsServed++;
  }

  public int getCarsServed() {
    return carsServed;
  }
}