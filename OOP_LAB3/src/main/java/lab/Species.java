package lab;

import java.util.Set;
import java.util.function.Predicate;
import java.util.Arrays;

public enum Species {
  WOOKIE(false, "KASHYYYK", age -> age >= 0 && age <= 400, Set.of("HAIRY", "TALL")),
  EWOK(false, "ENDOR", age -> age >= 0 && age <= 60, Set.of("SHORT", "HAIRY")),
  ASGARDIAN(true, "ASGARD", age -> age >= 0 && age <= 5000, Set.of("BLONDE", "TALL")),
  BETELGEUSIAN(true, "BETELGEUSE", age -> age >= 0 && age <= 100, Set.of("EXTRA_ARMS", "EXTRA_HEAD")),
  VOGON(false, "VOGSPHERE", age -> age >= 0 && age <= 200, Set.of("GREEN", "BULKY")),
  ELF(true, "EARTH", age -> age >= 0 && age <= 10000, Set.of("BLONDE", "POINTY_EARS")),
  DWARF(true, "EARTH", age -> age >= 0 && age <= 200, Set.of("SHORT", "BULKY"));

  private final boolean isHumanoid;
  private final String originPlanet;
  private final Predicate<Integer> age;
  private final Set<String> physicalTraits;

  private Species(boolean isHumanoid, String originPlanet, Predicate<Integer> age, Set<String> physicalTraits) {
    this.isHumanoid = isHumanoid;
    this.originPlanet = originPlanet;
    this.age = age;
    this.physicalTraits = physicalTraits;
  }

  public boolean matches(Individual ind) {
    if (ind == null)
      return false;

    return ind.getIsHumanoid() == isHumanoid 
      && originPlanet.equals(ind.getOriginPlanet()) 
      && age.test(ind.getAge())
      && physicalTraits.stream()
          .anyMatch(req -> Arrays.stream(ind.getPhysicalTraits()).anyMatch(t -> t.equals(req)));
  }
}
