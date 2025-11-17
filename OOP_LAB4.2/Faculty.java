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

  public void addStudent(Student student) {
    students.add(student);
  }

  public void removeStudent(Student student) {
    students.remove(student);
  }

  public boolean hasStudent(Student student) {
    return students.contains(student);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Faculty)) return false;
    Faculty f = (Faculty) o;
    return abbreviation.equalsIgnoreCase(f.abbreviation);
  }

  @Override
  public int hashCode() {
    return abbreviation.toLowerCase().hashCode();
  }
}
