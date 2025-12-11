import java.util.List;
import java.util.ArrayList;

public class Assistant {
  private String assistantName;
  private List<Display> assignedDisplays;

  public Assistant(String assistantName) {
    this.assistantName = assistantName;
    this.assignedDisplays = new ArrayList<>();
  }

  public String getAssistantName() { return assistantName; }
  public List<Display> getAssignedDisplays() { return assignedDisplays; }

  public void assignDisplay(Display d) {
    assignedDisplays.add(d);
  }

  public void assist() {
    if (assignedDisplays.size() < 2) {
      System.out.println("Not enough displays to compare.");
      return;
    }

    System.out.println("Assistant " + assistantName + " is assisting with display comparison:");

    for (int i = 0; i < assignedDisplays.size() - 1; i++) {
      Display current = assignedDisplays.get(i);
      Display next = assignedDisplays.get(i + 1);

      System.out.println("Comparing " + current.getModel() + " with " + next.getModel() + ":");
      current.compareWithMonitor(next);
      System.out.println();
    }
  }
  
  public Display buyDisplay(Display d) {
    if (assignedDisplays.remove(d)) {
        System.out.println(assistantName + " bought " + d.getModel());
        return d;
    } else {
        System.out.println(d.getModel() + " is not assigned to " + assistantName);
        return null;
    }
  }
}
