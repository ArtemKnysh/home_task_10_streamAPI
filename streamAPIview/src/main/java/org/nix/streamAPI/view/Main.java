package org.nix.streamAPI.view;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;

import static org.nix.streamAPI.util.task.Util.*;
import static org.nix.streamAPI.util.task.Tasks.*;

public class Main {

    public static void main(String[] args) {

        calcAndShowSummaryStatisticsForDoubleArray();

        findLeapYearsInYearsList();

        cutAllNoneLitersOrNumbersSymbolsFromStringsInList();

        findAllPalindromesInStringList();

        findFirstPrimeNumbersByCount();

        createMapWithCountBirthdaysPerMonth();

        partingIntegerNumbersListByParityAndSort();

        combineListUnaryOperatorsToOneUnaryOperator();

    }

    private static void calcAndShowSummaryStatisticsForDoubleArray() {
        double[] doubleNumbers = {1.1, 2.5, 6.5, 3, 5.21};
        System.out.println("Массив: " + Arrays.toString(doubleNumbers));
        showSummaryStatisticsForDoubleArray(doubleNumbers);
    }

    private static void findLeapYearsInYearsList() {
        List<Year> years = List.of(
                Year.of(2019),
                Year.of(2020),
                Year.of(2012),
                Year.of(2014)
        );
        List<Year> leapYears = findLeapYears(years);
        System.out.println("\nКоллекция лет: " + years);
        System.out.println("Высокосные годы: " + leapYears);
    }

    private static void cutAllNoneLitersOrNumbersSymbolsFromStringsInList() {
        List<String> stringsBeforeCut = List.of(
                randomString(10),
                randomString(10),
                randomString(10)
        );
        List<String> stringsAfterCut = cutAllNoneLitersOrNumbersSymbols(stringsBeforeCut);
        System.out.println("\nСписок строк до изменений: \n" + stringsBeforeCut);
        System.out.println("Список строк после изменений: \n" + stringsAfterCut);
    }

    private static void findAllPalindromesInStringList() {
        List<String> strings = List.of(
                "ADsg sdds adgg dfgfd",
                "reyy sadas fghhh Addfdda"
        );
        List<String> palindromes = findAllPalindromes(strings);
        System.out.println("\nСписок строк со словами, содержащими палиндромы: \n" + strings);
        System.out.println("Список палиндромов: \n" + palindromes);
    }

    private static void findFirstPrimeNumbersByCount() {
        long countPrimeNumbers = 20;
        System.out.println("\nСписок из "+countPrimeNumbers+" первых вероятных простых чисел: \n" + findPrimeNumbers(countPrimeNumbers));
    }

    private static void createMapWithCountBirthdaysPerMonth() {
        List<LocalDate> birthdaysEmployees = List.of(
                LocalDate.of(2000, 6, 16),
                LocalDate.of(1999,6,17),
                LocalDate.of(2001,4,3)
        );
        Map<Month, Long> birthdaysPerMonth = countBirthdaysPerMonth(birthdaysEmployees);
        System.out.println("\nСписок дней рождения сотрудников фирмы: \n" + birthdaysEmployees);
        System.out.println("Количество дней рожденья в каждом месяце: \n" + birthdaysPerMonth);
    }

    private static void partingIntegerNumbersListByParityAndSort() {
        int[] intNumbers = {10, 21, 13, 50, 7};
        Map<Boolean, List<Integer>> numbersPartingByParity = partingListIntNumbers(intNumbers);

        System.out.println("\nСписок целых чисел: \n" + Arrays.toString(intNumbers));
        System.out.println("Целые числа, разбитые по четности (false - нечетные, true - четные), и отсортированные по убыванию: \n" + numbersPartingByParity);
    }

    private static void combineListUnaryOperatorsToOneUnaryOperator() {
        List<UnaryOperator<Integer>> unaryOperators = List.of(
                i -> i*i,
                i -> i+4,
                i -> i+i*2
        );
        Integer number = 10;
        System.out.print("\nК числу "+number+" применены унарные операторы из списка. Результат: ");
        for (UnaryOperator<Integer> unaryOperator : unaryOperators) {
            number = unaryOperator.apply(number);
        }
        System.out.print(number);
        number = 10;
        System.out.print("\nК числу "+number+" применен унарный оператор, который обьединяет в себе унарные операторы из списка. Результат: ");
        number = combineListUnaryOperators(unaryOperators).apply(number);
        System.out.print(number);
    }

}
