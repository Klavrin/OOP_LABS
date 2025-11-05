public class Technology {
  private final String name;
  private final String description;
  private final int releaseYear;
  private String website;

  public Technology(
    String name,
    String description,
    int releaseYear,
    String website
  ) {
    this.name = name;
    this.description = description;
    this.releaseYear = releaseYear;  
    this.website = website;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String newWebsite) {
    website = newWebsite;
  }
}
