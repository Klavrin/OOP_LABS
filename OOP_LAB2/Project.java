
import java.util.ArrayList;

public class Project {
  private final String name;
  private final String description;
  private final Team team;
  private final Hackathon hackathon;
  private final ArrayList<Technology> technologies;
  private String repositoryUrl;
  private int score;

  public Project(
    String name,
    String description,
    Team team,
    Hackathon hackathon,
    ArrayList<Technology> technologies,
    String repositoryUrml,
    int score
  ) {
    this.name = name;
    this.description = description;
    this.team = team;
    this.hackathon = hackathon;
    this.technologies = technologies;
    this.repositoryUrl = repositoryUrml;
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Team getTeam() {
    return team;
  }

  public Hackathon getHackathon() {
    return hackathon;
  }

  public ArrayList<Technology> getTechnologies() {
    return technologies;
  }

  public String getRepositoryUrl() {
    return repositoryUrl;
  }

  public int getScore() {
    return score;
  }

  public void addTechnology(Technology technology) {
    technologies.add(technology);
  }

  public void removeTechnology(Technology technology) {
    technologies.remove(technology);
  }

  public void setRepositoryUrl(String newRepositoryUrl) {
    repositoryUrl = newRepositoryUrl;
  }

  public void setScore(int newScore) {
    score = newScore;
  }
}
