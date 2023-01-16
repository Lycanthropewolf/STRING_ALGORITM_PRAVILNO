package com.example.osnovi_algoritmov_pravilno;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerListImplTest {

    private IntegerListImpl expected;
    private IntegerListImpl actual;

    @BeforeEach
    public void setUp() {
        expected = new IntegerListImpl(10);
        Integer integer1 = 1;
        Integer integer2 = 2;
        Integer integer3 = 3;
        Integer integer4 = 4;
        expected.add(integer1);
        expected.add(integer2);
        expected.add(integer3);
        expected.add(integer4);
        actual = new IntegerListImpl(10);
        actual.add(integer1);
        actual.add(integer2);
        actual.add(integer3);
        actual.add(integer4);
    }

    @Test
    public void addString() {
        IntegerListImpl integerList1 = new IntegerListImpl(10);
        Integer integer1 = 1;
        Integer integer2 = 2;
        Integer integer3 = 3;
        Integer integer4 = 4;
        integerList1.add(integer1);
        integerList1.add(integer2);
        integerList1.add(integer3);
        integerList1.add(integer4);
        assertTrue(expected.equals(integerList1));
    }

    @Test
    public void addByIndex() {
        expected.add(1, 1);
        actual.add(1, 1);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void set() {
        expected.set(1, 1);
        actual.set(1, 1);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void removeByIndex() {
        expected.remove(1);
        actual.remove(1);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void removeByInteger() {
        expected.remove(1);
        actual.remove(1);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void contains() {
        assertTrue(actual.contains(1));
    }

    @Test
    public void indexOf() {
        assertEquals(expected.indexOf(1), 0);
    }

    @Test
    public void lastIndexOf() {
        assertEquals(expected.indexOf(1), 0);
    }

    @Test
    public void get() {
        assertEquals(expected.indexOf(1), 0);
    }

    @Test
    public void equals() {
        assertTrue(expected.equals(actual));
    }

    @Test
    public void size() {
        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void isEmpty() {
        assertFalse(expected.isEmpty());
    }

    @Test
    public void clear() {
        expected.clear();
        assertTrue(expected.isEmpty());
    }

    @Test
    public void toArray() {
        Integer[] integers1 = expected.toArray();
        Integer[] integers2 = new Integer[10];
        integers2[0] = 1;
        integers2[1] = 2;
        integers2[2] = 3;
        integers2[3] = 4;
        integers2[4] = 0;
        integers2[5] = 0;
        integers2[6] = 0;
        integers2[7] = 0;
        integers2[8] = 0;
        integers2[9] = 0;
        assertArrayEquals(integers1, integers2);
    }
}
