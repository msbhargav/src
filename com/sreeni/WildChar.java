package com.sreeni;

/**
 * Created by smadiraju on 3/17/16.
 */
public class WildChar {
    static char WILD_CHAR = '?';

    public static void main(String[] args) {
        wildChar("1?1?", 0);
    }

    static void wildChar(String s, int i) {
        if (s.length() == i || i > s.length()) {
            System.out.println(s);
            return;
        }
        char[] chars = s.toCharArray();
        if (chars[i] == WILD_CHAR) {
            chars[i] = '0';
            wildChar(new String(chars), i + 1);
            chars[i] = '1';
            wildChar(new String(chars), i + 1);
            chars[i] = '?';
        } else {
            wildChar(s, i + 1);
        }
    }

}
