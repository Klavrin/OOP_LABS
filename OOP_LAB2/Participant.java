public class Participant {
  private final String firstName;
  private final String lastName;
  private final String email;
  private Team team;
  // private Project project;

  public Participant(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    // this.team = team;
    // this.project = project;
  }

  public String getFullName() {
    return firstName + " " + lastName;
  }

  public String getEmail() {
    return email;
  }

  public Team getTeam() {
    return team;
  }

  // public getProject() {
  //   return project;
  // }

  public void setTeam(Team newTeam) {
    team = newTeam;
  }
}