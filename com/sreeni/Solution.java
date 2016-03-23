package com.sreeni;

/**
 * Created by smadiraju on 3/19/16.
 */
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        test();
    }

    public static class TreeNode {
        int distanceFromParent;
        ArrayList<TreeNode> children;
    }

    public static class DiameterReturnValue {
        int diameter, distanceToMostDistantLeaf;
    }

    public static int diameter(TreeNode tree){
        if (tree == null){
            return -1;
        }

        return diameterRecursion(tree).diameter;
    }

    public static DiameterReturnValue diameterRecursion(TreeNode tree){
        DiameterReturnValue returnValue = new DiameterReturnValue();
        if (tree.children == null){
            returnValue.distanceToMostDistantLeaf = tree.distanceFromParent;
            returnValue.diameter = 0;
            return returnValue;
        }

        returnValue.diameter = -1;
        int total_max_distance, total_2nd_max_distance;
        total_max_distance = total_2nd_max_distance = 0;
        for (TreeNode child: tree.children){
            DiameterReturnValue r = diameterRecursion(child);
            returnValue.diameter = Math.max(returnValue.diameter,
                    r.diameter);
            if (r.distanceToMostDistantLeaf > total_max_distance){
                total_2nd_max_distance = total_max_distance;
                total_max_distance = r.distanceToMostDistantLeaf;
            } else if (r.distanceToMostDistantLeaf > total_2nd_max_distance){
                total_2nd_max_distance = r.distanceToMostDistantLeaf;
            }
        }
        returnValue.distanceToMostDistantLeaf = total_max_distance +
                tree.distanceFromParent;
        returnValue.diameter = Math.max(returnValue.diameter,
                total_max_distance +
                        total_2nd_max_distance);
        return returnValue;
    }

    public static class TestCase {
        public TestCase(String t, int d){
            tree = t;
            diameter = d;
        }

        String tree;
        int diameter;
    }

    public static int index;
    public static TreeNode buildTree(String s){
        index = 0;
        return buildTree(s.toCharArray());
    }

    public static int readNumber(char[] s){
        int d = 0;
        while (Character.isDigit(s[index])){
            d *= 10;
            d += s[index++] - '0';
        }
        return d;
    }

    public static TreeNode buildTree(char[] s){
        index++;
        TreeNode node = new TreeNode();

        node.distanceFromParent = readNumber(s);
        index++;
        int number_of_children = readNumber(s);
        index++;
        if (number_of_children == 0){
            return node;
        }
        node.children = new ArrayList<TreeNode>();
        while (number_of_children-- > 0){
            node.children.add(buildTree(s));
            index++;
        }
        return node;
    }

    public static TestCase tests[] = {
            new TestCase("{0,0}", 0),
            new TestCase("{0,1,{5,0}}", 5),
            new TestCase("{0,1,{5,1,{4,1,{7,0}}}}", 16),
            new TestCase("{0,1,{5,2,{8,0},{7,0}}}", 15),
            new TestCase("{0,3,{1,2,{5,0},{7,0}},{1,2,{6,0},{5,0}},{1,2,{10,0},{9,0}}}",19)
    };

    public static void test() {
        int result = 0;
        int errors = 0;
        for( int i=0; i<tests.length; ++i){
            System.out.println("-----------");
            TreeNode tree = buildTree(tests[i].tree);
            result = diameter(tree);
            System.out.println(result+""+errors);
            if (result != tests[i].diameter){
                System.out.println("Error: diameter "+i+
                                  " is "+tests[i].diameter);
                errors++;
            }
        }
        System.out.println(result+""+errors);
    }
}
