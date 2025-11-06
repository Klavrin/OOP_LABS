public class Main {
  public static void main(String[] args) {
    var display1 = new Display(1920, 1080, 401, "Phone A");
    var display2 = new Display(2560, 1440, 515, "Phone B");
    var display3 = new Display(1920, 1080, 401, "Phone C");


    display1.compareWithMonitor(display2);
    display1.compareWithMonitor(display3);
    System.out.println();
    display2.compareWithMonitor(display1);
    display2.compareWithMonitor(display3);
    System.out.println();
    display3.compareWithMonitor(display1);
    display3.compareWithMonitor(display2);
  } 
}
