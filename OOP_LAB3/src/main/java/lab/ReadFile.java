package lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ReadFile {
  private final String filePath; 

  public ReadFile(String filePath) {
    this.filePath = filePath;
  }

  public String getFilePath() {
    return filePath;
  }

  public String read() {
    StringBuilder content = new StringBuilder();
    
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        content.append(line).append("\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return content.toString();
  }

  public List<Individual> readSeparately() {
    Gson gson = new Gson();
    List<Individual> individuals = new ArrayList<>();

    try (FileReader reader = new FileReader(filePath)) {
        Type individualListType = new TypeToken<List<Individual>>() {}.getType();
        individuals = gson.fromJson(reader, individualListType);
    } catch (IOException e) {
        e.printStackTrace();
    }

    return individuals;
  }

  public void printFile() {
    String fileContent = read();
    System.out.println(fileContent);
  }
}
