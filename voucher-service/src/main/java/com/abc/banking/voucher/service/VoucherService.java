package com.abc.banking.voucher.service;

import java.util.List;

import com.abc.banking.voucher.model.Voucher;
import com.abc.banking.voucher.repository.VoucherRepository;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VoucherService {

    @Value("${vendor.service.url}")
    private String vendorServiceUrl;

    private final StringEncryptor stringEncryptor;
    private final RestTemplate restTemplate;
    private final VoucherRepository repository;

    public VoucherService(
            VoucherRepository repository, 
            RestTemplate restTemplate,
            StringEncryptor stringEncryptor) {
        this.repository = repository;
        this.restTemplate = restTemplate;
        this.stringEncryptor = stringEncryptor;
    }

    public List<Voucher> getByPhone(String phone) {
        List<Voucher> result = repository.findByPhone(phone);
        result.forEach(v -> v.setCode(stringEncryptor.decrypt(v.getCode())));
        return result;
    }

    public Voucher getCode(Voucher newVoucher) {
        ResponseEntity<String> response = restTemplate.getForEntity(
            vendorServiceUrl + "/get-voucher-code",
            String.class
        );
        newVoucher.setCode(stringEncryptor.encrypt(response.getBody()));
        Voucher voucher = repository.save(newVoucher);
        voucher.setCode(stringEncryptor.decrypt(voucher.getCode()));
        return voucher;
    }
}
