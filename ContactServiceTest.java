/*
    Author: Ally Miller
    Date: 4/13/2024
    Description: Contact Service Test for testing ContactService
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    void setUp() {
        contactService = new ContactService();
    }

    @Test
    void testAddingSingleContact() {
        Assertions.assertTrue(contactService.addContact(new Contact("1", "John", "Doe", "1234567890", "123 Baker St")));
    }

    @Test
    void testAddingMultipleContacts() {
        Assertions.assertTrue(contactService.addContact(new Contact("1", "John", "Doe", "1234567890", "123 Baker St")));
        Assertions.assertTrue(contactService.addContact(new Contact("2", "Jane", "Doe", "0987654321", "321 Baker St")));
    }

    @Test
    void testErrorWhenAddingContactWithDuplicateID() {
        Assertions.assertTrue(contactService.addContact(new Contact("1", "John", "Doe", "1234567890", "123 Baker St")));
        Assertions.assertFalse(contactService.addContact(new Contact("1", "John", "Doe", "1234567890", "123 Baker St")));
    }

    @Test
    void testGettingContactBackFromService() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Baker St");
        contactService.addContact(contact);
        assertEquals(contact, contactService.getContact("1"));
    }

    @Test
    void testDeletingContact() {
        contactService.addContact(new Contact("1", "John", "Doe", "1234567890", "123 Baker St"));
        contactService.deleteContact("1");
        Assertions.assertNull(contactService.getContact("1"));
    }
    @Test
    void testUpdateContact() {
        contactService.addContact(new Contact("1", "John", "Doe", "1234567890", "123 Baker St"));
        contactService.updateContact("1", "Jane", "Doe", "0987654321", "321 Baker St");
        Contact updatedContact = contactService.getContact("1");
        assertNotNull(updatedContact);
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Doe", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhoneNumber());
        assertEquals("321 Baker St", updatedContact.getAddress());
    }

}
