import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
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
        List<Faculty> loadedFacs = FileManager.loadFaculties();
        Map<Faculty, List<Student>> loadedGrads = FileManager.loadGraduates();

        if (loadedFacs != null) faculties = loadedFacs;
        if (loadedGrads != null) graduates = loadedGrads;

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
            if (selected == OPTIONS.length - 1) System.exit(0);

            switch (OPTIONS[selected]) {
                case "Faculty operations":
                    handleFacultyOperations();
                    break;
                case "General operations":
                    handleGeneralOperations();
                    break;
            }
        }
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}

    // faculty operations
    private void handleFacultyOperations() {
        if (faculties.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No faculties exist. Create one first.");
            return;
        }

        // select faculty
        String[] facultyNames = faculties.stream().map(Faculty::getName).toArray(String[]::new);
        String chosenName = (String) JOptionPane.showInputDialog(this, "Select a faculty:",
            "Faculty Selection", JOptionPane.QUESTION_MESSAGE, null,
            facultyNames, facultyNames[0]);

        if (chosenName == null) return;
        Faculty selectedFaculty = faculties.stream()
            .filter(f -> f.getName().equals(chosenName))
            .findFirst().orElse(null);

        if (selectedFaculty == null) return;

        // select operation
        String[] ops = {
            "1. Create and assign a student to this faculty",
            "2. Graduate a student",
            "3. Display enrolled students",
            "4. Display graduates",
            "5. Check if a student belongs to this faculty",
            "6. Batch enroll students (from file)",
            "7. Batch graduate students (from file)",
            "Back"
        };

        String chosenOp = (String) JOptionPane.showInputDialog(this, "Select an operation:",
                "Faculty Operations", JOptionPane.QUESTION_MESSAGE, null, ops, ops[0]);
        if (chosenOp == null || chosenOp.equals("Back")) return;

        int n = Integer.parseInt(chosenOp.substring(0, 1));
        switch (n) {
            case 1 -> createAndAssignStudent(selectedFaculty);
            case 2 -> graduateStudent(selectedFaculty);
            case 3 -> displayEnrolledStudents(selectedFaculty);
            case 4 -> displayGraduates(selectedFaculty);
            case 5 -> checkStudentBelongs(selectedFaculty);
            case 6 -> batchEnrollStudents();
            case 7 -> batchGraduateStudents();
        }
    }

    private void createAndAssignStudent(Faculty faculty) {
        String firstName = JOptionPane.showInputDialog(this, "Enter first name:");
        if (firstName == null) return;
        String lastName = JOptionPane.showInputDialog(this, "Enter last name:");
        if (lastName == null) return;
        String email = JOptionPane.showInputDialog(this, "Enter email:");
        if (email == null) return;
        LocalDate enrollmentDate = parseDate(JOptionPane.showInputDialog(
                this, "Enter enrollment date (dd/MM/yyyy):"));
        if (enrollmentDate == null) return;
        LocalDate dateOfBirth = parseDate(JOptionPane.showInputDialog(
                this, "Enter date of birth (dd/MM/yyyy):"));
        if (dateOfBirth == null) return;

        Student s = new Student(firstName, lastName, email, enrollmentDate, dateOfBirth);
        faculty.addStudent(s);
        JOptionPane.showMessageDialog(this, "Student assigned to " + faculty.getName());
        FileManager.saveFaculties(faculties);
    }

    private void graduateStudent(Faculty faculty) {
        String email = JOptionPane.showInputDialog(this, "Enter student email:");
        if (email == null) return;

        Student student = findStudentByEmail(email);
        if (student == null) {
            JOptionPane.showMessageDialog(this, "Student not found.");
            return;
        }

        if (!faculty.hasStudent(student)) {
            JOptionPane.showMessageDialog(this, "Student is not enrolled in this faculty.");
            return;
        }

        faculty.removeStudent(student);
        graduates.get(faculty).add(student);

        JOptionPane.showMessageDialog(this, "Student graduated from " + faculty.getName());
        FileManager.saveFaculties(faculties);
        FileManager.saveGraduates(graduates);
    }

    private void displayEnrolledStudents(Faculty faculty) {
        StringBuilder sb = new StringBuilder("Enrolled students in " + faculty.getName() + ":\n");

        if (faculty.getStudents().isEmpty()) {
            sb.append("No enrolled students.\n");
        } else {
            for (Student s : faculty.getStudents()) {
                sb.append(s.getFirstName()).append(" ")
                    .append(s.getLastName()).append(" (")
                    .append(s.getEmail()).append(")\n");
            }
        }

        JOptionPane.showMessageDialog(this, sb.toString());
    }

    private void displayGraduates(Faculty faculty) {
        List<Student> grads = graduates.getOrDefault(faculty, new ArrayList<>());
        StringBuilder sb = new StringBuilder("Graduates from " + faculty.getName() + ":\n");

        if (grads.isEmpty()) {
            sb.append("No graduates.\n");
        } else {
            for (Student s : grads) {
                sb.append(s.getFirstName()).append(" ")
                    .append(s.getLastName()).append(" (")
                    .append(s.getEmail()).append(")\n");
            }
        }

        JOptionPane.showMessageDialog(this, sb.toString());
    }

    private void checkStudentBelongs(Faculty faculty) {
        String email = JOptionPane.showInputDialog(this, "Enter student email:");
        if (email == null)
            return;

        Student s = findStudentByEmail(email);
        if (s == null) {
            JOptionPane.showMessageDialog(this, "Student not found.");
            return;
        }

        boolean belongs = faculty.hasStudent(s);
        JOptionPane.showMessageDialog(this,
                "The student " + (belongs ? "belongs" : "does NOT belong") +
                        " to " + faculty.getName());
    }
    
    private void batchEnrollStudents() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select enrollment file");

        if (chooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION)
            return;

        File file = chooser.getSelectedFile();
        List<String> errors = new ArrayList<>();
        int successCount = 0;

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length != 6) {
                    errors.add("Invalid line format: " + line);
                    continue;
                }

                String fn = parts[0].trim();
                String ln = parts[1].trim();
                String email = parts[2].trim();
                LocalDate enrollment = parseDate(parts[3].trim());
                LocalDate dob = parseDate(parts[4].trim());
                String facAbbr = parts[5].trim();

                if (enrollment == null || dob == null) {
                    errors.add("Invalid dates for: " + email);
                    continue;
                }

                Faculty fac = faculties.stream()
                        .filter(f -> f.getAbbreviation().equalsIgnoreCase(facAbbr))
                        .findFirst()
                        .orElse(null);

                if (fac == null) {
                    errors.add("Faculty not found: " + facAbbr + " (for " + email + ")");
                    continue;
                }

                if (findStudentByEmail(email) != null) {
                    errors.add("Student with email already exists: " + email);
                    continue;
                }

                Student s = new Student(fn, ln, email, enrollment, dob);
                fac.addStudent(s);
                successCount++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage());
            return;
        }

        FileManager.saveFaculties(faculties);

        StringBuilder sb = new StringBuilder("Batch enrollment completed.\n");
        sb.append("Successfully enrolled: ").append(successCount).append("\n");
        if (!errors.isEmpty()) {
            sb.append("\nErrors:\n");
            errors.forEach(err -> sb.append("• ").append(err).append("\n"));
        }

        JOptionPane.showMessageDialog(this, sb.toString());
    }

    private void batchGraduateStudents() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select graduation file");
    
        if (chooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION)
            return;
    
        File file = chooser.getSelectedFile();
        List<String> errors = new ArrayList<>();
        int successCount = 0;
    
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String email = sc.nextLine().trim();
                if (email.isEmpty()) continue;
    
                Student s = findStudentByEmail(email);
                if (s == null) {
                    errors.add("Cannot graduate: " + email + " (student not present)");
                    continue;
                }
    
                Faculty fac = faculties.stream()
                        .filter(f -> f.hasStudent(s))
                        .findFirst()
                        .orElse(null);
    
                if (fac == null) {
                    errors.add("Cannot graduate: " + email + " (student not enrolled anywhere)");
                    continue;
                }
    
                fac.removeStudent(s);
                graduates.get(fac).add(s);
                successCount++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage());
            return;
        }
    
        FileManager.saveFaculties(faculties);
        FileManager.saveGraduates(graduates);
    
        StringBuilder sb = new StringBuilder("Batch graduation completed.\n");
        sb.append("Successfully graduated: ").append(successCount).append("\n");
        if (!errors.isEmpty()) {
            sb.append("\nErrors:\n");
            errors.forEach(err -> sb.append("• ").append(err).append("\n"));
        }
    
        JOptionPane.showMessageDialog(this, sb.toString());
    }


    // general operations
    private void handleGeneralOperations() {
        String[] ops = {
            "1. Create a faculty",
            "2. Display all faculties",
            "3. Display all students (enrolled + graduates)",
            "Back"
        };

        String chosen = (String) JOptionPane.showInputDialog(this, "Select an operation:",
            "General Operations", JOptionPane.QUESTION_MESSAGE, null,
            ops, ops[0]);

        if (chosen == null || chosen.equals("Back")) return;
        int n = Integer.parseInt(chosen.substring(0, 1));

        switch (n) {
            case 1 -> createFaculty();
            case 2 -> displayAllFaculties();
            case 3 -> displayAllStudents();
        }
    }

    private void createFaculty() {
        String name = JOptionPane.showInputDialog(this, "Enter faculty name:");
        if (name == null) return;
        String abbreviation = JOptionPane.showInputDialog(this, "Enter abbreviation:");
        if (abbreviation == null) return;
        String[] fields = Arrays.stream(StudyField.values())
                .map(Enum::name).toArray(String[]::new);
        String selected = (String) JOptionPane.showInputDialog(this, "Select study field:",
                "Study Field Selection", JOptionPane.QUESTION_MESSAGE,
                null, fields, fields[0]);

        if (selected == null) return;

        StudyField field = StudyField.valueOf(selected);
        Faculty faculty = new Faculty(name, abbreviation, new ArrayList<>(), field);
        faculties.add(faculty);
        graduates.put(faculty, new ArrayList<>());

        JOptionPane.showMessageDialog(this, "Faculty created.");

        FileManager.saveFaculties(faculties);
        FileManager.saveGraduates(graduates);
    }

    private void displayAllFaculties() {
        StringBuilder sb = new StringBuilder("All faculties:\n");

        for (Faculty f : faculties) {
            sb.append(f.getName()).append(" (")
                .append(f.getAbbreviation()).append(") - ")
                .append(f.getStudyField()).append("\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString());
    }

    private void displayAllStudents() {
        Set<Student> all = new HashSet<>();

        for (Faculty f : faculties) {
            all.addAll(f.getStudents());
            all.addAll(graduates.getOrDefault(f, new ArrayList<>()));
        }

        StringBuilder sb = new StringBuilder("All students:\n");

        for (Student s : all) {
            sb.append(s.getFirstName()).append(" ")
                .append(s.getLastName()).append(" (")
                .append(s.getEmail()).append(")\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString());
    }

    // utility methods
    private Student findStudentByEmail(String email) {
        for (Faculty f : faculties) {
            for (Student s : f.getStudents()) {
                if (s.getEmail().equalsIgnoreCase(email)) return s;
            }
            for (Student s : graduates.getOrDefault(f, new ArrayList<>())) {
                if (s.getEmail().equalsIgnoreCase(email)) return s;
            }
        }
        return null;
    }

    private LocalDate parseDate(String str) {
        if (str == null) return null;
        try {
            return LocalDate.parse(str, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Invalid date. Use dd/MM/yyyy.");
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
