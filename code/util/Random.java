package util;

import java.util.List;

public abstract class Random {

    public static boolean prob(double probability) {
        return probability > random(100.);
    }

    public static int random(int to) {
        return random(0, to);
    }

    public static double random(double to) {
        return Math.random() * to;
    }

    public static double random(double from, double to) {
        return from + Math.random() * (to - from);
    }

    public static int random(int from, int to) {
        return (int) Math.round(from + Math.random() * (to - from));
    }

    public static <T> T pick(List<T> list) {
        return list.get((int) Math.floor(Math.random() * list.size()));
    }

    public static <T> T pick(T...var) {
        return var[(int) Math.floor(Math.random() * var.length)];
    }

}
