package com.example.osnovi_algoritmov_pravilno;

import java.util.Arrays;
import java.util.Random;


public class IntegerListImpl implements IntegerList {
    private Integer[] integerList;
    private int size;
    private static final int BUFFER = 5;

    public IntegerListImpl(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        this.size = size;
        this.integerList = createArray(size);
    }

    private Integer[] createArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
        return array;
    }

    @Override
    public Integer add(Integer item) {
        checkItem(item);
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] == 0) {
                integerList[i] = item;
                return item;
            }
        }
        int index = integerList.length;
        integerList = extendArray(integerList);
        integerList[index] = item;
        return item;
    }

    private Integer[] extendArray(Integer[] array) {
        Integer[] newArray = createArray(array.length + BUFFER);
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkLenght(index);
        checkItem(item);
        int lastIndex = integerList.length - 1;
        if (!lastElementIsEmpty(integerList)) {
            integerList = extendArray(integerList);
            lastIndex = integerList.length;
        }
        for (int i = lastIndex; i >= 0; i--) {
            if (i > index) {
                integerList[i] = integerList[i - 1];
            }
        }
        integerList[index] = item;
        return item;
    }

    private boolean lastElementIsEmpty(Integer[] array) {
        return array[array.length - 1] == null;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkLenght(index);
        checkItem(item);
        integerList[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        checkItem(item);
        if (!contains(item)) {
            throw new IllegalArgumentException();
        }
        int index = indexOf(item);
        if (index == integerList.length - 1) {
            integerList[index] = null;
            return item;
        }
        for (int i = index; i < integerList.length - 1; i++) {
            integerList[i] = integerList[i + 1];
        }
        return item;
    }

    @Override
    public Integer remove(int index) {
        checkLenght(index);
        Integer item = get(index);
        if (index == integerList.length - 1) {
            integerList[index] = null;
            return item;
        }
        for (int i = index; i < integerList.length - 1; i++) {
            integerList[i] = integerList[i + 1];
        }
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        checkItem(item);
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        checkItem(item);
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        checkItem(item);
        for (int i = integerList.length - 1; i >= 0; i--) {
            if (integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkLenght(index);
        return integerList[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("некорректно введены данные");
        }
        for (int i = 0; i < integerList.length; i++) {
            if (!integerList[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        int factSize = 0;
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] != null) {
                factSize++;
            }
        }
        return factSize;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(integerList, null);
    }

    @Override
    public Integer[] toArray() {
        Integer[] integers = new Integer[integerList.length];
        for (int i = 0; i < integerList.length; i++) {
            integers[i] = integerList[i];
        }
        return integers;
    }


    private void checkItem(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Некорректно введены данные");
        }
    }

    private void checkLenght(int index) {
        if (index > integerList.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("элемент выходит за рамки массива");
        }
    }

    @Override
    public String toString() {
        return "IntegerListImpl{" +
                "integerList=" + Arrays.toString(integerList) +
                ", size=" + size +
                '}';
    }

    public static Integer[] toRanndomArray() {
        Integer[] integers = new Integer[100000];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = new Random().nextInt(1000);
        }
        return integers;
    }

    ///сортировка вставкой
    private static void sortInsertion(Integer[] integers) {
        for (int i = 1; i < integers.length; i++) {
            int temp = integers[i];
            int j = i;
            while (j > 0 && integers[j - 1] >= temp) {
                integers[j] = integers[j - 1];
                j--;
            }
            integers[j] = temp;
        }
    }

    /// пузырьковая сортировка
    public static void sortBubble(Integer[] integers) {
        for (int i = 0; i < integers.length; i++) {
            for (int j = 0; j < integers.length - 1 - i; j++) {
                if (integers[i] > integers[j + 1]) {
                    swapElements(integers, j, j + 1);
                }
            }
        }
    }


    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    ////сортировка выбором
    public static void sortSelection(Integer[] integers) {
        for (int i = 0; i < integers.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < integers.length; j++) {
                if (integers[j] < integers[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(integers, i, minElementIndex);
        }
    }

    private static int binarySearch(Integer[] integers, Integer item) {
        IntegerListImpl.sortInsertion(integers);
        return Arrays.binarySearch(integers, item);
    }

    public static void main(String[] args) {
        Integer[] integers1 = IntegerListImpl.toRanndomArray();
        Integer[] integers2 = IntegerListImpl.toRanndomArray();
        Integer[] integers3 = IntegerListImpl.toRanndomArray();
        long start1 = System.currentTimeMillis();
        sortInsertion(integers1);
        System.out.println("Сортировка вставками - " + (System.currentTimeMillis() - start1));
        long start2 = System.currentTimeMillis();
        sortSelection(integers2);
        System.out.println("Сортирвка выбором - " + (System.currentTimeMillis() - start2));
        long start3 = System.currentTimeMillis();
        sortBubble(integers2);
        System.out.println("Сортировка пузырьком - " + (System.currentTimeMillis() - start3));

    }


}
