import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Use streams to filter, map, and collect the list
        List<Integer> evenSquares = numbers.stream()
                .filter(n -> n % 2 == 0)       // Intermediate operation: filter even numbers
                .map(n -> n * n)               // Intermediate operation: square each number
                .collect(Collectors.toList()); // Terminal operation: collect the result into a list

        // Print the result
        System.out.println("Even squares: " + evenSquares);

        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 4 == 0));

        // Print the partitioned result
        System.out.println("Partitioned: " + partitioned.toString());

        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        // Print the flattened list result
        System.out.println("Flattened List: " + flattenedList.toString());
    }
}
