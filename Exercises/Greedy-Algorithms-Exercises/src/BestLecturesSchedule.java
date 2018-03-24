import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BestLecturesSchedule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lectures = Integer.parseInt(reader.readLine().split("\\s+")[1]);
        List<SchoolSubject> subjects = new ArrayList<>();

        for (int i = 0; i < lectures; i++) {
            String[] tokens = reader.readLine().split("[:\\s-]+");

            SchoolSubject subject = new SchoolSubject(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            subjects.add(subject);
        }

        findBestSchedule(subjects);
    }

    private static void findBestSchedule(List<SchoolSubject> subjects) {
        subjects.sort(Comparator.comparingInt(SchoolSubject::getEndTime));

        List<SchoolSubject> schedule = new ArrayList<>();
        SchoolSubject subject = subjects.get(0);
        schedule.add(subject);
        int count = 1;

        for (int i = 1; i < subjects.size(); i++) {
            SchoolSubject currentSubject = subjects.get(i);
            if (currentSubject.getStartTime() >= subject.getEndTime()) {
                subject = currentSubject;
                schedule.add(subject);
                count++;
            }
        }

        System.out.println(String.format("Lectures (%d):", count));
        schedule.forEach(System.out::println);
    }


}

class SchoolSubject {
    private String subject;
    private int startTime;
    private int endTime;


    SchoolSubject(String subject, int startTime, int endTime) {
        this.subject = subject;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    String getSubject() {
        return this.subject;
    }

    int getStartTime() {
        return this.startTime;
    }

    int getEndTime() {
        return this.endTime;
    }

    @Override
    public String toString() {
        return String.format("%d-%d -> %s", this.startTime, this.endTime, this.subject);
    }
}