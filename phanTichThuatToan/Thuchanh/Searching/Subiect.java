import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.io.*;
import java.util.*;

public class Subiect {
    private String name;
    private int numOfCredit;
    private int semester;
    private float score;

        public Subiect(String name, int numOfCredit, int semester, float score) {
            this.name = name;
            this.numOfCredit = numOfCredit;
            this.semester = semester;
            this.score = score;
        }
    
        public int getSemester() {
            return semester;
        }
    
        public float getScore() {
            return score;
        }
    
        @Override
        public String toString() {
            return String.format("%s (Credits: %d, Semester: %d, Score: %.2f)", name, numOfCredit, semester, score);
        }

    public class SubjectManager {
        private ArrayList<Subiect> subjects;
    
        public SubjectManager() {
            subjects = new ArrayList<>();
        }
    
        public void addSubject(Subiect subject) {
            subjects.add(subject);
        }
    
        public float calculateAverage(int semester) {
            int count = 0;
            float sum = 0;
    
            for (Subiect s : subjects) {
                if (s.getSemester() == semester) {
                    sum += s.getScore();
                    count++;
                }
            }
    
            return (count == 0) ? 0 : sum / count;
        }
    }
    
}
