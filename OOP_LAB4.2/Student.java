import java.time.LocalDate;
import java.io.Serializable;

public class Student implements Serializable {
  private static final long serialVersionUID = 1L;
  private final String firstName;
  private final String lastName;
  private final String email;
  private final LocalDate enrollmentDate;
  private final LocalDate dateOfBirth;

  public Student(
    String firstName,
    String lastName,
    String email,
    LocalDate enrollmentDate,
    LocalDate dateOfBirth
  ) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.enrollmentDate = enrollmentDate;
    this.dateOfBirth = dateOfBirth;
  }

  public String getFirstName() { return firstName; }
  public String getLastName() { return lastName; }
  public String getEmail() { return email; }
  public LocalDate getEnrollmentDate() { return enrollmentDate; }
  public LocalDate getDateOfBirth() { return dateOfBirth; }
}
