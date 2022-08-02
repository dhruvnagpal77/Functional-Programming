import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Passing functions to method approach
public class FunctionalProgrammingRunner {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(4, 6, 8, 13, 3, 3, 15);

        System.out.println("Printing all numbers");
        FunctionalProgrammingRunner.printList(numbers);

        System.out.println("Printing all odd numbers");
        FunctionalProgrammingRunner.printOddMembers(numbers);

        System.out.println("Printing the sum of all odd numbers");
        int sumOfOdd = FunctionalProgrammingRunner.calculateSumOfOddMembers(numbers);
        System.out.println(sumOfOdd);

        System.out.println("Sorting & printing distinct numbers");
        FunctionalProgrammingRunner.sortListAndPrintDistinctMembers(numbers);

        System.out.println("Sorting & printing distinct square of each numbers");
        FunctionalProgrammingRunner.sortListAndPrintDistinctSquareOfEachMember(numbers);

        System.out.println("Max element in the number list is");
        Optional<Integer> max = FunctionalProgrammingRunner.getMaxElement(numbers);
        System.out.println(max.get());

        System.out.println("List of odd numbers is");
        List<Integer> list = FunctionalProgrammingRunner.returnListOfOddValues(numbers);
        System.out.println(list);

        System.out.println("Square of 1st 10 integers are");
        List<Integer> listSquare = FunctionalProgrammingRunner.squareOfFirst10Integers(numbers);
        System.out.println(listSquare);

    }

    public static void printList(List<Integer> list) {
        list.stream()
                .forEach(element -> System.out.println(element));
    }

    public static void printOddMembers(List<Integer> list) {
        list.stream()
                .filter(element -> element % 2 == 1)
                .forEach(element -> System.out.println(element));
    }

    public static int calculateSumOfOddMembers(List<Integer> list) {
        return list.stream()
                .filter(element -> element % 2 == 1)
                .reduce(0, (number1, number2) -> number1 + number2);
    }

    public static void sortListAndPrintDistinctMembers(List<Integer> list) {
        list.stream().sorted().distinct().
                forEach(element -> System.out.println(element));
    }

    public static void sortListAndPrintDistinctSquareOfEachMember(List<Integer> list) {
        list.stream().sorted().distinct().
                map(x -> x * x).
                forEach(element -> System.out.println(element));
    }

    public static Optional<Integer> getMaxElement(List<Integer> list) {
        return list.stream().max((n1, n2) -> Integer.compare(n1, n2));
    }

    public static List<Integer> returnListOfOddValues(List<Integer> list) {
        return list.stream().filter(e -> e % 2 == 1).collect(Collectors.toList());
    }

    public static List<Integer> squareOfFirst10Integers(List<Integer> list) {
        return IntStream.range(1, 11).map(e -> e * e).boxed().collect(Collectors.toList());
    }

}