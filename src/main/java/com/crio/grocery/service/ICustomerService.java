package com.crio.grocery.service;

import com.crio.grocery.entity.dto.CustomerRequestDTO;
import com.crio.grocery.entity.dto.CustomerResponseDTO;
import java.util.List;

public interface ICustomerService {
    CustomerResponseDTO createCustomer(CustomerRequestDTO customerDTO);
    List<CustomerResponseDTO> getAllCustomers();
    CustomerResponseDTO getCustomerById(Integer id);
    CustomerResponseDTO updateCustomer(Integer id, CustomerRequestDTO customerDTO);
    void deleteCustomer(Integer id);
}
