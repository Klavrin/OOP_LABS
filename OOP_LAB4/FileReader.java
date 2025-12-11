import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class FileReader {
  public String readFileIntoString(String path) {
    try {
      return new String(Files.readAllBytes(Paths.get(path)));
    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
      return null;
    }
  }
}
