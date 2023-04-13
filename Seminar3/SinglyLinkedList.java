package Seminar3;

public class SinglyLinkedList {
    private Node head;

    private class Node {
        private int value;
        private Node next;
    }
    public void addToStart(int value) {
        Node n = new Node();
        n.value = value;
        if (head != null) {
            n.next = head;
        }
        head = n;
    }
    public void deleteElement() {
        if (head != null) {
            head = head.next;
        }
    }
    public boolean find(int value) {
        Node curNode = head;
        while (curNode != null) {
            if (curNode.value == value) {
                return true;
            }
            curNode = curNode.next;
        }
        return false;
    }
    public void addLast(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null)
        {
            head = node;
            return;
        }
        else {
            Node curNode = head;
            while (curNode.next != null) {
                curNode = curNode.next;
            }
            curNode.next = node;
        }
        Node curNode = head;
    }
    public void deleteLast(int value) {
        Node curNode = head;
        if(head != null) {
            while (curNode.next != null) {
                if (curNode.next.next == null) {
                    curNode.next = null;
                    return;
                }
                curNode = curNode.next;
            }
        }
    }


}
