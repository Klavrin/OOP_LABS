import java.util.List;
import java.util.Scanner;

public class Barista extends Person {
  List<Coffee> listOfCoffees;
  
  public Barista(String name, List<Coffee> listOCoffees) {
    super(name);
    this.listOfCoffees = listOCoffees;
  }

  public void prepareCoffee() {
    for (Coffee coffee : listOfCoffees) {
      Scanner myObj = new Scanner(System.in);

      if (coffee instanceof Americano americano) {
        System.out.println("How much water do you want in your Americano?");
        int ml = myObj.nextInt();

        System.out.println("How intense do you want your Americano to be? (0. LIGHT, 1. MEDIUM, 2. STRONG)");
        Intensity intensity = Intensity.values()[myObj.nextInt()];

        americano.setIntensity(intensity);
        americano.setMlOfWater(ml);
        americano.makeAmericano();
      } else if (coffee instanceof Cappuccino cappuccino) {
        System.out.println("How much milk do you want in your Americano?");
        int ml = myObj.nextInt();

        System.out.println("How intense do you want your Cappuccino to be? (0. LIGHT, 1. MEDIUM, 2. STRONG)");
        Intensity intensity = Intensity.values()[myObj.nextInt()];

        cappuccino.setIntensity(intensity);
        cappuccino.setMlOfMilk(ml);
        cappuccino.makeCappuccino();
      } else if (coffee instanceof PumpkinSpiceLatte pumpkinSpiceLatte) {
        System.out.println("How much milk do you want in your Pumpkin Spice Latte?");
        int ml = myObj.nextInt();
        System.out.println("How much pupkin spice do you want in your Pumpkin Spice Latte?");
        int grams = myObj.nextInt();
        System.out.println("How intense do you want your Pumpkin Spice Latte to be? (0. LIGHT, 1. MEDIUM, 2. STRONG)");
        Intensity intensity = Intensity.values()[myObj.nextInt()];

        pumpkinSpiceLatte.setIntensity(intensity);
        pumpkinSpiceLatte.setMlOfMilk(ml);
        pumpkinSpiceLatte.setMlOfPumpkingSpice(grams);
        pumpkinSpiceLatte.makePumpkinSpiceLatte();
      } else if (coffee instanceof SyrupCappuccino syrupCappuccino) {
        System.out.println("How much milk do you want in your Syrup Cappuccino?");
        int ml = myObj.nextInt();

        System.out.println("Select syrup type:");
        for (SyrupType type : SyrupType.values()) {
            System.out.println(type.ordinal() + " - " + type.name());
        }

        int choice = myObj.nextInt();
        SyrupType syrup = SyrupType.values()[choice];

        System.out.println("How intense do you want your Syrup Cappuccino to be? (0. LIGHT, 1. MEDIUM, 2. STRONG)");
        Intensity intensity = Intensity.values()[myObj.nextInt()];

        syrupCappuccino.setIntensity(intensity);
        syrupCappuccino.setMlOfMilk(ml);
        syrupCappuccino.setSyrup(syrup);
        syrupCappuccino.makeSyrupCappuccino();
      }
      System.out.println();
    }
  }
}