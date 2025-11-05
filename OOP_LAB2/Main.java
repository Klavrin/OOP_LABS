
import java.time.Duration;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Participant p1 = new Participant("Sergiu", "Ghearsim", "gherasim@email.com");
    Participant p2 = new Participant("Vasile", "Brinza", "brinza@email.com");
    Jury j = new Jury("John", "Doe", "doe@email.com");

    ArrayList<Participant> members = new ArrayList<>();
    members.add(p1);
    members.add(p2);

    Team team = new Team(
      "Careless Whisperers", 
      "A team of object-oriented-programming enthusiasts.",
      members
    );

    ArrayList<Technology> technologies = new ArrayList<>();
    technologies.add(new Technology(
      "Blazor", 
      "Blazor is a free and open-source web framework developed by Microsoft", 
      2018, 
      "https://dotnet.microsoft.com/en-us/apps/aspnet/web-apps/blazor"
    ));
    technologies.add(new Technology(
      "MongoDB", 
      "MongoDB is an open-source, non-relational (NoSQL) database that stores data in flexible, JSON-like documents instead of traditional tables.", 
      2009, 
      "https://www.mongodb.com/"
    ));

    ArrayList<Jury> juries = new ArrayList<>();
    juries.add(j);

    Hackathon hackathon = new Hackathon(
      "DeepTech GigaHack",
      "Biggest hackathon in Moldova",
      2025, 
      members,
      Duration.ofHours(48),
      juries,
      "Misceleneous"
    );

    Project project = new Project(
      "FarmXpert",
      "Greatest farming app of all time.",
      team,
      hackathon,
      technologies,
      "repo.github.com",
      0
    );

    System.out.println("The participants are: " + p1.getFullName() + " and " + p2.getFullName());
    System.out.println("The jury is: " + j.getFullName());
    System.out.println("The team is: " + team.getName());
    System.out.println("The hackathon is: " + hackathon.getName());
    System.out.println("The project is: " + project.getName());
  }
}
