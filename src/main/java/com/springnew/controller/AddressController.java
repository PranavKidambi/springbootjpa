package com.springnew.controller;

import com.springnew.dto.AddressRequestDto;
import com.springnew.dto.AddressResponseDto;
import com.springnew.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="User APIs",description="operations related to APIs")
@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @Operation(summary="Create User")
    @PostMapping
    public AddressResponseDto createAddress(@Valid @RequestBody AddressRequestDto dto) {
        return addressService.createAddress(dto);
    }
    @Operation(summary="Get all Addresses")
    @GetMapping
    public List<AddressResponseDto> getAllAddresses() {
        return addressService.getAllAddresses();
    }
    @Operation(summary="Get Address by ID")
    @GetMapping("/{id}")
    public AddressResponseDto getAddressById(@PathVariable int id) {
        return addressService.getById(id);
    }
    @Operation(summary="Update Address by ID")
    @PutMapping("/{id}")
    public AddressResponseDto updateAddress(@PathVariable int id, @Valid @RequestBody AddressRequestDto dto) {
        return addressService.updateAddress(id, dto);
    }
    @Operation(summary="Patch Address by ID")
    @PatchMapping("/{id}")
    public AddressResponseDto patchAddress(@PathVariable int id, @RequestBody AddressRequestDto dto) {
        return addressService.updateAddress(id, dto);
    }
    @Operation(summary="Delete Address by ID")
    @DeleteMapping("/{id}")
    public boolean deleteAddress(@PathVariable int id) {
        return addressService.deleteAddress(id);
    }
}
