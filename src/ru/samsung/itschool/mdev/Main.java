package ru.samsung.itschool.mdev;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;

    public static void main(String[] args) {
        double k1, b1, k2, b2;
        k1 = in.nextDouble();
        b1 = in.nextDouble();
        k2 = in.nextDouble();
        b2 = in.nextDouble();
        double[] cross = crossLines(k1, b1, k2, b2);
        if (cross != null) {
            out.println("Intersect (" + cross[0] + ", " + cross[1] + ")");
        }
        else {
            out.println("Do nor intersect");
        }
    }

    // Функция пересекает две прямые на плоскости,
    // заданных уравнением y = kx + b.
    // Если прямые не пересекаются или совпадают,
    // товозвращается null.
    public static double[] crossLines(double k1, double b1, double k2, double b2) {
        Double dk = k1 - k2;
        // если они параллельны, то возвращаем null
        if (dk == 0.0) {
            return null;
        }
        // формула получена из системы уравнений
        double x = (b2 - b1) / dk;
        double y = k1 * x + b1;
        // Проверка того, что полученная точка находится
        // на обоих прямых (проверка инвариантов).
        // Чтобы проверка работала необходимо добавить в
        // Run Configurations ? Arguments ? VM Arguments
        // строку -ea.
        assert onLine(k1, b1, x, y);
        assert onLine(k2, b2, x, y);
        return new double[]{x, y};
    }

    // Функция проверяет, что точка лежит на прямой,
    // заданной уравнением y = kx + b.
    private static boolean onLine(double k, double b, double x, double y) {
        return y == k * x + b;
    }
}
