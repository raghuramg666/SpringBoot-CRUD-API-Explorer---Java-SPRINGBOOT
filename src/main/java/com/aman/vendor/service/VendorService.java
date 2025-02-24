package com.aman.vendor.service;

import com.aman.vendor.entity.Vendor;
import com.aman.vendor.exception.VendorException;
import com.aman.vendor.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    public  String generateUniqueCode() {
        UUID uuid = UUID.randomUUID();
        String uniqueCode = uuid.toString().replaceAll("-", "");
        return uniqueCode;
    }
    public List<Vendor> getAll(){
        return vendorRepository.findAll();
    }
    public Vendor getById(Long id){
        Optional<Vendor> vendor = vendorRepository.findById(id);
        if(vendor.isPresent()) {
            return vendor.get();
        }
        //TODO
        throw new VendorException("Wallet with "+id+" does not exist");
    }
    public Vendor createOrUpdate(Vendor vendor){
        if(vendor.getId()==null){
            vendor.setUnique_code(generateUniqueCode());
            vendorRepository.save(vendor);
        }
        else{
            vendorRepository.save(vendor);
        }
        return vendor;
    }

    public boolean delete(Long id){
        Optional<Vendor> vendor = vendorRepository.findById(id);
        if(vendor.isPresent()) {
            vendorRepository.delete(vendor.get());
            return true;
        }
        //TODO
        throw new VendorException("Wallet with "+id+" does not exist");
    }
}
