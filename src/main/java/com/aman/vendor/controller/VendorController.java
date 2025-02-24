package com.aman.vendor.controller;

import com.aman.vendor.entity.Vendor;
import com.aman.vendor.service.ValidationErrorService;
import com.aman.vendor.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;
    @Autowired
    private ValidationErrorService validationService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(vendorService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(vendorService.getById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Vendor vendor, BindingResult result){

        ResponseEntity errors = validationService.validate(result);
        if(errors!=null) return errors;

        Vendor vendorSaved = vendorService.createOrUpdate(vendor);

        return new ResponseEntity<Vendor>(vendorSaved,HttpStatus.CREATED);

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Vendor vendor, BindingResult result){

        ResponseEntity errors = validationService.validate(result);
        if(errors!=null) return errors;

        vendor.setId(id);
        Vendor vendorSaved = vendorService.createOrUpdate(vendor);

        return new ResponseEntity<Vendor>(vendorSaved,HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        vendorService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    


}
