package com.sreeni;

import com.javafx.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * Created by smadiraju on 3/23/16.
 */
public class CloneLinkedList {

    static class Node {
        Node next = null;
        int val;
        Node random = null;

        Node(int val, Node random){
            this.val = val;
            this.random = random;
        }
    }

    static void print(Node node) {
        Node x = node;
        while (x != null){
            System.out.print("->" + x.val+"("+((x.random == null) ? null : x.random.val)+")");
            x = x.next;
        }
        System.out.println();
    }

    static Node insertClonesInTheMiddle(Node head){
        Node x = head;
        while ( x != null) {
            Node xprime = new Node(x.val, x.random);
            Node next = x.next;
            x.next = xprime;
            xprime.next = next;
            xprime.random = x.random;
            x = next;
        }
        x = head;
        while ( x != null && x.next != null){
            Node xprime = x.next;
            if (xprime.random != null) {
                xprime.random = xprime.random.next;
            } else {
                xprime.random = null;
            }
            x = x.next;
        }
        return head;
    }

    static Node getClonedList(Node head){
        Node x = insertClonesInTheMiddle(head);
        Node xprime = x.next;
        Node saved = xprime;
        while (x != null && xprime != null){
            x.next = x.next.next;
            if (xprime.next != null)
                xprime.next = xprime.next.next;
            x = x.next;
            xprime = xprime.next;
        }
        return saved;
    }

    public static void main(String[] args) {
        Node random = new Node(3, null);
        Node nrandom = new Node(5, null);

        Node head = new Node(1,random);
        head.next = new Node(2, null);
        head.random = random;
        head.next.next = random;
        random.random = head;
        head.next.next.next = new Node(4, null);
        head.next.next.next.next = nrandom;
        nrandom.random = head.next;
        print(head);

        //test insertClones.

        //insertClonesInTheMiddle(head);

        //print(head);

        Node test = getClonedList(head);

        System.out.println("Printing original");
        print(head);
        System.out.println("Printing clone");
        print(test);
    }
}
