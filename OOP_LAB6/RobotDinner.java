public class RobotDinner implements Dineable {
  private int robotsServed = 0;

  @Override
  public void serveDinner(String carId) {
    System.out.println("Refueling gas car " + carId + ".");
    robotsServed++;
  }
  
  public int getPeopleServed() {
    return robotsServed;
  }

  public void resetCount() {
    robotsServed = 0;
  }
}
