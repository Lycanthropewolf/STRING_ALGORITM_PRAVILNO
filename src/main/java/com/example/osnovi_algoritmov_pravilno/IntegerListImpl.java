package com.example.osnovi_algoritmov_pravilno;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private Integer[] integerList;
    private int size;

    public IntegerListImpl(Integer[] integerList) {
        this.integerList = integerList;
    }

    public IntegerListImpl(int size) {
        this.integerList = new Integer[size];
    }

    public IntegerListImpl() {
        this.integerList = new Integer[10];
    }

    @Override
    public Integer add(Integer item) {
        checkItem(item);
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] == null) {
                integerList[i] = item;
                return item;
            }
        }
        return null;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkLenght(index);
        checkItem(item);
        for (int i = integerList.length - 1; i >= 0; i--) {
            if (i > index) {
                integerList[i] = integerList[i - 1];
            }
        }
        integerList[index] = item;
        return null;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkLenght(index);
        checkItem(item);
        integerList[index] = item;
        return null;
    }

    @Override
    public Integer remove(Integer item) {
        checkItem(item);
        for (int i = 0; i < integerList.length; i++) {
            if (!integerList[i].equals(item)) {
                throw new IllegalArgumentException("нет такого значения в массиве");
            } else {
                integerList[i] = null;
                return item;
            }
        }
        return null;
    }

    @Override
    public Integer remove(int index) {
        checkLenght(index);
        return integerList[index] = null;
    }

    @Override
    public boolean contains(Integer item) {
        checkItem(item);
        return null;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] != null && integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = integerList.length - 1; i >= 0; i--) {
            if (integerList[i] != null && integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        return integerList[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("некорректно введены данные");
        }
        for (int i = 0; i < integerList.length; i++) {
            if (integerList[i] != null || otherList.get(i) != null) {
                if (!integerList[i].equals(otherList.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int size() {
        int factSize = 0;
        for (int i = 0; i < integerList.length; i++) {
            if (integerList != null) {
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
        return Arrays.copyOf(integerList, integerList.length);
    }

    private void checkItem(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Некорректно введены данные");
        }
    }

    private void checkLenght(int index) {
        if (index > integerList.length) {
            throw new ArrayIndexOutOfBoundsException("элемент выходит за рамки массива");
        }
    }

    @Override
    public String toString() {
        return "IntegerListImpl{" +
                "integerList=" + Arrays.toString(integerList) +
                '}';
    }
}
