public class Main {
  public static void main(String[] args) {
    var display1 = new Display(1920, 1080, 401, "Phone A");
    var display2 = new Display(2560, 1440, 515, "Phone B");
    var display3 = new Display(1920, 1080, 401, "Phone C");

    Assistant assistant = new Assistant("George");
    assistant.assignDisplay(display1);
    assistant.assignDisplay(display2);
    assistant.assignDisplay(display3);

    assistant.assist();

    Display boughtDisplay = assistant.buyDisplay(display2);
    System.out.println(boughtDisplay.getModel() + "\n");

    // display1.compareWithMonitor(display2);
    // display1.compareWithMonitor(display3);
    // System.out.println();
    // display2.compareWithMonitor(display1);
    // display2.compareWithMonitor(display3);
    // System.out.println();
    // display3.compareWithMonitor(display1);
    // display3.compareWithMonitor(display2);

    if (args.length < 1) {
      System.err.println("Please provide a file path as a command line argument.");
      return;
    }

    String filePath = args[0];

    var fr = new FileReader();
    // System.out.println(fr.readFileIntoString(filePath));

    var td = new TextData("hello.txt", fr.readFileIntoString(filePath));
    System.out.println("File name: " + td.getFilename());
    System.out.println("Number of vowels: " + td.getNumberOfVowels());
    System.out.println("Number of consonants: " + td.getNumberOfConsonants());
    System.out.println("Number of letters: " + td.getNumberOfLetters());
    System.out.println("Number of sentences: " + td.getNumberOfSentences());
  } 
}
