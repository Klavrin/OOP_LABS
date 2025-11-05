
import java.util.ArrayList;

public class Team {
  private final String name;
  private final String description;
  private final ArrayList<Participant> members;

  public Team(String name, String description, ArrayList<Participant> members) {
    this.name = name;
    this.description = description;
    this.members = members;
  }
  
  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public ArrayList<Participant> getMembers() {
    return members;
  }
}