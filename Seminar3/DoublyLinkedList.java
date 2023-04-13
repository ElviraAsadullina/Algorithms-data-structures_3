package Seminar3;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    private class Node {
        private int value;
        private Node next;
        private Node prev;
    }
    public void addToStart(int value) {
        Node n = new Node();
        n.value = value;
        if (head == null) {
            tail = n;
        }
        else {
            head.prev = n;
            n.next = head;
        }
        head = n;
    }
    public void deleteFirst() {
        if (head != null && head.next != null) {
            head.next.prev = null;
            head = head.next;
        }else{
            head = null;
            tail = null;
        }
    }
    public boolean find(int value) {
        Node curNode = head;
        while (curNode != null) {
            if (curNode.value == value) {
                return true;
            }
        }
        return false;
    }
    public void deleteLast() {
        if (tail != null && tail.prev != null) {
            tail.prev.next = null;
            tail = tail.prev;
        }
        else {
            head = null;
            tail = null;
        }
    }
    public void bubbleSort() {
        boolean finish;
        do {
            Node cur = head;
            finish = true;
            while (cur != null && cur.next != null) {
                if (cur.value > cur.next.value) {
                    int tmp = cur.value;
                    cur.value = cur.next.value;
                    cur.next.value = tmp;
                    finish = false;
                }
                cur = cur.next;
            }
        } while (!finish);
    }
}
