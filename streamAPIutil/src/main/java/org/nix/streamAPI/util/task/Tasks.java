package org.nix.streamAPI.util.task;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.nix.streamAPI.util.task.Util.showInfoFromSummaryStatisticsForDoubleArray;

public class Tasks {

    public static void showSummaryStatisticsForDoubleArray(double[] data) {
        DoubleSummaryStatistics statistics = Arrays
                .stream(data)
                .boxed()
                .collect(Collectors
                        .summarizingDouble(d -> d));
        showInfoFromSummaryStatisticsForDoubleArray(statistics);
    }

    public static List<Year> findLeapYears(Collection<Year> years) {
        return years.stream().filter(Year::isLeap).sorted().collect(Collectors.toList());
    }

    public static List<String> cutAllNoneLitersOrNumbersSymbols(Collection<String> strings) {
        return strings.stream().map(
                str -> str.replaceAll("[^a-zA-Z0-9]*", ""))
                .collect(Collectors.toList());
    }

    public static List<String> findAllPalindromes(Collection<String> strings) {
        return strings.stream()
                .flatMap((str) -> Arrays.stream(str.split("\\s+")))
                .filter(word -> word.equalsIgnoreCase(new StringBuilder(word).reverse().toString()))
                .collect(Collectors.toList());
    }

    public static List<BigInteger> findPrimeNumbers(long count) {
        return Stream
                .iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE))
                .filter(n -> n.isProbablePrime(100))
                .limit(count)
                .collect(Collectors.toList());
    }

    public static Map<Month, Long> countBirthdaysPerMonth(List<LocalDate> birthdaysEmployees) {
        return birthdaysEmployees.stream()
                .collect(Collectors.groupingBy(LocalDate::getMonth, Collectors.counting()));
    }

    public static Map<Boolean, List<Integer>> partingListIntNumbers(int[] data) {
        return Arrays
                .stream(data)
                .boxed()
                .sorted((o1, o2) -> -o1.compareTo(o2))
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
    }

    public static UnaryOperator<Integer> combineListUnaryOperators(List<UnaryOperator<Integer>> unaryOperators) {
        return unaryOperators
                .stream()
                .reduce(
                        i -> i,
                        (uo1, uo2) -> uo1.andThen(uo2)::apply
                );
    }

}
