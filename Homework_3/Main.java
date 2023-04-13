package Homework_3;

import Homework_3.DoublyLinkedList;


import static Homework_3.DoublyLinkedList.printDoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();
//        DoublyLinkedList.Node node = new Node();
        myList.addToTail(8);
        myList.addToTail(-8);
        myList.addToTail(17);
        myList.addToTail(2);
        myList.addToTail(11);
        myList.addToTail(9);
        myList.addToTail(-1);
        System.out.printf("Initial list:            ");
        printDoublyLinkedList(myList);
        System.out.printf("\nPositives only list:     ");
        printDoublyLinkedList(myList.positivePlusNullList());
        System.out.printf("\nNegatives only list:    ");
        printDoublyLinkedList(myList.negativeList());
        System.out.printf("\nDuplicated evens list:   ");
        myList.duplicateEvens();
        printDoublyLinkedList(myList);
        System.out.printf("\nReversed list:          ");
        myList.reverseDoublyLinkedList();
        printDoublyLinkedList(myList);
    }
}
