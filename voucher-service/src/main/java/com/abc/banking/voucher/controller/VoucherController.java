package com.abc.banking.voucher.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.abc.banking.voucher.model.Voucher;
import com.abc.banking.voucher.service.VoucherService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoucherController {

    private final VoucherService service;

    public VoucherController(VoucherService service) {
        this.service = service;
    }

    @GetMapping("/vouchers")
    public List<Voucher> byPhone(@RequestParam Optional<String> phone) {
        return phone.map(service::getByPhone).orElseGet(Collections::emptyList);
    }

    @PostMapping("/vouchers")
    public Voucher newVoucher(@RequestBody Voucher newVoucher) {
        return service.getCode(newVoucher);
    }
}
