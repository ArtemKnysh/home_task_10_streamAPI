package org.nix.streamAPI.util.task;

import java.util.DoubleSummaryStatistics;
import java.util.Random;

public class Util {

    final static String CHARS_TO_RANDOM_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final static String SYMBOLS_TO_RANDOM_STRING = "{}()[]\\,._=+";
    static Random random = new Random();

    public static void showInfoFromSummaryStatisticsForDoubleArray(DoubleSummaryStatistics statistics) {
        System.out.println("Максимальное число = " + statistics.getMax());
        System.out.println("Минимальное число = " + statistics.getMin());
        System.out.println("Среднее арифметическое = " + statistics.getAverage());
        System.out.println("Сумма чисел = " + statistics.getSum());
    }

    public static String randomString(final int length) {
        char[] chars = CHARS_TO_RANDOM_STRING.toCharArray();
        char[] brackets = SYMBOLS_TO_RANDOM_STRING.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
            if (random.nextInt() % 2 == 0) {
                c = brackets[random.nextInt(brackets.length)];
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
