public class PeopleDinner implements Dineable {
  private int peopleServed = 0;

  @Override
  public void serveDinner(String carId) {
    System.out.println("Refueling gas car " + carId + ".");
    peopleServed++;
  }
  
  public int getPeopleServed() {
    return peopleServed;
  }

  public void resetCount() {
    peopleServed = 0;
  }
}
