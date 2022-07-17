package org.example;

public class Main {
    public static void main(String[] args) {
        StringList stringList = new StringListImpl(10);
        stringList.add("hello");
        stringList.add("how");
        System.out.println(stringList.get(1));
    }
}