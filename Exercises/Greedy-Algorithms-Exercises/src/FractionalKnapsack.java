import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FractionalKnapsack {
    private static final String OUTPUT_FORMAT_LESS_100 = "Take %.2f%% of item with price %.2f and weight %.2f";
    private static final String OUTPUT_FORMAT_100 = "Take %d%% of item with price %.2f and weight %.2f";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int capacity = Integer.parseInt(reader.readLine().split("\\s+")[1]);
        int countOfItems = Integer.parseInt(reader.readLine().split("\\s+")[1]);

        List<Subject> subjects = new ArrayList<>();
        for (int i = 0; i < countOfItems; i++) {
            String[] tokens = reader.readLine().split(" -> ");
            Subject subject = new Subject(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[1]));
            subjects.add(subject);
        }

        fillKnapsack(subjects, capacity);
    }

    private static void fillKnapsack(List<Subject> subjects, int capacity) {
        subjects.sort((a, b) -> Double.compare(b.getPriceWeightRatio(), a.getPriceWeightRatio()));

        int currentCapacity = 0;
        int remainCapacity = capacity;
        double totalPrice = 0;
        for (Subject subject : subjects) {
            double weight = subject.getWeight();
            double price = subject.getPrice();
            double currentWeight = weight;
            double currentPrice = price;
            double percentage = 100;

            if (currentCapacity + weight > capacity) {
                percentage = (remainCapacity / weight) * 100d;
                currentWeight *= percentage / 100;
                currentPrice *= percentage / 100;
            }

            if (percentage == 100) {
                System.out.println(String.format(OUTPUT_FORMAT_100, (int) percentage, price, weight));
            } else {
                System.out.println(String.format(OUTPUT_FORMAT_LESS_100, percentage, price, weight));
            }

            remainCapacity -= currentWeight;
            currentCapacity += currentWeight;
            totalPrice += currentPrice;

            if (currentCapacity == capacity) {
                break;
            }
        }

        System.out.println(String.format("Total price: %.2f", totalPrice));
    }
}

class Subject {
    private double price;
    private double weight;

    Subject(double price, double weight) {
        this.price = price;
        this.weight = weight;
    }


    double getPrice() {
        return this.price;
    }

    double getWeight() {
        return this.weight;
    }

    double getPriceWeightRatio() {
        return price / weight;
    }
}
