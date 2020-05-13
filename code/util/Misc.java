package util;

public abstract class Misc {

    public static double clamp(double val, double from, double to) {
        return from > to ? Math.max(to, Math.min(from, val)) : Math.max(from, Math.min(to, val));
    }

    public static int clamp(int val, int from, int to) {
        return from > to ? Math.max(to, Math.min(from, val)) : Math.max(from, Math.min(to, val));
    }

    public static double round(double val, double rounding) {
        return Math.round(Math.round(val / rounding) * rounding);
    }

    public static int round(int val, int rounding) {
        return (int) round((double) val, (double) rounding);
    }

    public static int round(double val, int rounding) {
        return (int) round(val, (double) rounding);
    }

}
