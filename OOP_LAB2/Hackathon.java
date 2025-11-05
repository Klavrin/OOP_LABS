import java.time.Duration;
import java.util.ArrayList;

public class Hackathon {
  private final String name;
  private final String description;
  private int year;
  private ArrayList<Participant> participants;
  private Duration duration;
  private final ArrayList<Jury> juries;
  private String theme;

  public Hackathon(
    String name,
    String description,
    int year,
    ArrayList<Participant> participants,
    Duration duration,
    ArrayList<Jury> juries,
    String theme
  ) {
    this.name = name;
    this.description = description;
    this.year = year;
    this.participants = participants;
    this.duration = duration;
    this.juries = juries;
    this.theme = theme;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public int getYear() {
    return year;
  }

  public ArrayList<Participant> getParticipants() {
    return new ArrayList<>(participants);
  }

  public Duration getDuration() {
    return duration;
  }

  public ArrayList<Jury> getJuries() {
    return juries;
  }

  public String getTheme() {
    return theme;
  }

  public void setYear(int newYear) {
    year = newYear;
  }

  public void addParticipant(Participant newParticipant) {
    participants.add(newParticipant);
  }

  public void removeParticipant(Participant participant) {
    participants.remove(participant);
  }

  public void setDuration(Duration newDuration) {
    duration = newDuration;
  }

  public void addJuries(Jury jury) {
    juries.add(jury);
  }
  
  public void removeJuries(Jury jury) {
    juries.remove(jury);
  }

  public void setTheme(String newTheme) {
    theme = newTheme;
  }
}
