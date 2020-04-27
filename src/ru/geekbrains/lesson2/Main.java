package ru.geekbrains.lesson2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        MyArrayList<Integer> arrayList = new MyArrayList(5);
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);

        System.out.println(arrayList);
        arrayList.remove(5);
        System.out.println("После удаления 5: " + arrayList + ". Длина " + arrayList.size());

        arrayList.remove(new Integer(9));
        System.out.println("После удаления числа 9: " + arrayList + ". Длина " + arrayList.size());

        System.out.println("Индекс числа 3: " + arrayList.indexOf(new Integer(3)));

        System.out.println("Содержит число 7:" + arrayList.contains(new Integer(7)));

        arrayList.clear();
        System.out.println(arrayList);

        System.out.println("=======================================");

        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(0);

        System.out.println(list);
        System.out.println("Длина связанного списка " + list.size());

        System.out.println("Первый элемент " + list.getFirst() + ", последний элемент " + list.getLast());
        System.out.println("Значение элемента под индексом 8 = " + list.get(8));
        System.out.println("Содержит 4: " + list.contains(4));
        System.out.println("Содержит 44: " + list.contains(44));
        System.out.println("После удаления последнего элемента : " + list.removeLast() + " размер = " + list.size());
        System.out.println("После удаления первого элемента : " + list.removeFirst() + " размер = " + list.size());
        list.set(2, new Integer(44));
        System.out.println(list);
        System.out.println("Индекс числа 6 = " + list.indexOf(6));
        list.clear();
        System.out.println("Размер после очистки " + list.size());
        System.out.println(list);


    }
}
