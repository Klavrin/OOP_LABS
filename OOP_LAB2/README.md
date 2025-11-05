### The old schema

The following is the old schema from laboratory 1:
![](/docs/old-schema.png)

We can notice that it has a few mistakes, such as having a `Person` class that serves as both the hackathon participant and jury.

### The new schema

The following is the new schema:

![](/docs/new-schema.png)

## What has been changed?

1. Instead of using a Person class for both the participant and the jury, I added two distinct classes: Participant and Jury, respectively.
2. Instead of using an array of strings for the `technologies` attribute in the `Project` class, I added a `Technology` class, the addition of which, I believe, makes the schema much more readable.
3. The `Project` class now has an attribute and method for `score`. Moreover, more getters and setters have been added for each attribute as the old schema had very few.

## AI feedback

I gave AI the following prompt: _Give me feedback on how I designed my schema. What are some of the good things about the implementation, how about the bad things?_

Here is what AI had to say:

- The good things
  - Clear Domain Modeling
  - Appropriate Use of Java Types
  - Encapsulation
  - Consistent API Design
- Areas of improvement
  - Relationship Management Issues
    **Problem**: Bidirectional relationships aren't properly maintained
    ```java
    // In Participant.java - line 32-35
    public Team setTeam(Team newTeam) {
      team = newTeam;
      return team; // This should be void
    }
    ```
  - Exposed Mutable Collections
  ```java
  // In Hackathon.java - line 43-44
  public ArrayList<Participant> getParticipants() {
      return participants; // Returns direct reference!
  }
  ```
  - Constructor Parameter Issues
  ```java
  // In Project.java - line 19
  String repositoryUrml, // Typo in parameter name
  ```
  - Inconsistent Mutability
  ```java
  // Some fields are final, others aren't - inconsistent pattern
  private final String name;     // Good
  private int year;              // Why not final?
  private final ArrayList<Participant> participants; // Collection is final, but contents mutable
  ```

## Adopting AI's suggestions?

1. Fixed the relationship management issue in the `Participants` class

```java
public void setTeam(Team newTeam) {
  team = newTeam;
}
```

2. Fixed the exposure of mutable collections by returning their copies

```java
public ArrayList<Participant> getParticipants() {
  return new ArrayList<>(participants);
}
```

3. Fixed inconsistent mutability

```java
private final String name;
private final String description;
private int year;
private ArrayList<Participant> participants;
private Duration duration;
private final ArrayList<Jury> juries;
private String theme;
```

## Feedback from a classmate

1. Instead of using methods `Add` and `Remove` for participants, or any other ArrayList, I would add a general `Modify` method that performs addition, removal and modification.
2. I liked that the schema is very detailed, but at the same time realy easy to read.
