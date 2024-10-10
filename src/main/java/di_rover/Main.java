package di_rover;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.log("Start program");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello user!");
        logger.log("Greeting user");
        System.out.println("Please enter list's size");
        logger.log("Ask user to enter list's size");

        int listSize = scanner.nextInt();
        logger.log("User entered list's size " + listSize);

        System.out.println("Please enter max element of list");
        logger.log("Ask user to enter max element of list");

        int maxNumber = scanner.nextInt();
        logger.log("User entered max element of list " + maxNumber);

        Random random = new Random();

        List<Integer> numbers = Stream.generate(() -> random.nextInt(maxNumber))
                .limit(listSize)
                .toList();

        logger.log("Random list of numbers " + numbers.stream()
                .map(String::valueOf)  // Преобразование каждого числа в строку
                .collect(Collectors.joining(", ")));

        System.out.println("Please enter number for filter list");
        logger.log("Ask user to enter filter number");

        int filterNumber = scanner.nextInt();
        logger.log("User entered filter number " + filterNumber);

        Filter filter = new Filter(filterNumber);
        logger.log("Filter created");

        List<Integer> list = filter.filterOut(numbers);

        logger.log("Show result on screen");

        System.out.println(list);

        logger.log("End the program");
    }
}