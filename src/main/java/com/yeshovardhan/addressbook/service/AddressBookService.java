package com.yeshovardhan.addressbook.service;

import com.yeshovardhan.addressbook.dto.AddressBookDTO;
import com.yeshovardhan.addressbook.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AddressBookService {

    private final List<AddressBook> addressBookList = new ArrayList<>();
    private final AtomicInteger idGenerator = new AtomicInteger(0);

    public List<AddressBook> getAll() {
        return addressBookList;
    }

    public AddressBook getById(int id) {
        return addressBookList.stream()
                .filter(entry -> entry.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public AddressBook add(AddressBookDTO dto) {
        AddressBook entry = new AddressBook();
        addressBookList.add(entry);
        return entry;
    }

    public AddressBook update(int id, AddressBookDTO dto) {
        AddressBook existing = getById(id);
        if (existing != null) {
            existing.setName(dto.getName());
            existing.setAddress(dto.getAddress());
        }
        return existing;
    }

    public boolean delete(int id) {
        return addressBookList.removeIf(entry -> entry.getId() == id);
    }
}
