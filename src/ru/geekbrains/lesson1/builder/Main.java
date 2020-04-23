package ru.geekbrains.lesson1.builder;

public class Main {
    public static void main(String[] args) {
        PersonBuilder builder = new PersonBuilder();
        Person person = builder.firstName("Катя")
                .lastName("Иванова")
                .address("Москва")
                .gender("женский")
                .age(20).build();

        System.out.println(person);
    }
}
