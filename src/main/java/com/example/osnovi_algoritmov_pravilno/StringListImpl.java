package com.example.osnovi_algoritmov_pravilno;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private String[] stringList;
    private final int size;
    private static final int BUFFER = 5;
    private static final String WRONG_DATA_ENTERED = " Некорректно введены данные";

    public StringListImpl(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        this.size = size;
        this.stringList = createArray(size);
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i].isEmpty()) {
                stringList[i] = item;
                return item;
            }
        }
        int index = stringList.length;
        stringList = extendArray(stringList);
        stringList[index] = item;
        return item;
    }

    private String[] createArray(int size) {
        String[] array = new String[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = "";
        }
        return array;
    }

    private String[] extendArray(String[] array) {
        String[] newArray = createArray(array.length + BUFFER);
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    private boolean lastElementIsEmpty(String[] array) {
        return array[array.length - 1].isEmpty();
    }

    @Override
    public String add(int index, String item) {
        if (index >= stringList.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("элемент выходит за рамки массива");
        }
        if (item == null) {
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        int lastIndex = stringList.length - 1;
        if (!lastElementIsEmpty(stringList)) {
            stringList = extendArray(stringList);
            lastIndex = stringList.length;
        }
        for (int i = lastIndex; i >= 0; i--) {
            if (i > index) {
                stringList[i] = stringList[i - 1];
            }
        }
        stringList[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index >= stringList.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("элемент выходит за рамки массива");
        }
        if (item == null) {
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        stringList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        if (!contains(item)) {
            throw new ElementNotFoundException(item);
        }
        int index = indexOf(item);
        if (index == stringList.length - 1) {
            stringList[index] = "";
            return item;
        }
        for (int i = index; i < stringList.length - 1; i++) {
            stringList[i] = stringList[i + 1];
        }
        return item;
    }

    @Override
    public String remove(int index) {
        if (index >= stringList.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("элемент выходит за рамки массива");
        }
        String item = get(index);
        if (index == stringList.length - 1) {
            stringList[index] = "";
            return item;
        }
        for (int i = index; i < stringList.length - 1; i++) {
            stringList[i] = stringList[i + 1];
        }
        return item;
    }

    @Override
    public boolean contains(String item) {
        if (item == null) {
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        if (item == null) {
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item == null) {
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        for (int i = stringList.length - 1; i >= 0; i--) {
            if (stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= stringList.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("элемент выходит за рамки массива");
        }
        return stringList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException(WRONG_DATA_ENTERED);
        }
        for (int i = 0; i < stringList.length; i++) {
            if (!stringList[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        int factSize = 0;
        for (int i = 0; i < stringList.length; i++) {
            if (!stringList[i].isEmpty()) {
                factSize++;
            }
        }
        return factSize;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public void clear() {
        Arrays.fill(stringList, "");
    }

    @Override
    public String[] toArray() {
        String[] strings = new String[stringList.length];
        for (int i = 0; i < stringList.length; i++) {
            strings[i] = stringList[i];
        }
        return strings;
    }
}
