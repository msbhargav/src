package com.sreeni;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by smadiraju on 3/9/16.
 */
public class KNearestPoints {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int compareX(Point p1, Point p2) {
        return p1.x - p2.x;
    }

    static int compareY(Point p1, Point p2) {
        return p1.y - p2.y;
    }

    static double dist(Point p1, Point p2) {

        return Math.sqrt(
                (p1.x - p2.x) * (p1.x - p2.x) +
                        (p1.y - p2.y) * (p1.y - p2.y)
        );
    }

    static double bruteForce(Point[] P, int n) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double d = dist(P[i], P[j]);
                if (d < min)
                    min = d;
            }
        }
        return min;
    }

    static double min(double x, double y) {
        return (x < y) ? x : y;
    }

    static double stripClosest(Point[] strip, int size, double d) {
        double min = d;
        Point s1, s2;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < min; j++) {
                if (dist(strip[i], strip[j]) < min) {
                    s1 = strip[i];
                    s2 = strip[j];
                    min = dist(strip[i], strip[j]);
                }
            }
        }
        return min;
    }

    static double closestUtil(Point[] px, Point[] py, int n) {
        if (n < 3) {
            return bruteForce(px, n);
        }

        int mid = n / 2;
        Point midPoint = px[mid];

        //Point[] pxd = new Point[px.length - mid];
        Point[] pxl = Arrays.copyOfRange(px, 0, px.length - mid);
        Point[] pxr = Arrays.copyOfRange(px, px.length - mid, px.length);

        Point[] pyl = new Point[pxl.length]; // if n = 6, mid = 3, left size is 3 + 1 = 4 ? right is 6 - 3 - 1 = 2
        Point[] pyr = new Point[pxr.length];

        int left = 0, right = 0;

        //sorted by x;
        for (int i = 0; i < n && left < pyl.length && right < pyr.length; i++) {
            if (py[i].x <= midPoint.x) {
                pyl[left++] = py[i];
            } else {
                pyr[right++] = py[i];
            }
        }

        double dl = closestUtil(pxl, pyl, mid);
        double dr = closestUtil(pxr, pyr, n - mid -1);

        double d = min(dl, dr);

        Point[] strip = new Point[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (py[i] != null && Math.abs(py[i].x - midPoint.x) < d) {
                strip[j] = py[i];
                j++;
            }
        }

        return min(d, stripClosest(strip, j, d));
    }

    static double closest(Point[] p, int n) {
        Point[] px = new Point[n];
        Point[] py = new Point[n];
        for (int i = 0; i < n; i++) {
            px[i] = p[i];
            py[i] = p[i];
        }

        Arrays.sort(px, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Integer.compare(o1.x, o2.x);
            }
        });

        Arrays.sort(py, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Integer.compare(o1.y, o2.y);
            }
        });

        return closestUtil(px, py, n);
    }

    public static void main(String[] args) {
        Point[] p = new Point[]{
                new Point(1, 1), //0
                new Point(2, 3),//1
                new Point(12, 30),//2
                new Point(5, 1),//3
                new Point(6, 3),//4
                new Point(6, 4),//4
                new Point(7, 2),//5
                new Point(10, 2),//5
                new Point(8, 10)};//6
        System.out.println(closest(p, 9));
    }
}
