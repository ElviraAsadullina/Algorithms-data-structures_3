package Seminar3;

import Seminar3.LinkedList;

import java.net.Socket;
import java.util.Arrays;
import java.util.List;

import static Seminar3.LinkedList.printLinkedList;
import Seminar3.LinkedList.Node;

public class Test {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        myList.addToTail(8);
        myList.addToTail(17);
        myList.addToTail(2);
        myList.addToTail(11);
        myList.addToTail(9);
        myList.addToTail(1);
        printLinkedList(myList);
        System.out.println();
        myList.reverseDoublyLinkedList();
        printLinkedList(myList);
    }
}
