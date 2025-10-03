package com.example;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library();

    public static void main(String[] args) {

        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Меню ---");
            System.out.println("1: Добавить контакт");
            System.out.println("2: Удалить контакт");
            System.out.println("3: Посмотреть все контакты");
            System.out.println("4: Найти контакт по имени");
            System.out.println("5: Посмотреть контакты по группе");
            System.out.println("0: Выход");

            int choice = getIntInput();
            switch (choice) {
                case 1 -> {
                    System.out.println("Введите имя:");
                    String name = getNameInput();

                    System.out.println("Введите телефон:");
                    String phone = getPhoneInput();

                    System.out.println("Введите почту:");
                    String email = getEmailInput();

                    System.out.println("Введите группу:");
                    String group = getStringInput();

                    Contact contact = new Contact(name, phone, email, group);
                    library.addContact(contact);
                }
                case 2 -> {
                    System.out.println("Введите почту для удаления контакта");
                    String email = getEmailInput();
                    boolean delete = library.deleteContact(email);
                    if (delete) {
                        System.out.println("Контакт с email " + email + " успешно удален");
                    } else {
                        System.out.println("Контакт с email " + email + " не найден");
                    }
                }
                case 3 -> library.viewContact();
                case 4 -> {
                    System.out.println("Введите телефон для поиска контакта");
                    String phone = getPhoneInput();
                    library.searchContact(phone);

                }
                case 5 -> {
                    System.out.println("Введите группу для поиска контакта.");
                    String group = getStringInput();
                    library.groupContact(group);

                }
                case 0 -> {
                    exit = true;
                    System.out.println("До свидания!");
                }
            }
        }
        scanner.close();
    }

    public static int getIntInput() {
        while (true) {
            System.out.print("Выберите опцию (0-5): ");
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 0 && choice <= 5) {
                    return choice;
                } else {
                    System.out.println("Ошибка: число должно быть от 0 до 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: нужно ввести цифру.");
            }
        }
    }

    public static String getNameInput() {
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Ошибка: имя не может быть пустым.");
            } else if (!input.matches("[a-zA-Zа-яА-ЯёЁ\\s-]+")) {
                System.out.println("Ошибка: имя должно содержать только буквы, пробелы и дефис.");
            } else {
                return input;
            }
        }
    }

    public static String getPhoneInput() {
        while (true) {
            String phone = scanner.nextLine().trim();
            if (phone.isEmpty()) {
                System.out.println("Ошибка: номер телефона не может быть пустым. Попробуйте снова:");
            } else if (!phone.matches("\\+?\\d+")) {
                System.out.println("Ошибка: номер должен содержать только цифры (допускается '+' в начале). Попробуйте снова:");
            } else {
                return phone;
            }
        }
    }

    public static String getEmailInput() {
        while (true) {
            String email = scanner.nextLine().trim();
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            if (email.isEmpty()) {
                System.out.println("Ошибка: почта не может быть пустой. Попробуйте снова:");
            } else if (!email.matches(emailRegex)) {
                System.out.println("Ошибка: неверный формат почты (пример: user@example.com). Попробуйте снова:");
            } else {
                return email;
            }
        }
    }

    public static String getStringInput() {
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Ошибка: поле не может быть пустым.");
            } else {
                return input;
            }
        }
    }
}
