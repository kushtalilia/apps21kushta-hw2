package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Node node = new Node();
        Node node1 = new Node();
        node.setNext(node1);
        node.setValue(1);
        node1.setValue(2);
//        System.out.println(node1.getValue());

        ImmutableArrayList list = new ImmutableArrayList( new Object[]{1,2,3});


    }
}