package com.example.osnovi_algoritmov_pravilno;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringListImplTest {

    private StringListImpl expected;
    private StringListImpl actual;

    @BeforeEach
    public void setUp() {
        expected = new StringListImpl(10);
        String string1 = "s1";
        String string2 = "s2";
        String string3 = "s3";
        String string4 = "s4";
        expected.add(string1);
        expected.add(string2);
        expected.add(string3);
        expected.add(string4);
        actual = new StringListImpl(10);
        actual.add(string1);
        actual.add(string2);
        actual.add(string3);
        actual.add(string4);
    }

    @Test
    public void addString() {
        StringListImpl stringList1 = new StringListImpl(10);
        String string1 = "s1";
        String string2 = "s2";
        String string3 = "s3";
        String string4 = "s4";
        stringList1.add(string1);
        stringList1.add(string2);
        stringList1.add(string3);
        stringList1.add(string4);
        assertTrue(expected.equals(stringList1));
    }

    @Test
    public void addByIndex() {
        expected.add(1, "set");
        actual.add(1, "set");
        assertTrue(expected.equals(actual));
    }

    @Test
    public void set() {
        expected.set(1, "s1");
        actual.set(1, "s1");
        assertTrue(expected.equals(actual));
    }

    @Test
    public void removeByIndex() {
        expected.remove(1);
        actual.remove(1);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void removeByString() {
        expected.remove("s1");
        actual.remove("s1");
        assertTrue(expected.equals(actual));
    }

    @Test
    public void contains() {
        assertTrue(actual.contains("s4"));
    }

    @Test
    public void indexOf() {
        assertEquals(expected.indexOf("s1"), 0);
    }

    @Test
    public void lastIndexOf() {
        assertEquals(expected.indexOf("s2"), 1);
    }

    @Test
    public void get() {
        assertEquals(expected.indexOf("s1"), 0);
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
        String[] strings1 = expected.toArray();
        String[] strings2 = new String[10];
        strings2[0]="s1";
        strings2[1]="s2";
        strings2[2]="s3";
        strings2[3]="s4";
        strings2[4]="";
        strings2[5]="";
        strings2[6]="";
        strings2[7]="";
        strings2[8]="";
        strings2[9]="";
        assertArrayEquals(strings1,strings2);
    }
}
