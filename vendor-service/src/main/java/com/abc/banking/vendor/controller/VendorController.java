package com.abc.banking.vendor.controller;

import com.abc.banking.vendor.service.VendorService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {

    private final VendorService service;

    public VendorController(VendorService service) {
        this.service = service;
    }

    @GetMapping("/get-voucher-code")
    public String code() {
        return service.getCode();
    }
}
