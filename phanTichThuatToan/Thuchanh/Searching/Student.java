import java.io.*;
import java.util.*;

class Subject {
    private final String name;
    private final int credits;
    private final double score;

    public Subject(String name, int credits, double score) {
        this.name = name;
        this.credits = credits;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.format("%s (Credits: %d, Score: %.2f)", name, credits, score);
    }
}

public class Student {
    public static final Comparator<Student> NAME_ORDER = new NameOrder();
    public static final Comparator<Student> SECTION_ORDER = new SectionOrder();
    public static final Comparator<Student> GPA_ORDER = new GpaOrder();
    public static final Comparator<Student> ID_ORDER = new IdOrder();

    private final String id;
    private final String name;
    private final int section;
    private final List<Subject> subjects;

    public Student(String id, String name, int section) {
        this.id = id;
        this.name = name;
        this.section = section;
        this.subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public double calculateAverageGPA() {
        if (subjects.isEmpty()) return 0.0;
        double sum = 0;
        for (Subject s : subjects) {
            sum += s.getScore();
        }
        return sum / subjects.size();
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - Section: %d, GPA: %.2f\nSubjects: %s", 
            name, id, section, calculateAverageGPA(), subjects);
    }

    private static class NameOrder implements Comparator<Student> {
        public int compare(Student a, Student b) {
            return a.name.compareTo(b.name);
        }
    }

    private static class SectionOrder implements Comparator<Student> {
        public int compare(Student a, Student b) {
            return Integer.compare(a.section, b.section);
        }
    }

    private static class GpaOrder implements Comparator<Student> {
        public int compare(Student a, Student b) {
            return Double.compare(b.calculateAverageGPA(), a.calculateAverageGPA());
        }
    }

    private static class IdOrder implements Comparator<Student> {
        public int compare(Student a, Student b) {
            return a.id.compareTo(b.id);
        }
    }

    public static void main(String[] args) {
        String studentFile = "sv.txt";
        String subjectFile = "Subjects.txt";
        String outputFile = "svOut.txt";

        TreeMap<String, Student> studentMap = new TreeMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(studentFile));
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3) {
                    String id = fields[0].trim();
                    String name = fields[1].trim();
                    int section = Integer.parseInt(fields[2].trim());
                    studentMap.put(id, new Student(id, name, section));
                }
            }
            br.close();

            br = new BufferedReader(new FileReader(subjectFile));
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 4) {
                    String studentId = fields[0].trim();
                    String subjectName = fields[1].trim();
                    int credits = Integer.parseInt(fields[2].trim());
                    double score = Double.parseDouble(fields[3].trim());
                    if (studentMap.containsKey(studentId)) {
                        studentMap.get(studentId).addSubject(new Subject(subjectName, credits, score));
                    }
                }
            }
            br.close();

            List<Student> sortedStudents = new ArrayList<>(studentMap.values());
            sortedStudents.sort(GPA_ORDER);

            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
            for (Student s : sortedStudents) {
                bw.write(s.toString());
                bw.newLine();
            }
            bw.close();
            System.out.println("Xuất danh sách sinh viên ra file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }
}
