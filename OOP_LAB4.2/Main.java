import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main extends JFrame implements KeyListener {
    private JList<String> list;
    private static final String[] OPTIONS = {"Faculty operations", "General operations", "Quit"};
    private List<Faculty> faculties = new ArrayList<>();
    private Map<Faculty, List<Student>> graduates = new HashMap<>();

    public Main() {
        setTitle("Menu navigation");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        list = new JList<>(OPTIONS);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addKeyListener(this);
        add(new JScrollPane(list));
        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            int selected = list.getSelectedIndex();
            if (selected == OPTIONS.length - 1) {
                System.exit(0);
            }
            String option = OPTIONS[selected];
            if (option.equals("Faculty operations")) {
                handleFacultyOperations();
            } else if (option.equals("General operations")) {
                handleGeneralOperations();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    private void handleFacultyOperations() {
        if (faculties.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No faculties exist. Please create one in General operations first.");
            return;
        }

        // Select faculty
        String[] facultyNames = faculties.stream().map(Faculty::getName).toArray(String[]::new);
        String chosenFacultyName = (String) JOptionPane.showInputDialog(this, "Select a faculty:", "Faculty Selection",
                JOptionPane.QUESTION_MESSAGE, null, facultyNames, facultyNames[0]);
        if (chosenFacultyName == null) return;

        Faculty selectedFaculty = faculties.stream()
                .filter(f -> f.getName().equals(chosenFacultyName))
                .findFirst().orElse(null);
        if (selectedFaculty == null) return;

        // Select operation
        String[] subOptions = {
                "1. Create and assign a student to a faculty",
                "2. Graduate a student from a faculty",
                "3. Display current enrolled students",
                "4. Display graduates",
                "5. Tell if a student belongs to this faculty",
                "Back"
        };
        String chosenOp = (String) JOptionPane.showInputDialog(this, "Select an operation:", "Faculty Operations",
                JOptionPane.QUESTION_MESSAGE, null, subOptions, subOptions[0]);
        if (chosenOp == null || chosenOp.equals("Back")) return;

        int opNum = Integer.parseInt(chosenOp.substring(0, 1));

        switch (opNum) {
            case 1:
                createAndAssignStudent(selectedFaculty);
                break;
            case 2:
                graduateStudent(selectedFaculty);
                break;
            case 3:
                displayEnrolledStudents(selectedFaculty);
                break;
            case 4:
                displayGraduates(selectedFaculty);
                break;
            case 5:
                checkStudentBelongs(selectedFaculty);
                break;
        }
    }

    private void createAndAssignStudent(Faculty faculty) {
        String firstName = JOptionPane.showInputDialog(this, "Enter first name:");
        if (firstName == null) return;
        String lastName = JOptionPane.showInputDialog(this, "Enter last name:");
        if (lastName == null) return;
        String email = JOptionPane.showInputDialog(this, "Enter email:");
        if (email == null) return;
        LocalDate enrollmentDate = parseDate(JOptionPane.showInputDialog(this, "Enter enrollment date (dd/MM/yyyy):"));
        if (enrollmentDate == null) return;
        LocalDate dateOfBirth = parseDate(JOptionPane.showInputDialog(this, "Enter date of birth (dd/MM/yyyy):"));
        if (dateOfBirth == null) return;

        Student student = new Student(firstName, lastName, email, enrollmentDate, dateOfBirth);
        faculty.getStudents().add(student);
        JOptionPane.showMessageDialog(this, "Student created and assigned to " + faculty.getName());
    }

    private void graduateStudent(Faculty faculty) {
        String email = JOptionPane.showInputDialog(this, "Enter student email to graduate:");
        if (email == null) return;
        Student student = findStudentByEmail(email);
        if (student == null) {
            JOptionPane.showMessageDialog(this, "Student not found.");
            return;
        }
        if (!faculty.getStudents().contains(student)) {
            JOptionPane.showMessageDialog(this, "Student does not belong to this faculty.");
            return;
        }
        faculty.getStudents().remove(student);
        graduates.get(faculty).add(student);
        JOptionPane.showMessageDialog(this, "Student graduated from " + faculty.getName());
    }

    private void displayEnrolledStudents(Faculty faculty) {
        StringBuilder sb = new StringBuilder("Current enrolled students in " + faculty.getName() + ":\n");
        for (Student s : faculty.getStudents()) {
            sb.append(s.getFirstName() + " " + s.getLastName() + " (" + s.getEmail() + ")").append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    private void displayGraduates(Faculty faculty) {
        StringBuilder sb = new StringBuilder("Graduates from " + faculty.getName() + ":\n");
        for (Student s : graduates.getOrDefault(faculty, new ArrayList<>())) {
            sb.append(s.getFirstName() + " " + s.getLastName() + " (" + s.getEmail() + ")").append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    private void checkStudentBelongs(Faculty faculty) {
        String email = JOptionPane.showInputDialog(this, "Enter student email to check:");
        if (email == null) return;
        Student student = findStudentByEmail(email);
        if (student == null) {
            JOptionPane.showMessageDialog(this, "Student not found.");
            return;
        }
        boolean belongs = faculty.getStudents().contains(student);
        JOptionPane.showMessageDialog(this, "The student " + (belongs ? "belongs" : "does not belong") + " to " + faculty.getName());
    }

    private void handleGeneralOperations() {
        String[] subOptions = {
                "1. Create a faculty",
                "2. Display all faculties",
                "3. Display all students (enrolled and graduates)",
                "Back"
        };
        String chosenOp = (String) JOptionPane.showInputDialog(this, "Select an operation:", "General Operations",
                JOptionPane.QUESTION_MESSAGE, null, subOptions, subOptions[0]);
        if (chosenOp == null || chosenOp.equals("Back")) return;

        int opNum = Integer.parseInt(chosenOp.substring(0, 1));

        switch (opNum) {
            case 1:
                createFaculty();
                break;
            case 2:
                displayAllFaculties();
                break;
            case 3:
                displayAllStudents();
                break;
        }
    }

    private void createFaculty() {
        String name = JOptionPane.showInputDialog(this, "Enter faculty name:");
        if (name == null) return;
        String abbreviation = JOptionPane.showInputDialog(this, "Enter abbreviation:");
        if (abbreviation == null) return;
        String[] fieldNames = Arrays.stream(StudyField.values()).map(Enum::name).toArray(String[]::new);
        String selectedField = (String) JOptionPane.showInputDialog(this, "Select study field:", "Study Field Selection",
                JOptionPane.QUESTION_MESSAGE, null, fieldNames, fieldNames[0]);
        if (selectedField == null) return;
        StudyField studyField = StudyField.valueOf(selectedField);
        Faculty faculty = new Faculty(name, abbreviation, new ArrayList<>(), studyField);
        faculties.add(faculty);
        graduates.put(faculty, new ArrayList<>());
        JOptionPane.showMessageDialog(this, "Faculty created.");
    }

    private void displayAllFaculties() {
        StringBuilder sb = new StringBuilder("All faculties:\n");
        for (Faculty f : faculties) {
            sb.append(f.getName() + " (" + f.getAbbreviation() + ") - " + f.getStudyField()).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    private void displayAllStudents() {
        Set<Student> allStudents = new HashSet<>();
        for (Faculty f : faculties) {
            allStudents.addAll(f.getStudents());
            allStudents.addAll(graduates.getOrDefault(f, new ArrayList<>()));
        }
        StringBuilder sb = new StringBuilder("All students:\n");
        for (Student s : allStudents) {
            sb.append(s.getFirstName() + " " + s.getLastName() + " (" + s.getEmail() + ")").append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    private Student findStudentByEmail(String email) {
        for (Faculty f : faculties) {
            for (Student s : f.getStudents()) {
                if (s.getEmail().equals(email)) return s;
            }
            for (Student s : graduates.getOrDefault(f, new ArrayList<>())) {
                if (s.getEmail().equals(email)) return s;
            }
        }
        return null;
    }

    private LocalDate parseDate(String dateStr) {
        if (dateStr == null) return null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Use dd/MM/yyyy.");
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}

enum StudyField {
    MECHANICAL_ENGINEERING,
    SOFTWARE_ENGINEERING,
    FOOD_TECHNOLOGY,
    URBANISM_ARCHITECTURE,
    VETERINARY_MEDICINE
}