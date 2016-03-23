package com.sreeni;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by smadiraju on 3/21/16.
 */
public class LinkedListTest {

    public static class LinkedListNode {
        int val;
        LinkedListNode next;

        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    }

    public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, int val) {
        if (head == null) {
            head = new LinkedListNode(val);
        } else {
            LinkedListNode end = head;
            while (end.next != null) {
                end = end.next;
            }
            LinkedListNode node = new LinkedListNode(val);
            end.next = node;
        }
        return head;
    }

    static LinkedListNode Zip(LinkedListNode pList) {
        if (pList == null || size(pList) == 1) return pList;
        LinkedListNode saved = pList;
        LinkedListNode halfHead = reverse( breakIntoHalf(pList) );
        int k = size(pList);
        if (k == 2) return reverse(pList);
        int m = (k % 2 == 0)? k/2 : (k/2)+1;
        for (int i = 1; i < k/2; i++) {
            pList = pList.next;
        }
        pList.next = null;
        pList = saved;
        LinkedListNode first = pList;
        LinkedListNode second = halfHead;
        while (first != null && second != null) {
            LinkedListNode nextFirst = first.next;
            first.next = second;
            LinkedListNode nextSecond = second.next;
            second.next = nextFirst;
            first = nextFirst;
            second = nextSecond;
        }
        return saved;
    }

    static LinkedListNode[] Unzip(LinkedListNode pList){
        LinkedListNode first = null, second = null;
        LinkedListNode temp1 = null, temp2 = null;
        LinkedListNode firstNode = pList;
        LinkedListNode nextNode = pList.next;
        first = firstNode; second = nextNode;
        temp1 = first; temp2 = second;
        while (firstNode != null && nextNode != null
                && nextNode.next != null && second != null){
            first.next = firstNode.next.next;
            second.next = nextNode.next.next;
            firstNode = firstNode.next;
            nextNode = nextNode.next;
            first = first.next;
            second = second.next;
        }
        if (first != null) first.next = null;
        if (second != null) second.next = null;
        first = temp1;
        second = temp2;
        return new LinkedListNode[]{first, reverse(temp2)};
    }

    static LinkedListNode reverse(LinkedListNode node){
        LinkedListNode prev = null;
        LinkedListNode current = node;
        LinkedListNode next ;
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    static int size(LinkedListNode head) {
        int i = 1;
        if (head == null) return --i;
        while ((head = head.next) != null) ++i;
        return i;
    }

    static LinkedListNode breakIntoHalf(LinkedListNode head){
        if (head == null) return head;
        LinkedListNode saved = head;
        int k = size(head);
        int m = ( k % 2 == 0) ? k/2 : (k/2)+1;
        for (int i = 0; i < m; i++) {
            head = head.next;
        }
        LinkedListNode nList = null;
        if (head != null) {
            System.out.println("After moving half:" + head.val);
            nList = new LinkedListNode(head.val);
            LinkedListNode nListHead = nList;
            while (head.next != null) {
                head = head.next;
                LinkedListNode temp = new LinkedListNode(head.val);
                nList.next = temp;
                nList = temp;
            }
            nList = nListHead;
        }
        return nList;
    }

    public static void main(String[] args) throws IOException {
        LinkedListNode res ;
//        LinkedListNode res1 = new LinkedListNode(2);
//        res.next = res1;
//        LinkedListNode nres = reverse(res);


        int _pList_size = 6;//Integer.parseInt(in.nextLine()),
        int  _pList_i;
        int _pList_item;
        LinkedListNode _pList = null;
        for (_pList_i = 0; _pList_i < _pList_size; _pList_i++) {
            _pList_item = _pList_i+1;
            _pList = _insert_node_into_singlylinkedlist(_pList, _pList_item);
        }
        //_pList = new LinkedListNode(10);

        res = Zip(_pList);
        LinkedListNode ss = res;
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
        System.out.println("printing first list");
        LinkedListNode[] orig = Unzip(ss);
        while (orig[0] != null) {
            System.out.println(orig[0].val);
            orig[0] = orig[0].next;
        }
        System.out.println("printing second list");
        while (orig[1] != null) {
            System.out.println(orig[1].val);
            orig[1] = orig[1].next;
        }
    }
}
