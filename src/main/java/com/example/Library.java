package com.example;
import java.util.*;
public class Library {

    private Map<String, Contact> contacts =  new HashMap<>();

    public void addContact (Contact contact){
        Contact existingContact = contacts.get(contact.getEmail());
        if(existingContact != null){
            System.out.println("Контакт с email '" + contact.getEmail() + "' уже существует!");
        }else{
            contacts.put(contact.getEmail(), contact);
            System.out.println("Успешно добавлен!");
        }
    }

    public boolean deleteContact (String email){
        Iterator<Map.Entry<String, Contact>> iterator = contacts.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Contact> entry = iterator.next();
            if (entry.getKey().equalsIgnoreCase(email.trim())){
                iterator.remove();
                return  true;
            }
        }return  false;
    }

    public void viewContact (){
        for(Map.Entry<String, Contact> entry : contacts.entrySet()){
            System.out.println(entry.getValue());
        }if(contacts.size() <= 0){
            System.out.println("Список пуст!");
        }
    }

    public void searchContact (String phone){
        boolean found = false;
        if (contacts.isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        for(Map.Entry<String, Contact> entry : contacts.entrySet()) {
            if (entry.getValue().getPhone().equals(phone)) {
                System.out.println(entry.getValue());
                found = true;
            }
        }if(!found){
            System.out.println("Такого пользователя не существует!");
        }
    }

    public void groupContact (String group){
        boolean found = false;
        if (contacts.isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        for(Map.Entry<String, Contact> entry : contacts.entrySet()) {
            if (entry.getValue().getGroup().equals(group)) {
                System.out.println(entry.getValue());
                found = true;
            }

        }if (!found) {
            System.out.println("Такого пользователя не существует!");
        }
    }
}
