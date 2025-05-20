package com.yeshovardhan.addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yeshovardhan.addressbook.service.AddressBookService;
import com.yeshovardhan.addressbook.controller.*;
import com.yeshovardhan.addressbook.model.*;
import com.yeshovardhan.addressbook.dto.*;
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@Autowired
	private AddressBookService service;

	@GetMapping
	public ResponseEntity<List<AddressBook>> getAll() {
	    return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<AddressBook> getById(@PathVariable int id) {
	    return ResponseEntity.ok(service.getById(id));
	}

	@PostMapping
	public ResponseEntity<AddressBook> create(@RequestBody AddressBookDTO dto) {
	    return ResponseEntity.ok(service.add(dto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<AddressBook> update(@PathVariable int id, @RequestBody AddressBookDTO dto) {
	    return ResponseEntity.ok(service.update(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
	    boolean result = service.delete(id);
	    return result ? ResponseEntity.ok("Deleted") : ResponseEntity.notFound().build();
	}

    
}

