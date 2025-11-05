package lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {
  public static void main(String[] args) {
    Gson gson = new Gson();

    try {
      String json = Files.readString(Paths.get("src/resources/input.json"));
      TypeToken<List<Individual>> listType = new TypeToken<List<Individual>>() {};
      List<Individual> individuals = gson.fromJson(json, listType.getType());

      List<Individual> starWarsSpecies = new ArrayList<>();
      List<Individual> marvelSpecies = new ArrayList<>();
      List<Individual> hitchhikersSpecies = new ArrayList<>();
      List<Individual> lordOfTheRingsSpecies = new ArrayList<>();

      for (Individual ind : individuals) {
        if (ind.getPhysicalTraits() == null)
          continue;

        Species classification = ind.classify();
        if (classification == null)
          continue;

        switch (classification) {
          case WOOKIE:
          case EWOK:
            starWarsSpecies.add(ind);
            break;

          case ASGARDIAN:
            marvelSpecies.add(ind);
            break;

          case BETELGEUSIAN:
          case VOGON:
            hitchhikersSpecies.add(ind);
            break;

          case ELF:
          case DWARF:
            lordOfTheRingsSpecies.add(ind);
            break;
        }
      }

      WriteFile wf = new WriteFile("src/main/java/lab");
      wf.write(starWarsSpecies, "starwars");
      wf.write(marvelSpecies, "marvel");
      wf.write(hitchhikersSpecies, "hitchhiker");
      wf.write(lordOfTheRingsSpecies, "rings");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
