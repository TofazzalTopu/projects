package com.info.MongoDBDemo.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mdtofazzal.hossain on 3/27/2019.
 */
public class PersonTest {
    private Person person = new Person("Tofazzal", "Hossain", 20);

    @Test
    public void getFirstName() throws Exception {
        assertEquals("Tofazzal", person.getFirstName());
        assertEquals(20, person.getAge());

    }

    @Test
    public void getLastName() throws Exception{
        assertEquals("Hossain", person.getLastName());
    }
    @Test
    public void isHappy() throws Exception {
        assertFalse(person.isHappy());
    }
    @Test
    public void testHappy() throws Exception {
        person.unHappy();
        assertTrue(person.isHappy());
    }


}