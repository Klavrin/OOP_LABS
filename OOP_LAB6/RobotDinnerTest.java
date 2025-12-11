public class RobotDinnerTest {
  public static void main(String[] args) {

    testServeDinnerIncrementsCount();
    testResetCount();

    System.out.println("All RobotDinner tests passed!");
  }

  private static void testServeDinnerIncrementsCount() {
    RobotDinner rd = new RobotDinner();
    
    rd.serveDinner("R1");
    rd.serveDinner("R2");
    rd.serveDinner("R3");

    assert rd.getPeopleServed() == 3 : "Expected 3 robots served";
  }

  private static void testResetCount() {
    RobotDinner rd = new RobotDinner();
    
    rd.serveDinner("R999");
    rd.resetCount();

    assert rd.getPeopleServed() == 0 : "Expected reset to 0";
  }
}
