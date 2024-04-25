/*
    Author: Ally Miller
    Date: 4/13/2024
    Description: Contact Test for testing of Contact
 */
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {
    @Test
    public void testCreatingContactObject() {
        // Test creating a valid contact object
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Baker St");
        assertEquals("12345", contact.getID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals("123 Baker St", contact.getAddress());
    }

    @Test
    public void testErrorIfContactIdIsTooLong() {
        // Test if an error occurs if the contact ID is too long
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345678901", "John", "Doe", "1234567890", "123 Baker St"));
    }

    @Test
    public void testErrorIfContactLastNameIsTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Doeeeeeeeeee", "1234567890", "123 Baker St"));
    }

    @Test
    public void testErrorIfPhoneNumberIsTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Doe", "12345678901", "123 Baker St"));
    }

    @Test
    public void testErrorIfAddressIsTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Doe", "1234567890", "1234567890123456789012345678901"));
    }

    @Test
    public void testNullID() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "John", "Doe", "1234567890", "123 Baker St"));
    }

    @Test
    public void testNullFirstName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", null, "Doe", "1234567890", "123 Baker St"));
    }

    @Test
    public void testNullLastName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", null, "1234567890", "123 Baker St"));
    }

    @Test
    public void testNullPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Doe", null, "123 Baker St"));
    }

    @Test
    public void testNullAddress() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Doe", "1234567890", null));
    }

}