class ElectricStation implements Refuelable {
  private int carsServed = 0;

  @Override
  public void refuel(String carId) {
    System.out.println("Electric car " + carId + " charged.");
    carsServed++;
  }

  public int getCarsServed() {
    return carsServed;
  }
}