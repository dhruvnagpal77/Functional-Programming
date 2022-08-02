import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StoringFunctionsInVariablesUsingFP {
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
        Consumer<Integer> integerConsumer = element -> System.out.println(element);
        list.stream()
                .forEach(integerConsumer);
    }

    public static void printOddMembers(List<Integer> list) {
        Predicate<Integer> integerPredicate = element -> element % 2 == 1;
        Consumer<Integer> integerConsumer = element -> System.out.println(element);
        list.stream()
                .filter(integerPredicate)
                .forEach(integerConsumer);
    }

    public static int calculateSumOfOddMembers(List<Integer> list) {
        Predicate<Integer> integerPredicate = element -> element % 2 == 1;
        BinaryOperator<Integer> integerBinaryOperator = (number1, number2) -> number1 + number2;
        return list.stream()
                .filter(integerPredicate)
                .reduce(0, integerBinaryOperator);
    }

    public static void sortListAndPrintDistinctMembers(List<Integer> list) {
        Consumer<Integer> integerConsumer = element -> System.out.println(element);
        list.stream().sorted().distinct().
                forEach(integerConsumer);
    }

    public static void sortListAndPrintDistinctSquareOfEachMember(List<Integer> list) {
        Function<Integer, Integer> integerIntegerFunction = x -> x * x;
        Consumer<Integer> integerConsumer = element -> System.out.println(element);
        list.stream().sorted().distinct().
                map(integerIntegerFunction).
                forEach(integerConsumer);
    }

    public static Optional<Integer> getMaxElement(List<Integer> list) {
        Comparator<Integer> integerComparator = (n1, n2) -> Integer.compare(n1, n2);
        return list.stream().max(integerComparator);
    }

    public static List<Integer> returnListOfOddValues(List<Integer> list) {
        Predicate<Integer> integerPredicate = e -> e % 2 == 1;
        return list.stream().filter(integerPredicate).collect(Collectors.toList());
    }

    public static List<Integer> squareOfFirst10Integers(List<Integer> list) {
        IntUnaryOperator intUnaryOperator = e -> e * e;
        return IntStream.range(1, 11).map(intUnaryOperator).boxed().collect(Collectors.toList());
    }
}