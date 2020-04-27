package ru.geekbrains.lesson2;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    private static class Node<E> {
        private MyLinkedList.Node<E> prev;
        private MyLinkedList.Node<E> next;
        private E value;

        public Node(Node<E> prev, Node<E> next, E value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    public E getFirst() {
        return first.value;
    }

    public E getLast() {
        return last.value;
    }

    public E removeFirst() {
        if (first == null) throw new NoSuchElementException();

        E val = first.value;
        first = first.next;
        first.prev = null;
        size--;
        return val;
    }

    public E removeLast() {
        if (last == null) throw new NoSuchElementException();

        E val = last.value;
        last = last.prev;
        last.next = null;
        size--;
        return val;
    }

    public void addFirst(E o) {
        Node<E> node = new Node<>(null, first, o);
        size++;
        if (first == null) {
            first = node;
            last = node;
            return;
        }
        first.prev = node;
        first = node;
    }

    public void addLast(E o) {
        Node<E> node = new Node<>(last, null, o);
        size++;
        if (last == null) {
            last = node;
            first = node;
            return;
        }
        last.next = node;
        last = node;
    }

    public boolean contains(E o) {
        if (first == null)
            return false;

        Node<E> node = first;
        while (node.next != null) {
            if (o.equals(node.value))
                return true;

            node = node.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean remove(E o) {
        if (first == null)
            return false;

        if (first.value.equals(o)) {
            removeFirst();
            return true;
        }

        if (last.value.equals(o)) {
            removeLast();
            return true;
        }

        Node<E> node = first;
        while (node.next != null) {
            if (o.equals(node.value)) {
                unlinkNodeAndClear(node);
            }
            node = node.next;
        }

        size--;
        return true;
    }

    private void unlinkNodeAndClear(Node<E> node) {
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        prev.next = next;
        next.prev = prev;
        clearNode(node);
    }

    private void clearNode(Node<E> node) {
        node.value = null;
        node.prev = null;
        node.next = null;
    }

    public void clear() {
        if (first == null)
            return;

        Node<E> node = first;
        Node<E> next_node;
        while (node.next != null) {
            next_node = node.next;
            clearNode(node);
            node = next_node;
        }

        first = null;
        last = null;
        size = 0;
    }

    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        if (index == 0) return getFirst();
        if (index == size - 1) return getLast();

        Node<E> node = first;
        int i = 0;
        while (node.next != null) {
            if (i == index) {
                return node.value;
            }
            i++;
            node = node.next;
        }
        return null;
    }

    public void set(int index, E element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(element);
            return;
        }
        if (index == size) {
            addLast(element);
            return;
        }
        Node<E> node = first;
        int i = 0;
        while (node.next != null) {
            if (i == index) {
                Node<E> new_node = new Node<>(node.prev, node, element);
                node.prev.next = new_node;
                node.prev = new_node;
                size++;
                return;
            }
            i++;
            node = node.next;
        }
    }

    public Object remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        if (index == 0) return getFirst();
        if (index == size - 1) return getLast();

        Node<E> node = first;
        int i = 0;
        while (node.next != null) {
            if (i == index) {
                unlinkNodeAndClear(node);
            }
            i++;
            node = node.next;
        }
        return null;
    }

    public int indexOf(E o) {
        if (first == null)
            return -1;

        int index = 0;
        Node<E> node = first;
        while (node.next != null) {
            if (node.value.equals(o)) {
                return index;
            }
            index++;
            node = node.next;
        }
        return -1;
    }

    public E peekFirst() {
        return getFirst();
    }

    public E peekLast() {
        return getLast();
    }

    @Override
    public String toString() {
        if(first==null)
            return "";
        StringBuilder builder = new StringBuilder();
        Node<E> node = first;
        while (node.next != null) {
            builder.append(node.value);
            builder.append(", ");
            node = node.next;
        }
        //выведем последнее значение
        builder.append(node.value);
        return builder.toString();
    }
}
