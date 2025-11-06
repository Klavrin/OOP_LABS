public class TextData {
  private String fileName;
  private String text;
  private int numberOfVowels;
  private int numberOfConsonants;
  private int numberOfLetters;
  private int numberOfSentences;
  private String longestWord;

  public TextData(String fileName, String text) {
    this.fileName = fileName;
    this.text = text;
    analyzeText();
  }

  public String getFilename() { return fileName; }
  public String getText() { return text; }
  public int getNumberOfVowels() { return numberOfVowels; }
  public int getNumberOfConsonants() { return numberOfConsonants; }
  public int getNumberOfLetters() { return numberOfLetters; }
  public int getNumberOfSentences() { return numberOfSentences; }
  public String getLongestWord() { return longestWord; }

  private void analyzeText() {
    int vowels = 0;
    int consonants = 0;
    int letters = 0;
    int sentences = 0;
    String longest = "";

    String[] words = text.split("\\s+");
    for (String word : words) {
        if (word.length() > longest.length()) {
            longest = word;
        }
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                letters++;
                char lower = Character.toLowerCase(c);
                if ("aeiou".indexOf(lower) >= 0) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
    }

    // count sentences
    sentences = text.split("[.!?]+").length;

    this.numberOfVowels = vowels;
    this.numberOfConsonants = consonants;
    this.numberOfLetters = letters;
    this.numberOfSentences = sentences;
    this.longestWord = longest;
  }
}
