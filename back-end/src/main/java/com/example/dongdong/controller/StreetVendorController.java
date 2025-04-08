package com.example.dongdong.controller;

import com.example.dongdong.model.StreetVendor;
import com.example.dongdong.repository.StreetVendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
@RequiredArgsConstructor
public class StreetVendorController {

    private final StreetVendorRepository repository;

    @GetMapping
    public List<StreetVendor> getAllVendors() {
        return repository.findAll();
    }
}