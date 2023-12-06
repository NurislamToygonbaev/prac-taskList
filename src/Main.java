import Model.Contact;
import Model.Phone;
import services.ContactService;
import services.impl.ContactServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanForNum = new Scanner(System.in);
        ContactService able = new ContactServiceImpl();
        ArrayList<Contact> contacts = new ArrayList<>(Arrays.asList(
                new Contact(500500500, "Nurkamil", 1),
                new Contact(770707070, "Nurislam", 2)
        ));
        Phone phone = new Phone("Apple", "iphone", "1234", contacts);
        able.add(phone);

        outerLoop:
        while (true) {
            System.out.print("enter button (on/of) : ");
            String button = scanner.nextLine();
            switch (button.toLowerCase()) {
                case "on" -> {
                    while (true) {
                        String turnOnOff = able.turnOn();
                        if (turnOnOff.equalsIgnoreCase("1")) {
                            System.out.println("welcome");
                            innerLoop:
                            while (true) {
                                menu();
                                System.out.print("Commands: ");
                                switch (scanner.nextLine().toLowerCase()) {
                                    case "1" -> able.getAll();
                                    case "2" -> {
                                        System.out.print("enter ID contact: ");
                                        long id = scanForNum.nextLong();
                                        able.getContactById(id);
                                    }
                                    case "3" -> {
                                        System.out.print("enter ID contact: ");
                                        long id = scanForNum.nextLong();
                                        System.out.println(able.update(id));
                                    }
                                    case "4" -> {
                                        System.out.print("enter ID contact: ");
                                        long id = scanForNum.nextLong();
                                        System.out.println(able.deleteContact(id));
                                    }
                                    case "5" -> {
                                        System.out.print("enter phone number: ");
                                        long id = scanForNum.nextLong();
                                        if (able.call(id) == null) System.out.println("incorrect number phone");
                                        else System.out.println("soedinenie");
                                    }
                                    case "6" -> {
                                        System.out.print("enter name contact: ");
                                        String name = scanner.nextLine();
                                        if (able.call(name) == null) System.out.println("incorrect name");
                                        else System.out.println("soedinenie");
                                    }
                                    case "7" -> {
                                        break innerLoop;
                                    }
                                    default -> System.out.println("enter right choice");
                                }
                            }
                        } else if (turnOnOff.equalsIgnoreCase("2")) {
                            System.exit(0);
                        }
                        else if (turnOnOff.equalsIgnoreCase("0")) {
                            System.out.println("povtorite");
                        }
                    }
                }
                case "off" -> {
                    break outerLoop;
                }
                default -> System.out.println("enter right choice");
            }
        }
    }


    private static void menu() {
        System.out.println("""
                1. get all contacts
                2. get contact by Id
                3. update name
                4. delete contact
                5. call by phone number
                6. call by full name
                7. exit
                """);
    }
}