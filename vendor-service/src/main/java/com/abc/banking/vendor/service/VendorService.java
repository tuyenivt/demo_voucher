package com.abc.banking.vendor.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VendorService {

    @Value("${vendor.voucher.url}")
    private String vendorVoucherUrl;

    private final RestTemplate restTemplate;

    public VendorService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getCode() {
        ResponseEntity<String> response = restTemplate.getForEntity(vendorVoucherUrl, String.class);
        return response.getBody();
    }

    public String getVendorVoucherUrl() {
        return vendorVoucherUrl;
    }
}
