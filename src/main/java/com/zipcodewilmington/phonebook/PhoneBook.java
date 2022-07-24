package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNum) {
        List<String> phoneNumList = new ArrayList<>();
        phoneNumList.add(phoneNum);
        this.phonebook.put(name, phoneNumList);
    }

    public void addAll(String name, String... phoneNum) {
        List<String> list = Arrays.asList(phoneNum);
        List<String> phoneNumList = new ArrayList<>(list);
        this.phonebook.put(name, phoneNumList);
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        if (phonebook.containsKey(name)) {
            return true;
        }
        return false;
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNum) {
        for ( Map.Entry<String, List<String>> entry : phonebook.entrySet() ) {
            for ( String number : entry.getValue() ) {
                if ( number.equals(phoneNum) ) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        return new LinkedList<>(this.phonebook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
