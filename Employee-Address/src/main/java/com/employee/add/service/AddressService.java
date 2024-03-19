package com.employee.add.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.add.entity.Address;
import com.employee.add.entity.AddressResponse;
import com.employee.add.repository.AddressRepo;

@Service
public class AddressService {
	 @Autowired
	    private AddressRepo addressRepo;
	 
	    @Autowired
	    private ModelMapper mapper;
	 
	    public AddressResponse findAddressByEmployeeId(int employeeId) {
	      java.util.Optional<Address> addressByEmployeeId = addressRepo.findAddressByEmployeeId(employeeId);
	        AddressResponse addressResponse = mapper.map(addressByEmployeeId, AddressResponse.class);
	        return addressResponse;
	    }

}
