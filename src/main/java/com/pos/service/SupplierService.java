package com.pos.service;

import com.pos.dto.SupplierDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SupplierService {

    ResponseEntity<SupplierDto> addSupplier(SupplierDto supplierDto);

    ResponseEntity<SupplierDto> deleteSupplier(Integer supplierId);


    ResponseEntity<SupplierDto> updateSupplier(SupplierDto supplierDto);

    ResponseEntity<List<SupplierDto>> getAllSupplier();

    ResponseEntity<SupplierDto> searchSupplier(String supplierName);
}
