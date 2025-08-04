
package com.springnew.service;

import com.springnew.dto.AddressRequestDto;
import com.springnew.dto.AddressResponseDto;
import com.springnew.entity.Address;
import com.springnew.exception.ResourceNotFoundException;
import com.springnew.repository.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepo addressRepo;
    private final ModelMapper modelMapper;

    public AddressResponseDto createAddress(AddressRequestDto dto) {
        Address address = modelMapper.map(dto, Address.class);
        return modelMapper.map(addressRepo.save(address), AddressResponseDto.class);
    }

    public List<AddressResponseDto> getAllAddresses() {
        return addressRepo.findAll()
                .stream()
                .map(address -> modelMapper.map(address, AddressResponseDto.class))
                .collect(Collectors.toList());
    }

    public AddressResponseDto getById(int id) {
        Address address = addressRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address with ID " + id + " not found"));
        return modelMapper.map(address, AddressResponseDto.class);
    }

    public AddressResponseDto updateAddress(int id, AddressRequestDto dto) {
        Address address = addressRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address with ID " + id + " not found"));

        modelMapper.map(dto, address);
        return modelMapper.map(addressRepo.save(address), AddressResponseDto.class);
    }

    public boolean deleteAddress(int id) {
        Address address = addressRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address with ID " + id + " not found"));

        addressRepo.delete(address);
        return true;
    }
}
