package services;

import Model.Contact;
import Model.Phone;

public interface ContactService {
    String add(Phone phone);
    void getAll();
    void getContactById(long id);
    String update(long id);
    String deleteContact(long id);
    String turnOn();
    Contact call(long number);
    Contact call(String fullName);
}
