package com.pos.service.impl;

import com.pos.dto.SupplierDto;
import com.pos.entity.Supplier;
import com.pos.repo.SupplierRepo;
import com.pos.service.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<SupplierDto> addSupplier(SupplierDto supplierDto) {
        Supplier supplier=modelMapper.map(supplierDto, Supplier.class);
        Supplier sup = supplierRepo.save(supplier);
        return null;
    }

    @Override
    public ResponseEntity<SupplierDto> deleteSupplier(Integer supplierId) {
        supplierRepo.deleteById(supplierId);
        return null;
    }

    @Override
    public ResponseEntity<SupplierDto> updateSupplier(SupplierDto supplierDto) {
        Supplier supplier=modelMapper.map(supplierDto,Supplier.class);
        Supplier sup = supplierRepo.save(supplier);
        return null;
    }

    @Override
    public ResponseEntity<List<SupplierDto>> getAllSupplier() {
        List<Supplier> supplierList = supplierRepo.findAll();
        return null;
    }

    @Override
    public ResponseEntity<SupplierDto> searchSupplier(String supplierName) {
        Supplier supplier = supplierRepo.searchSupplier(supplierName);
        SupplierDto supplierDto = modelMapper.map(supplier, SupplierDto.class);
        return new ResponseEntity<SupplierDto>(supplierDto, HttpStatus.OK);
    }
}
