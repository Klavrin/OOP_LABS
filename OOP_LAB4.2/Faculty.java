import java.util.List;
import java.io.Serializable;

public class Faculty implements Serializable {
  private static final long serialVersionUID = 1L;
  private final String name;
  private final String abbreviation;
  private final List<Student> students;
  private final StudyField studyField;

  public Faculty(
    String name,
    String abbreviation,
    List<Student> students,
    StudyField studyField
  ) {
    this.name = name;
    this.abbreviation = abbreviation;
    this.students = students;
    this.studyField = studyField;
  }

  public String getName() { return name; }
  public String getAbbreviation() { return abbreviation; }
  public List<Student> getStudents() { return students; }
  public StudyField getStudyField() { return studyField; }
}
