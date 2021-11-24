package IteratorsAndComparators.StackIterator;

import java.util.Iterator;

public class Stack <Integer> implements  Iterable<Integer>{
    private class Node<Integer>{
        private int element;
        private  Node<Integer> prev;

        private Node(int element){
            this.element = element;
            this.prev = null;
        }
    }




    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
