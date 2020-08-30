package com.abc.banking.voucher.service;

import java.util.List;

import com.abc.banking.voucher.model.Voucher;
import com.abc.banking.voucher.repository.VoucherRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VoucherService {

    @Value("${vendor.service.url}")
    private String vendorServiceUrl;

    private final RestTemplate restTemplate;

    private final VoucherRepository repository;

    public VoucherService(VoucherRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public List<Voucher> getByPhone(String phone) {
        return repository.findByPhone(phone);
    }

    public Voucher getCode(Voucher newVoucher) {
        ResponseEntity<String> response = restTemplate.getForEntity(
            vendorServiceUrl + "/get-voucher-code",
            String.class
        );
        newVoucher.setCode(response.getBody());
        return repository.save(newVoucher);
    }
}
