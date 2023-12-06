package services.impl;

import Model.Contact;
import Model.Phone;
import db.DateBase;
import services.ContactService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactServiceImpl implements ContactService {

    DateBase dateBase = new DateBase();

    @Override
    public String add(Phone phone) {
        dateBase.phones.add(phone);
        return "Success";
    }

    @Override
    public void getAll() {
        for (Phone phone : dateBase.phones) {
            System.out.println(phone.contacts);
        }
    }

    @Override
    public void getContactById(long id) {
        for (Phone phone : dateBase.phones) {
            for (Contact contact : phone.contacts) {
                if (contact.getId() == id) {
                    System.out.println(contact);
                }
            }
        }
    }

    @Override
    public String update(long id) {
        for (Phone phone : dateBase.phones) {
            for (Contact contact : phone.contacts) {
                if (contact.getId() == id) {
                    System.out.print("enter name: ");
                    String name = new Scanner(System.in).nextLine();
                    contact.setFullName(name);
                }
            }
        }
        return "success";
    }

    @Override
    public String deleteContact(long id) {
        for (Phone phone : dateBase.phones) {
            phone.contacts.removeIf(contact -> contact.getId() == id);
        }
        return "Success";
    }

    @Override
    public String turnOn() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (count < 4) {
            System.out.print("enter password: ");
            String pass = scanner.nextLine();
            for (Phone phone : dateBase.phones) {
                if (phone.getPassword().equalsIgnoreCase(pass)) {
                    return "1";
                } else {
                    count++;
                }
            }
            if (count==3){
                return "2";
            }
        }
        return "0";
    }

    @Override
    public Contact call(long number) {
        for (Phone phone : dateBase.phones) {
            for (Contact contact : phone.contacts) {
                if (contact.getPhoneNumber() == number) {
                    return contact;
                }
            }
        }
        return null;
    }

    @Override
    public Contact call(String number) {
        for (Phone phone : dateBase.phones) {
            for (Contact contact : phone.contacts) {
                if (contact.getFullName().equalsIgnoreCase(number)) {
                    return contact;
                }
            }
        }
        return null;
    }
}
