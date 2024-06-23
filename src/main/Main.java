package main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> numbers = CoolNumbers.generateCoolNumbers();

        long start = System.nanoTime();
        boolean listHasNumber = CoolNumbers.bruteForceSearchInList(numbers, "С777ТЕ168");
        long end = System.nanoTime() - start;

        if (listHasNumber) {
            System.out.println("Поиск перебором: номер найден, поиск занял " + end + "нс");
        } else {
            System.out.println("Поиск перебором: номер не найден, поиск занял " + end + "нс");
        }


        List<String> numbersSorted = new ArrayList<>(numbers);
        Collections.sort(numbersSorted);

        start = System.nanoTime();
        listHasNumber = CoolNumbers.binarySearchInList(numbersSorted,"С777ТЕ168");
        end = System.nanoTime() - start;
        if (listHasNumber) {
            System.out.println("Бинарный поиск: номер найден, поиск занял " + end + "нс");
        } else {
            System.out.println("Бинарный поиск: номер не найден, поиск занял " + end + "нс");
        }

        HashSet<String> numbersSet = new HashSet<>(numbers);
        start = System.nanoTime();
        listHasNumber = CoolNumbers.searchInHashSet(numbersSet, "С777ТЕ168");
        end = System.nanoTime() - start;

        if (listHasNumber) {
            System.out.println("Поиск в HashSet: номер найден, поиск занял " + end + "нс");
        } else {
            System.out.println("Поиск в HashSet: номер не найден, поиск занял " + end + "нс");
        }

        TreeSet<String> treeSet = new TreeSet<>(numbers);

        start = System.nanoTime();
        listHasNumber = CoolNumbers.searchInTreeSet(treeSet, "С777ТЕ168");
        end = System.nanoTime() - start;

        if (listHasNumber) {
            System.out.println("Поиск в TreeSet: номер найден, поиск занял " + end + "нс");
        } else {
            System.out.println("Поиск в TreeSet: номер не найден, поиск занял " + end + "нс");
        }
    }
}
