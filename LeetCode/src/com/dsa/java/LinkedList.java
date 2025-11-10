package com.dsa.java;

public class LinkedList {
    Node head;
    Node tail;
    int length;
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    public LinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;

    }

    public void push(int value){
        Node newNode = new Node(value);
        if (this.length == 0){
            this.head = newNode;
            this.tail = newNode;
        }else{
            head.next = newNode;
            head = newNode;
        }
        this.length++;

    }

    public Node pop(){
        if (this.length == 0){
            return null;
        }
        Node temp = head;
        Node prev = temp;
        while (temp.next.next != null) {
            temp = temp.next;
            prev = temp;

        }
        prev.next = null;
        tail = prev;
        if (this.length == 1){
            this.head = null;
        }
        this.length--;
        return temp;
    }
}
