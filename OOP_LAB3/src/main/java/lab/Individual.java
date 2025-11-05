package lab;

import java.util.Arrays;

public class Individual {
  private final int id;
  private final Boolean isHumanoid;
  private final String originPlanet;
  private final Integer age;
  private final String[] physicalTraits;

  public Individual(int id, boolean isHumanoid, String originPlanet, int age, String[] physicalTraits) {
    this.id = id;
    this.isHumanoid = isHumanoid;
    this.originPlanet = originPlanet;
    this.age = age;
    this.physicalTraits = physicalTraits;
  }

  public int getId() {
    return id;
  }

  public Boolean getIsHumanoid() {
    return isHumanoid;
  }

  public String getOriginPlanet() {
    return originPlanet;
  }

  public Integer getAge() {
    return age;
  }

  public String[] getPhysicalTraits() {
    return physicalTraits;
  }

  public Species classify() {
    return Arrays.stream(Species.values())
      .filter(s -> s.matches(this))
      .findFirst()
      .orElse(null);
  }

  @Override
  public String toString() {
    return "{\n Id: " + id + ",\n isHumanoid: " + isHumanoid + ",\n Planet of origin: " + originPlanet + ",\n Age: "
        + age + "\n Physical traits: " + Arrays.toString(physicalTraits) + "\n},";
  }
}
