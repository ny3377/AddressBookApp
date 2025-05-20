package com.yeshovardhan.addressbook.service;

import com.yeshovardhan.addressbook.model.AddressBook;
import com.yeshovardhan.addressbook.dto.AddressBookDTO;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AddressBookService {
    private final List<AddressBook> addressBookList = new ArrayList<>();
    private int counter = 1;

    public List<AddressBook> getAll() {
        return addressBookList;
    }

    public AddressBook getById(int id) {
        return addressBookList.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    public AddressBook add(AddressBookDTO dto) {
        AddressBook ab = new AddressBook(counter++, dto.getName(), dto.getAddress());
        addressBookList.add(ab);
        return ab;
    }

    public AddressBook update(int id, AddressBookDTO dto) {
        AddressBook ab = getById(id);
        if (ab != null) {
            ab.setName(dto.getName());
            ab.setAddress(dto.getAddress());
        }
        return ab;
    }

    public boolean delete(int id) {
        return addressBookList.removeIf(ab -> ab.getId() == id);
    }
}
