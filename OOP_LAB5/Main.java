import java.util.List;
import java.util.ArrayList;

public class Main {
  static public void main(String[] args) {
    List<Coffee> listOfCoffees = new ArrayList<>();
    listOfCoffees.add(new Americano(null, 0));
    listOfCoffees.add(new Cappuccino(null, 0));
    listOfCoffees.add(new PumpkinSpiceLatte(null, 0, 0));
    listOfCoffees.add(new SyrupCappuccino(null, 0, null));

    var barista = new Barista("John", listOfCoffees);
    barista.prepareCoffee();
  }
}
