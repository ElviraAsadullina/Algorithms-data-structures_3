package Homework_3;

import Seminar3.LinkedList;
import org.w3c.dom.Node;

public class DoublyLinkedList {
    Node head;
    Node tail;

    public class Node {
        int value;
        Node next;
        Node prev;
    }

    public void addToTail(int number) {
        DoublyLinkedList.Node node = new DoublyLinkedList.Node();
        node.value = number;
        if (head == null) {
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }
    public void addToMid(int number, Node node) {
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = number;
        node.next = newNode;
        newNode.prev = node;
        if (next == null) {
            tail = newNode;
        }
        else {
            next.prev = newNode;
            newNode.next = next;
        }
    }

    public void reverseDoublyLinkedList() {
        DoublyLinkedList.Node curNode = head;
        while (curNode != null) {
            DoublyLinkedList.Node next = curNode.next;
            DoublyLinkedList.Node prev = curNode.prev;
            curNode.next = prev;
            curNode.prev = next;
            if (prev == null) {
                tail = curNode;
            }
            if (next == null) {
                head = curNode;
            }
            curNode = next;
        }
    }
    public void duplicateEvens() {
        Node curNode = head;
        while (curNode != null) {

            if (curNode.value % 2 == 0) {
                addToMid(curNode.value, curNode);
                curNode = curNode.next.next;
            }
            else{
                curNode = curNode.next;
            }
        }
    }
    public DoublyLinkedList positivePlusNullList() {
        DoublyLinkedList positive = new DoublyLinkedList();
        Node curNode = head;
        while (curNode != null) {

            if (curNode.value >= 0) {
                positive.addToTail(curNode.value);
            }
            curNode = curNode.next;
        }
        return positive;
    }
    public DoublyLinkedList negativeList() {
        DoublyLinkedList negative = new DoublyLinkedList();
        Node curNode = head;
        while (curNode != null) {

            if (curNode.value < 0) {
                negative.addToTail(curNode.value);
            }
            curNode = curNode.next;
        }
        return negative;
    }

    public static void printDoublyLinkedList(DoublyLinkedList list)
    {
        DoublyLinkedList.Node currNode = list.head;
        while (currNode != null) {
            System.out.print(currNode.value + "  ");
            currNode = currNode.next;
        }
    }
}
