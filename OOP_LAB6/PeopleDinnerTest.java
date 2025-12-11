public class PeopleDinnerTest {
  public static void main(String[] args) {
    testServeDinnerIncrementsCount();
    testResetCount();

    System.out.println("All PeopleDinner tests passed!");
  }

  private static void testServeDinnerIncrementsCount() {
    PeopleDinner pd = new PeopleDinner();
    
    pd.serveDinner("CAR1");
    pd.serveDinner("CAR2");

    assert pd.getPeopleServed() == 2 : "Expected 2 people served";
  }

  private static void testResetCount() {
    PeopleDinner pd = new PeopleDinner();
    
    pd.serveDinner("X");
    pd.resetCount();

    assert pd.getPeopleServed() == 0 : "Expected count to reset to 0";
  }
}
