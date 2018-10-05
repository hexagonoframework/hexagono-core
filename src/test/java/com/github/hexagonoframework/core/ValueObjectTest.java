package com.github.hexagonoframework.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValueObjectTest {

    String value = "Value";
    StringValueObject vo;

    @Test
    public void sameHashCode() {
        StringValueObject voOne = new StringValueObject(value);
        StringValueObject voTwo = new StringValueObject(value);
        assertEquals(voOne.hashCode(), voTwo.hashCode());
    }

    @Test
    public void differentHashCode() {
        StringValueObject voOne = new StringValueObject("Value One");
        StringValueObject voTwo = new StringValueObject("Value Two");
        assertNotEquals(voOne.hashCode(), voTwo.hashCode());
    }

    @Test
    public void equalsWithNull() {
        vo = new StringValueObject(value);
        assertFalse(vo.equals(null));
    }

    @Test
    public void equalsWithSameObject() {
        vo = new StringValueObject(value);
        assertTrue(vo.equals(vo));
    }

    @Test
    public void equalsWithSameValue() {
        vo = new StringValueObject(value);
        assertTrue(vo.equals(new StringValueObject(value)));
    }

    @Test
    public void equalsWithDifferentValue() {
        vo = new StringValueObject(value);
        assertFalse(vo.equals(new StringValueObject("Different Value")));
    }

    @Test
    public void equalsWithOtherType() {
        vo = new StringValueObject(value);
        assertFalse(vo.equals(new Object()));
    }

    private static class StringValueObject extends ValueObject<String> {

        public StringValueObject(String value) {
            super(value);
        }

    }
}
