package Seminar3;

public class LinkedList {
    Node head;
    Node tail;
    public Node find(int number) {
        Node curNode = head;
        while(curNode != null) {
            if (curNode.value == number) {
                return curNode;
            }
            curNode = curNode.next;
        }
        return null;
    }
    public void addToTail(int number) {
        Node node = new Node();
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
        node.value = number;
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
    public void delete (Node node) {
        Node prev = node.prev;
        Node next = node.next;
        if (prev == null) {
            next.prev = null;
            head = next;
        }
        else {
            if (next == null) {
                prev.next = null;
                tail = prev;
            }
            else {
                prev.next = next;
                next.prev = prev;
            }
        }
    }
    public static void printLinkedList(LinkedList list)
    {
        Node currNode = list.head;
        while (currNode != null) {
            System.out.print(currNode.value + "  ");
            currNode = currNode.next;
        }
    }
    public void reverseDoublyLinkedList() {
        Node curNode = head;
        while (curNode != null) {
            Node next = curNode.next;
            Node prev = curNode.prev;
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
    public void reverseSinglyLinkedList(Node curNode, Node prevNode) {
        if (curNode.next == null) {
            head = curNode;
        }
        else {
            reverseSinglyLinkedList(curNode.next, curNode);
        }
        curNode.next = prevNode;
        prevNode.next = null;
    }

    // Вложить эл-т в начало списка для стэка:
    public void pushS(int number) {
        Node node = new Node();
        node.value = number;
        node.next = head;
        head = node;
    }

    // Извлечь эл-т из начала списка для стэка:
    public Integer popS() {
        Integer result = null;
        if (head != null) {
            result = head.value;
            head = head.next;
        }
        return result;
    }
    // Вложить эл-т в начало списка для очереди:
    public void pushQ(int number) {
        Node node = new Node();
        node.value = number;
        node.next = head;
        head.prev = node;
        head = node;
    }
    // Извлечь эл-т из конца списка для очереди:
    public Integer peekQ() {
        Integer result = null;
        if (tail != null) {
            result = tail.value;
            tail.prev.next = null;
            tail = tail.prev;
        }
        return result;
    }

    public class Node {
        int value;
        Node next;
        Node prev;

    }
}
