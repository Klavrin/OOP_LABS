import java.io.*;
import java.util.List;
import java.util.Map;

public class FileManager {
    private static final String FACULTIES_FILE = "faculties.dat";
    private static final String GRADUATES_FILE = "graduates.dat";

    public static void saveFaculties(List<Faculty> faculties) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FACULTIES_FILE))) {
            oos.writeObject(faculties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Faculty> loadFaculties() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FACULTIES_FILE))) {
            return (List<Faculty>) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }

    public static void saveGraduates(Map<Faculty, List<Student>> graduates) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(GRADUATES_FILE))) {
            oos.writeObject(graduates);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Faculty, List<Student>> loadGraduates() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(GRADUATES_FILE))) {
            return (Map<Faculty, List<Student>>) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }
}
