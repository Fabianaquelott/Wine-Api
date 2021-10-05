package com.wine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wine.entity.SearchStoreEntity;
import com.wine.service.SearchStoreService;

import io.swagger.annotations.ApiOperation;

@RestController
public class SearchStoreController {

	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

	@Autowired
	private SearchStoreService searchStoreService;

	@ApiOperation(value = "POST save store data", notes = "This operation save a data of stores.")
	@PostMapping("/savestore")
	public ResponseEntity<String> saveStore(@RequestBody SearchStoreEntity storeEntity) {
		try {
			if (searchStoreService.saveStore(storeEntity)) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			String message = "Erro na requisição POST /api/savestore:" + e.getMessage();
			System.out.print(message);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "GET find store data", notes = "This operation find a list of stores.")
	@GetMapping("/findstore")
	public ResponseEntity<String> findStoreByCep(@RequestParam("zipCode") Integer zipCode) {
		try {
			List<SearchStoreEntity> result = searchStoreService.findStoreByCep(zipCode);
			return ResponseEntity.status(HttpStatus.OK).body(ow.writeValueAsString(result));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "DELETE store data", notes = "This operation delete a data of stores.")
	@DeleteMapping("/deletestore")
	public ResponseEntity<String> deleteStoreById(@RequestParam("id") Integer id) {
		try {
			searchStoreService.deleteStore(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "PUT update store data", notes = "This operation update a data of stores.")
	@PutMapping("/updatestore")
	public ResponseEntity<String> updateStoreById(@RequestParam("id") Integer id,
			@RequestBody SearchStoreEntity storeEntity) {
		try {
			if (searchStoreService.updateStore(id, storeEntity)) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			String message = "Erro na requisição POST /api/savestore:" + e.getMessage();
			System.out.print(message);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
