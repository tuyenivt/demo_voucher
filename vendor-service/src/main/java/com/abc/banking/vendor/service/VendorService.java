package com.abc.banking.vendor.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VendorService {

    @Value("${vendor.voucher.url}")
    private String vendorVoucherUrl;

    public String getCode() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(vendorVoucherUrl, String.class);
        return response.getBody();
    }
}
