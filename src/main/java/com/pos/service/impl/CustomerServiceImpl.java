package com.pos.service.impl;

import com.pos.dto.CustomerDto;
import com.pos.entity.Customer;
import com.pos.repo.CustomerRepo;
import com.pos.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<Boolean> addCustomer(CustomerDto customerDto) {

        Customer customer = modelMapper.map(customerDto, Customer.class);
        try {
            Customer cus = customerRepo.save(customer);
            if (cus.getCustomer_id() != null)
                return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException("Can't be Added Customer");
        }
        throw new RuntimeException("Can't be Added Customer");
    }

    @Override
    public ResponseEntity<Boolean> deleteCustomer(Integer customerId) {
        try {
            customerRepo.deleteById(customerId);
        }catch (NullPointerException e){
            throw new NullPointerException("Customer id should be not null");
        }catch (Exception e){
        }
        return null;
    }

    @Override
    public ResponseEntity<CustomerDto> updateCustomer(CustomerDto customerDto) {
        Customer customer=modelMapper.map(customerDto,Customer.class);
        customerRepo.save(customer);
        return null;
    }

    @Override
    public ResponseEntity<List<CustomerDto>> getAllCustomer() {
        List<Customer> all = customerRepo.findAll();
        CustomerDto map = modelMapper.map(all, CustomerDto.class);
        return null;
    }

    @Override
    public ResponseEntity<CustomerDto> searchCustomer(String customerName) {
        customerRepo.searchCustomerName(customerName);
        return null;
    }
}
