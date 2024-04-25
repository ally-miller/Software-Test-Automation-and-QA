import java.util.HashMap;
/*
    Author: Ally Miller
    Date: 4/13/2024
    Description: Contact Service class stores contacts in a map<ID, Contact> and allows for adding, deleting,
    updating the contact
 */
import java.util.Map;

public class ContactService
{
    //Map<Key, Value>
    //Map<String, Contact>
    private final Map<String, Contact> contacts = new HashMap<>();

    //adds contact to contacts map
    public boolean addContact(Contact contact)
    {
        if(contact != null)
        {
            // add contact to contacts Map<Id, Contact>
            // if already in map, put returns the contact, which is != null so returns false
            // if not in map, put adds to Map and returns null, which null == null so returns true
            return contacts.put(contact.getID(), contact) == null;
        }
        // if contact is null, return false
        return false;
    }

    //deletes contact from contacts map
    public void deleteContact(String contactID)
    {
        contacts.remove(contactID);
    }

    //updates contact in contacts map
    public void updateContact(String contactID, String firstName, String lastName, String phoneNumber, String address)
    {
        Contact contact = contacts.get(contactID);
        if(contact != null)
        {
            contact.setFirstName(firstName);
            contact.setLastName(lastName);
            contact.setPhoneNumber(phoneNumber);
            contact.setAddress(address);
        }
    }

    public Contact getContact(String number) {
        return contacts.get(number);
    }
}
